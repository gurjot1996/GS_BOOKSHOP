package gurjot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class salesmanpage extends JFrame {

	private JPanel contentPane;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String Db_url="jdbc:mysql://localhost:3307/gs_bookshop";
	static final String user="root";
	static final String pass="root";
	private JTable table;
	private JTextField t12;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salesmanpage frame = new salesmanpage();
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
	public salesmanpage() {
		setBackground(new Color(222, 184, 135));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 707, 459);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(32, 178, 170));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("         G.S BOOKSHOP");
		label.setFont(new Font("Sitka Text", Font.BOLD, 36));
		label.setBounds(111, 11, 421, 62);
		contentPane.add(label);
		
		JLabel lbltoBeUsed = new JLabel("****TO BE USED BY OWNER OR SALESMAN OF THE SHOP ONLY****");
		lbltoBeUsed.setBounds(168, 62, 388, 14);
		contentPane.add(lbltoBeUsed);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 107, 647, 180);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("SHOW COMPLETE TABLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
				sta=con.createStatement();
				String sql="select * from books";
				PreparedStatement pst=(PreparedStatement) con.prepareStatement(sql);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
			}catch(Exception e){}}
		});
		btnNewButton.setBounds(47, 365, 210, 23);
		contentPane.add(btnNewButton);
		
		t12 = new JTextField();
		t12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
			
				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
				sta=con.createStatement();
		       // String selection=(String)comboBox
				String query="select * from books where bname=?";
				PreparedStatement pst2=(PreparedStatement) con.prepareStatement(query);
				pst2.setString(1,t12.getText());
				ResultSet rs2=pst2.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs2));
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
			
			
			
			}
		});
		t12.setBounds(452, 298, 220, 36);
		contentPane.add(t12);
		t12.setColumns(10);
		
		JLabel lblSearchBy = new JLabel("Search BOOKNAME");
		lblSearchBy.setBounds(325, 309, 164, 14);
		contentPane.add(lblSearchBy);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginpage fr=new Loginpage();
				fr.show();
			}
		});
		btnLogout.setBounds(583, 365, 89, 23);
		contentPane.add(btnLogout);
		
		JLabel lblBooksAvailable = new JLabel("BOOKS AVAILABLE");
		lblBooksAvailable.setBounds(296, 84, 104, 14);
		contentPane.add(lblBooksAvailable);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminpage hj=new adminpage();
				hj.show();
			}
		});
		btnGoBack.setBounds(452, 365, 89, 23);
		contentPane.add(btnGoBack);
	}
}
