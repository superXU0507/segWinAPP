package segWinAPP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class saveFile {
	/*
	 * 文件保存类，将textOutputArea的文本保存到指定txt文件
	 */
	public void fileSave(String textOutput) {
		BufferedWriter bw = null;
		JFileChooser jf = new JFileChooser();
		jf.setSelectedFile(new File("新建文本文档.txt"));
		int returnVal = jf.showSaveDialog(null);	//showSaveDialog根据选择确定或取消返回不同的值
		
		File f = null;
		String fileName = null;
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {	//如果确定要保存文件
			f = jf.getSelectedFile();	//如果没有选中任何文件，jf.getName(File)将返回输入的文件名，仅仅是文件名，不是路径
			System.out.println(jf.getSelectedFile().getName());
		}else {
			return;		//否则退出文件选择界面
		}
		fileName = jf.getName(f);
		
		if(fileName == null||fileName.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "文件名为空！");
		}
		
		if(f.isFile()) {	//如果选中的file是个文件，设置文件名
			fileName = f.getName();
		}else {
			//否则是个文件夹
		}
		
		f = jf.getCurrentDirectory();	//获得当前目录名
		//选中文件的绝对路径，separator为当前平台的分隔符，避免了跨平台可能出现的路径名错误异常
		String path = f.getPath() + java.io.File.separator + fileName;
		f = new File(path);
		
		if(f.exists()) {	//若选择了已存在文件，或输入了和已存在文件相同的绝对路径名，询问是否覆盖
			int i = JOptionPane.showConfirmDialog(null, "该文件已存在，确定要覆盖吗？");
			if(i == JOptionPane.YES_OPTION) {
				//确定覆盖
			}
			else {
				return;	//否则退出保存界面
			}
		}
		
		try {	//向目标文件写入文本
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			bw.write(textOutput);
			bw.flush();
		}catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "文件保存出错" + e1.getMessage());
		}catch(IOException e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(bw != null) bw.close();
			}catch(IOException e1) {
				
			}
		}
	}
}
