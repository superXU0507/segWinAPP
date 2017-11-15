package segWinAPP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class openFile {
	/*
	 * �ļ����࣬���ļ�ѡ�񴰿ڣ���txt�ļ��ı�����textArea
	 */
	private String txtInput; //��txt�ļ�������ı�
	public String getTxt() {
		return this.txtInput; //��txt���ı����ݳ�ȥ
	}
	
	public void chooseTxt() throws IOException{
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
		chooser.setFileFilter(filter);	//�ļ�ѡ����&�ļ�����������ֹ�Ƿ���������ʽ�ļ�����
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal != JFileChooser.APPROVE_OPTION) {
			return;		//δѡ�����˳�����
		}
		
		BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
		String line;
		StringBuilder sb = new StringBuilder();
		while((line=reader.readLine()) != null) {
			sb.append(line);	//ʹ��StringBuilderѭ����ȡ�ı�����String�����и��ٵ�ռ��
		}
		reader.close();
		
		this.txtInput = sb.toString();
	}
}
