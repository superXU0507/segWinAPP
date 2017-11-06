package segWinAPP;

import segWinAPP.Nlpir.CLibrary;

public class segProcess {
	/*
	 * �ִʴ�����
	 * ����ԭ�ı�������ICTCLAS�ӿڽ��зִ���POS
	 * ���ش������ַ���
	 */
	private String beforeSeg;//������ı�
	private String afterSeg;//���صķִʽ��
	
	public void inputSeg(String inText) {
		this.beforeSeg = inText; //���ִ��ı�����
	}
	public String ouputSeg() {
		return this.afterSeg; //�ִʽ������
	}
	
	public void processGo() throws Exception {
		//�ı�������������ICTCLAS�ӿڶԴ����ı����зִ���POS���ִʽ�������Ա����
		String argu = "";
		String system_charset = "GBK";
		int charset_type = 1;
		int init_flag = CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset) ,charset_type ,"0".getBytes(system_charset));
		
		if(0 == init_flag) {
			System.err.println("ICTCLAS��ʼ��ʧ�ܣ�");
			return;
		}
		
		String sInput = this.beforeSeg;
		
		String nativeBytes = null;
		try {
			nativeBytes = CLibrary.Instance.NLPIR_ParagraphProcess(sInput, 3);
			
			this.afterSeg = nativeBytes;
			
			CLibrary.Instance.NLPIR_Exit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
