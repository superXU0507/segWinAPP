package segWinAPP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class openFile {
	/*
	 * 文件打开类，打开文件选择窗口，将txt文件文本传入textArea
	 */
	private String txtInput; //从txt文件传入的文本
	public String getTxt() {
		return this.txtInput; //将txt的文本传递出去
	}
	
	public void chooseTxt() throws IOException{
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		chooser.setFileFilter(filter);	//文件选择器&文件过滤器，防止非法的其它格式文件输入
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal != JFileChooser.APPROVE_OPTION) {
			return;		//未选择则退出窗口
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line=reader.readLine()) != null) {
			sb.append(line);	//使用StringBuilder循环读取文本，较String对象有更少的占用
		}
		reader.close();
		
		this.txtInput = sb.toString();
	}
}
