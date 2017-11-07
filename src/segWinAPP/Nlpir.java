package segWinAPP;

import java.io.UnsupportedEncodingException;

import com.sun.jna.Library;
import com.sun.jna.Native;

public class Nlpir {
	// ����ӿ�CLibrary���̳���com.sun.jna.Library
	public interface CLibrary extends Library {
		// ���岢��ʼ���ӿڵľ�̬����
		CLibrary Instance = (CLibrary) Native.loadLibrary("NLPIR", CLibrary.class);	//����dll�����·��

		// printf��������
		public int NLPIR_Init(byte[] sDataPath, int encoding,byte[] sLicenceCode);

		public String NLPIR_ParagraphProcess(String sSrc, int bPOSTagged);

		public String NLPIR_GetKeyWords(String sLine, int nMaxKeyLimit,boolean bWeightOut);
		
		public void NLPIR_Exit();
	}

	public static String transString(String aidString, String ori_encoding,String new_encoding) {
		try {
			return new String(aidString.getBytes(ori_encoding), new_encoding);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
