package gurjot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Loginpage extends JFrame {

	private JPanel contentPane;
	private JTextField userfield;
	private JPasswordField passwordField;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String Db_url="jdbc:mysql://localhost:3307/gs_bookshop";
	static final String user="root";
	static final String pass="root";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loginpage frame = new Loginpage();
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
	public Loginpage() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblGsBookshop = new JLabel("         G.S BOOKSHOP");
		lblGsBookshop.setFont(new Font("Sitka Text", Font.BOLD, 36));
		lblGsBookshop.setBounds(106, 23, 421, 62);
		contentPane.add(lblGsBookshop);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setBounds(166, 169, 76, 31);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(166, 226, 76, 31);
		contentPane.add(lblPassword);
		
		userfield = new JTextField();
		userfield.setBounds(252, 169, 237, 31);
		contentPane.add(userfield);
		userfield.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(252, 226, 237, 31);
		contentPane.add(passwordField);
		
		JButton Buttonfield = new JButton("LOGIN");
		Buttonfield.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
				sta=con.createStatement();
			String usrname=userfield.getText();
			String passwd=passwordField.getText();
			if(usrname.equals("admin")&&passwd.equals("admin"))
			{
				adminpage obj1=new adminpage();
				obj1.show();
			}else
			{
String sql="select * from login";
ResultSet rs=sta.executeQuery(sql);
int flag=0;
while(rs.next())
{
	String m1=rs.getString("username");
	String m2=rs.getString("password");
	if(usrname.equals(m1)&&passwd.equals(m2)){
		flag=1;
	}else{
		flag=0;
	}
	
}if(flag==1){
	displaybooks obj2=new displaybooks();
	obj2.show();
}else{
JOptionPane.showMessageDialog(null,"username and password do not match");
}}
}catch(Exception e)
				{
				JOptionPane.showMessageDialog(null, e);
				}}
		});
		Buttonfield.setBounds(263, 301, 89, 23);
		contentPane.add(Buttonfield);
		
		JLabel lbltoBeStrictly = new JLabel("****TO BE STRICTLY USED BY OWNER OR SALESMAN OF THE SHOP ONLY****");
		lbltoBeStrictly.setBounds(134, 105, 393, 14);
		contentPane.add(lbltoBeStrictly);
		
		JLabel lblBooksAreThe = new JLabel("BOOKS ARE THE BASE OF OUR LIFE");
		lblBooksAreThe.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBooksAreThe.setBounds(308, 71, 181, 23);
		contentPane.add(lblBooksAreThe);
	}
}
