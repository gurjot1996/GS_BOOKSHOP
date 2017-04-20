package gurjot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class alterationspage extends JFrame {

	private JPanel contentPane;
	private JTextField r1;
	private JTextField r2;
	private JTextField r3;
	private JTextField r4;
	
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
					alterationspage frame = new alterationspage();
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
	public alterationspage() {
		setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 473);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("         G.S BOOKSHOP");
		label.setFont(new Font("Sitka Text", Font.BOLD, 36));
		label.setBounds(109, 23, 421, 62);
		contentPane.add(label);
		
		JLabel lblEnterBookId = new JLabel("ENTER BOOK ID");
		lblEnterBookId.setBounds(110, 128, 140, 31);
		contentPane.add(lblEnterBookId);
		
		r1 = new JTextField();
		r1.setBounds(246, 130, 251, 26);
		contentPane.add(r1);
		r1.setColumns(10);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setBounds(128, 191, 46, 14);
		contentPane.add(lblPrice);
		
		r2 = new JTextField();
		r2.setBounds(246, 183, 251, 31);
		contentPane.add(r2);
		r2.setColumns(10);
		
		JLabel lblDiscount = new JLabel("DISCOUNT");
		lblDiscount.setBounds(124, 243, 73, 14);
		contentPane.add(lblDiscount);
		
		r3 = new JTextField();
		r3.setBounds(246, 235, 251, 31);
		contentPane.add(r3);
		r3.setColumns(10);
		
		JLabel lblAvailabilty = new JLabel("AVAILABILTY");
		lblAvailabilty.setBounds(109, 292, 106, 26);
		contentPane.add(lblAvailabilty);
		
		r4 = new JTextField();
		r4.setBounds(245, 289, 251, 26);
		contentPane.add(r4);
		r4.setColumns(10);
		
		JButton btnMakeChanges = new JButton("MAKE CHANGES");
		btnMakeChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
		String a1=r1.getText();
		int aa=Integer.parseInt(a1);
		String a2=r2.getText();
		int aa2=Integer.parseInt(a2);

			String a3=r3.getText();
			int aa3=Integer.parseInt(a3);
	String a4=r4.getText();
	int aa4=Integer.parseInt(a4);
		
				 String query = "update books set bprice = ?,discounts= ?,availabilty=? where bookid= ?";
			      PreparedStatement preparedStmt = (PreparedStatement) con.prepareStatement(query);
			      preparedStmt.setInt   (1, aa2);
			      preparedStmt.setInt   (2, aa3);
			      preparedStmt.setInt   (3, aa4);
			      preparedStmt.setInt   (4, aa);
			      
			     int y=preparedStmt.executeUpdate();
			     if(y==1){
			    	 JOptionPane.showMessageDialog(null,"values updated");
							 
			     }else{
			    	 JOptionPane.showMessageDialog(null,"error try again wrong bookid");
						
			     }
				con.close();
				}catch(Exception qe){
					JOptionPane.showMessageDialog(null, qe);
				}}
		});
		btnMakeChanges.setBounds(408, 337, 122, 23);
		contentPane.add(btnMakeChanges);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminpage fg=new adminpage();
				fg.show();
			}
		});
		btnGoBack.setBounds(279, 337, 89, 23);
		contentPane.add(btnGoBack);
	}

}
