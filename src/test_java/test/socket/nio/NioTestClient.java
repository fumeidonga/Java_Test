package test_java.test.socket.nio;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.alibaba.fastjson.JSON;

import test_java.test.ramdomName.CreateRandomField;
import test_java.test.socket.bean.CBaseDataBean;
import test_java.test.socket.bean.CMsgTypeBean;
import test_java.test.socket.bean.User;

public class NioTestClient extends JFrame  implements ActionListener {

	private JPanel contentPane;
	private JTextField txtIp;
	private JTextField txtPort;
	private JTextField textField;
	public JTextArea textArea;
	private JButton btnConnect;
	private JButton btnNewButton;
	public boolean isconnect = false;
	public JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NioTestClient frame = new NioTestClient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public NioTestClient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 752, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 351, 33);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtIp = new JTextField();
		txtIp.setBounds(5, 6, 96, 21);
		panel.add(txtIp);
		txtIp.setText("192.168.100.142");
		txtIp.setColumns(15);
		
		txtPort = new JTextField();
		txtPort.setBounds(103, 6, 66, 21);
		panel.add(txtPort);
		txtPort.setText("11585");
		txtPort.setColumns(10);
		
		btnConnect = new JButton("connect");
		btnConnect.setBounds(171, 5, 81, 23);
		btnConnect.addActionListener(this);
		panel.add(btnConnect);
		
		btnNewButton_1 = new JButton("disconnect");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.setBounds(252, 5, 93, 23);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 46, 674, 362);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBounds(10, 433, 321, 21);
		contentPane.add(textField);
		textField.setColumns(100);
		
		btnNewButton = new JButton("send");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(341, 432, 67, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_2 = new JButton("随机注册");
		btnNewButton_2.addActionListener(this);
		btnNewButton_2.setBounds(10, 464, 93, 23);
		contentPane.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("获取商品分类");
		btnNewButton_3.addActionListener(this);
		btnNewButton_3.setBounds(0, 497, 128, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("同步商品");
		btnNewButton_4.addActionListener(this);
		btnNewButton_4.setBounds(179, 464, 93, 23);
		contentPane.add(btnNewButton_4);
		
		txtStoreid = new JTextField();
		txtStoreid.setText("storeid");
		txtStoreid.setBounds(113, 465, 66, 21);
		contentPane.add(txtStoreid);
		txtStoreid.setColumns(10);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == btnConnect){ //链接
			final String ip = txtIp.getText().trim();
			final int port = Integer.parseInt(txtPort.getText().trim());
			//btnConnect.setEnabled(false);
			// 运行客户端
			Client.start(ip, port);
			
		} else if(e.getSource() == btnNewButton){ //发送
			readline = textField.getText();
			textField.setText("");
			try {
				Client.sendMsg(textArea, readline);
				readline="";
			} catch (Exception e1) {
				System.out.println(e1);
				e1.printStackTrace();
			}
		} else if(e.getSource() == btnNewButton_4){
			String storeid = txtStoreid.getText();
            sendMsg(CMsgTypeBean.MSG_TYPE_GET_GOODS, Integer.parseInt(storeid), "");
			
		} else if(e.getSource() == btnNewButton_3){

            sendMsg(CMsgTypeBean.MSG_TYPE_GET_GOODS_BASE_CAT, -1,  "");
		} else if(e.getSource() == btnNewButton_2){

	    	String eamil = test_java.test.ramdomName.Test.getEmail(6, 9);
	    	String u = CreateRandomField.getRandomEnglishName();
	    	/*String u = Test.getChineseName()+Test.getRoad();
	    	if(u.length() > 8){
	    		u = u.substring(0, 7);
	    	}*/
	    	String pass = test_java.test.ramdomName.Test.getRandom();
	    	String tel = test_java.test.ramdomName.Test.getTel();
	    	User user = new User();  
            user.setName(u);  
            user.setPassword(pass);
            String objStr = JSON.toJSONString(user);
            sendMsg(Integer.parseInt(pass), -1, objStr);
	    	
	    	
		} else if(e.getSource() == btnNewButton_1){
			isconnect = false;
			try {
				Client.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} 
		
	}
	
	public void sendMsg(int type, int storeid, String mString){

    	CBaseDataBean cbbean = new CBaseDataBean();
    	cbbean.setDataType(type);
    	cbbean.setStoreId(storeid);
    	cbbean.setJson(mString);
        String objStrcc = JSON.toJSONString(cbbean);  

		try {
			Client.sendMsg(textArea, objStrcc);
		} catch (Exception e1) {
			System.out.println(e1);
			e1.printStackTrace();
		}
	}
	
	public Socket socket;
	public String readline="";
	private JButton btnNewButton_1;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JTextField txtStoreid;
}
