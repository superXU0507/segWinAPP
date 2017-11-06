package segWinAPP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SegWin {

	private JFrame frmIctclas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegWin window = new SegWin();
					window.frmIctclas.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SegWin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIctclas = new JFrame();
		frmIctclas.setTitle("ICTCLAS\u5206\u8BCD&\u8BCD\u6027\u5206\u6790");
		frmIctclas.setBounds(100, 100, 650, 340);
		frmIctclas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIctclas.getContentPane().setLayout(null);
		
		JScrollPane tiaScroll = new JScrollPane();
		tiaScroll.setBounds(0, 0, 634, 95);
		frmIctclas.getContentPane().add(tiaScroll);
		
		JTextArea textInputArea = new JTextArea();
		textInputArea.setLineWrap(true);
		tiaScroll.setViewportView(textInputArea);
		
		JScrollPane toaScroll = new JScrollPane();
		toaScroll.setBounds(0, 205, 634, 95);
		frmIctclas.getContentPane().add(toaScroll);
		
		JTextArea textOutputArea = new JTextArea();
		textOutputArea.setLineWrap(true);
		toaScroll.setViewportView(textOutputArea);
		
		JButton fileOpenBtn = new JButton("\u6253\u5F00\u6587\u4EF6");
		fileOpenBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {	//使用actionPerformed而非mouseclicked，因为后者只关注鼠标点击事件，甚至在按钮被禁用后仍会响应
				/*
				 * 打开文件按钮的操作响应事件
				 * 清屏
				 * 打开一个文件选择窗口，选择一个txt文件，获得指向此文件的对象
				 * 读取其中文本，将文本添加到textInputArea的text区域中
				 */
				
			}
		});
		fileOpenBtn.setBounds(0, 100, 100, 100);
		frmIctclas.getContentPane().add(fileOpenBtn);
		
		JButton fileProcessBtn = new JButton("\u5904\u7406\u6587\u672C");
		fileProcessBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * 处理文本事件的操作响应事件
				 * 调用ICTCLAS分词接口进行分词和词性分析
				 * 对textInputArea的getText分词
				 * 结果添加到textOutputArea的setText
				 */
				segProcess sp = new segProcess();
				sp.inputSeg(textInputArea.getText());
				try {
					sp.processGo();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				textOutputArea.setText(sp.ouputSeg());
			}
		});
		fileProcessBtn.setBounds(100, 100, 434, 100);
		frmIctclas.getContentPane().add(fileProcessBtn);
		
		JButton fileSaveBtn = new JButton("\u4FDD\u5B58\u6587\u4EF6");
		fileSaveBtn.setBounds(534, 100, 100, 100);
		fileSaveBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * 打开一个文件保存窗口
				 * 在指定路径新建一个txt文件，将textOutputArea的text存为其文本
				 */
			}
		});
		frmIctclas.getContentPane().add(fileSaveBtn);
	}
}
