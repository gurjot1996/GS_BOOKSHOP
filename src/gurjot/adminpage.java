package gurjot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class adminpage extends JFrame {

	private JPanel contentPane;
	private JTextField g1;
	private JTextField g2;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String Db_url="jdbc:mysql://localhost:3307/gs_bookshop";
	static final String user="root";
	static final String pass="root";
	private JTextField g3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpage frame = new adminpage();
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
	public adminpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(102, 204, 204));
		panel.setBounds(0, 0, 651, 417);
		contentPane.add(panel);
		
		JLabel label = new JLabel("TO ADD NEW BOOKS");
		label.setBackground(Color.CYAN);
		label.setBounds(139, 117, 153, 14);
		panel.add(label);
		
		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			newbook obj4=new newbook();
			obj4.show();
			}
		});
		button.setBounds(394, 113, 89, 23);
		panel.add(button);
		
		JLabel label_1 = new JLabel("TO ADD NEW SALESMAN");
		label_1.setBounds(139, 154, 166, 14);
		panel.add(label_1);
		
		JButton button_1 = new JButton("ADD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newsalesman obj5=new newsalesman();
				obj5.show();
			}
		});
		button_1.setBounds(394, 150, 89, 23);
		panel.add(button_1);
		
		JLabel lblToAlterBooks = new JLabel("TO ALTER BOOKS AVAILABITY/PRICE/DISCOUNTS\r\n");
		lblToAlterBooks.setBounds(79, 200, 305, 14);
		panel.add(lblToAlterBooks);
		
		JButton button_2 = new JButton("CLICK HERE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterationspage hj=new alterationspage();
				hj.show();
			}
		});
		button_2.setBounds(394, 196, 102, 23);
		panel.add(button_2);
		
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
				Loginpage objk=new Loginpage();
				objk.show();
			}
		});
		button_3.setBounds(450, 383, 89, 23);
		panel.add(button_3);
		
		JLabel lblToViewCurrent = new JLabel("TO VIEW CURRENT BOOKS");
		lblToViewCurrent.setBounds(139, 251, 191, 14);
		panel.add(lblToViewCurrent);
		
		JButton btnClickHere = new JButton("CLICK HERE");
		btnClickHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesmanpage gf=new salesmanpage();
				gf.show();
			}
		});
		btnClickHere.setBounds(394, 247, 102, 23);
		panel.add(btnClickHere);
		
		JLabel lblNewLabel = new JLabel("TO REMOVE A BOOK ENTER BOOKNAME");
		lblNewLabel.setBounds(10, 291, 235, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("TO REMOVE A SALESMAN ENTER NAME");
		lblNewLabel_1.setBounds(10, 325, 235, 14);
		panel.add(lblNewLabel_1);
		
		g1 = new JTextField();
		g1.setBounds(239, 288, 80, 20);
		panel.add(g1);
		g1.setColumns(10);
		
		g2 = new JTextField();
		g2.setBounds(237, 322, 246, 20);
		panel.add(g2);
		g2.setColumns(10);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
				sta=con.createStatement();
				String sql="delete from books where bname=? and bookid=?";
				PreparedStatement pst2=(PreparedStatement) con.prepareStatement(sql);
				pst2.setString(1,g1.getText());
				pst2.setString(2,g3.getText());
				
				 int y=pst2.executeUpdate();
				if(y==1){JOptionPane.showMessageDialog(null,"book deleted");
				}else{
					JOptionPane.showMessageDialog(null,"error try again");
					
				}
			}catch(Exception qe){
				JOptionPane.showMessageDialog(null,qe);
			}}
		});
		btnDelete.setBounds(520, 287, 89, 23);
		panel.add(btnDelete);
		
		JButton btnDelete_1 = new JButton("DELETE");
		btnDelete_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
				sta=con.createStatement();
				String sql="delete from login where username=?";
				PreparedStatement pst2=(PreparedStatement) con.prepareStatement(sql);
				pst2.setString(1,g2.getText());
				
				
				
				
				 int y=pst2.executeUpdate();
				if(y==1){JOptionPane.showMessageDialog(null,"salesman deleted");
				}else{
					JOptionPane.showMessageDialog(null,"error try again");
					
				}
			}catch(Exception qe){
				JOptionPane.showMessageDialog(null,qe);
			}
			}
		});
		btnDelete_1.setBounds(520, 321, 89, 23);
		panel.add(btnDelete_1);
		
		JLabel lblBookid = new JLabel("BOOKID");
		lblBookid.setBounds(327, 291, 59, 14);
		panel.add(lblBookid);
		
		g3 = new JTextField();
		g3.setBounds(382, 288, 114, 20);
		panel.add(g3);
		g3.setColumns(10);
	}
}
