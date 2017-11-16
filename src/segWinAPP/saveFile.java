package segWinAPP;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class saveFile {
	/*
	 * �ļ������࣬��textOutputArea���ı����浽ָ��txt�ļ�
	 */
	public void fileSave(String textOutput) {
		BufferedWriter bw = null;
		JFileChooser jf = new JFileChooser();
		jf.setSelectedFile(new File("�½��ı��ĵ�.txt"));
		int returnVal = jf.showSaveDialog(null);	//showSaveDialog����ѡ��ȷ����ȡ�����ز�ͬ��ֵ
		
		File f = null;
		String fileName = null;
		
		if(returnVal == JFileChooser.APPROVE_OPTION) {	//���ȷ��Ҫ�����ļ�
			f = jf.getSelectedFile();	//���û��ѡ���κ��ļ���jf.getName(File)������������ļ������������ļ���������·��
		}else {
			return;		//�����˳��ļ�ѡ�����
		}
		fileName = jf.getName(f);
		
		if(fileName == null||fileName.trim().length() == 0) {
			JOptionPane.showMessageDialog(null, "�ļ���Ϊ�գ�");
		}
		
		if(f.isFile()) {	//���ѡ�е�file�Ǹ��ļ��������ļ���
			fileName = f.getName();
		}else {
			//�����Ǹ��ļ���
		}
		
		f = jf.getCurrentDirectory();	//��õ�ǰĿ¼��
		//ѡ���ļ��ľ���·����separatorΪ��ǰƽ̨�ķָ����������˿�ƽ̨���ܳ��ֵ�·���������쳣
		String path = f.getPath() + java.io.File.separator + fileName;
		f = new File(path);
		File fIsExists = new File(path + ".txt");
		
		if(fIsExists.exists()) {	//�������˺��Ѵ����ļ���ͬ�ľ���·������ѯ���Ƿ񸲸�
			int i = JOptionPane.showConfirmDialog(null, "���ļ��Ѵ��ڣ�ȷ��Ҫ������");
			if(i == JOptionPane.YES_OPTION) {
				f = new File(path + ".txt");
				//ȷ�����ǣ�����txt��׺
			}
			else {
				return;	//�����˳��������
			}
		}else if(f.exists()){	//��ѡ�����Ѵ��ڵ��ļ���
			int i = JOptionPane.showConfirmDialog(null, "���ļ��Ѵ��ڣ�ȷ��Ҫ������");
			if(i == JOptionPane.YES_OPTION) {
				//ȷ������
			}
			else {
				return;	//�����˳��������
			}
		}else {		//����һ�����ļ�������txt��׺
			f =new File(path + ".txt");
		}
		
		try {	//��Ŀ���ļ�д���ı�
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
			bw.write(textOutput);
			bw.flush();
		}catch (FileNotFoundException e1) {
			JOptionPane.showMessageDialog(null, "�ļ��������" + e1.getMessage());
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
