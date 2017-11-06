package segWinAPP;

import segWinAPP.Nlpir.CLibrary;

public class segProcess {
	/*
	 * 分词处理类
	 * 传入原文本，调用ICTCLAS接口进行分词与POS
	 * 返回处理结果字符串
	 */
	private String beforeSeg;//传入的文本
	private String afterSeg;//返回的分词结果
	
	public void inputSeg(String inText) {
		this.beforeSeg = inText; //待分词文本传入
	}
	public String ouputSeg() {
		return this.afterSeg; //分词结果返回
	}
	
	public void processGo() throws Exception {
		//文本处理方法，调用ICTCLAS接口对传入文本进行分词与POS，分词结果输入成员属性
		String argu = "";
		String system_charset = "GBK";
		int charset_type = 1;
		int init_flag = CLibrary.Instance.NLPIR_Init(argu.getBytes(system_charset) ,charset_type ,"0".getBytes(system_charset));
		
		if(0 == init_flag) {
			System.err.println("ICTCLAS初始化失败！");
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
