package gurjot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class newbook extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t5;
	private JTextField t6;
	
static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
static final String Db_url="jdbc:mysql://localhost:3307/gs_bookshop";
static final String user="root";
static final String pass="root";
private JTextField jj;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newbook frame = new newbook();
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
	public newbook() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(102, 153, 153));
		panel.setBounds(0, 0, 619, 391);
		contentPane.add(panel);
		
		JLabel label_3 = new JLabel("WELCOME ADMIN");
		label_3.setBounds(382, 53, 112, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("         G.S BOOKSHOP");
		label_4.setFont(new Font("Sitka Text", Font.BOLD, 36));
		label_4.setBounds(96, 11, 421, 62);
		panel.add(label_4);
		
		JButton button_3 = new JButton("LOGOUT");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginpage r=new Loginpage();
				r.show();
			}
		});
		button_3.setBounds(520, 357, 89, 23);
		panel.add(button_3);
		
		JLabel lblNewLabel = new JLabel("ENTER BOOK ID");
		lblNewLabel.setBounds(120, 104, 112, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER BOOK NAME");
		lblNewLabel_1.setBounds(120, 137, 118, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AUTHOR");
		lblNewLabel_2.setBounds(120, 172, 62, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRICE");
		lblNewLabel_3.setBounds(120, 208, 62, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("RACK NO.");
		lblNewLabel_4.setBounds(120, 241, 76, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("DISCOUNT");
		lblNewLabel_5.setBounds(120, 273, 76, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblAvailability = new JLabel("AVAILABILITY[1-yes,0-no]\r\n");
		lblAvailability.setBounds(71, 306, 149, 14);
		panel.add(lblAvailability);
		
		t1 = new JTextField();
		t1.setBounds(242, 101, 234, 20);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(242, 134, 234, 20);
		panel.add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(242, 169, 234, 20);
		panel.add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(242, 205, 234, 20);
		panel.add(t4);
		t4.setColumns(10);
		
		t5 = new JTextField();
		t5.setBounds(242, 238, 234, 20);
		panel.add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(242, 270, 234, 20);
		panel.add(t6);
		t6.setColumns(10);
		
		JButton btnAddNewBook = new JButton("ADD NEW BOOK");
		btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
				sta=con.createStatement();
				String a1=t1.getText();
				String a2=t2.getText();
				String a3=t3.getText();
				String a4=t4.getText();
				String a5=t5.getText();
				String a6=t6.getText();
				String a7=jj.getText();
				
				String sql="insert into books(bookid,bname,author,bprice,brack,discounts,availabilty) values("+a1+",'"+a2+"','"+a3+"',"+a4+","+a5+","+a6+","+a7+")";
				int yy=sta.executeUpdate(sql);
				if(yy==1){
					JOptionPane.showMessageDialog(null,"new book inserted");
				}else{
					JOptionPane.showMessageDialog(null,"error try again");
					
			}}
				catch(Exception e){
					JOptionPane.showMessageDialog(null,e);
					
				}
				}
		});
		btnAddNewBook.setBounds(421, 323, 112, 23);
		panel.add(btnAddNewBook);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminpage rt=new adminpage();
				rt.show();
			}
		});
		btnGoBack.setBounds(287, 325, 89, 23);
		panel.add(btnGoBack);
		
		jj = new JTextField();
		jj.setBounds(242, 301, 234, 20);
		panel.add(jj);
		jj.setColumns(10);
		
		
	}
}
