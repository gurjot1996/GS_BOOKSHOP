package gurjot;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class displaybooks extends JFrame {

	private JPanel contentPane;
	private JTextField te5;
	static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
	static final String Db_url="jdbc:mysql://localhost:3307/gs_bookshop";
	static final String user="root";
	static final String pass="root";
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					displaybooks frame = new displaybooks();
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
	public displaybooks() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 715, 474);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(0, 0, 689, 410);
		contentPane.add(panel);
		
		JLabel label = new JLabel("         G.S BOOKSHOP");
		label.setFont(new Font("Sitka Text", Font.BOLD, 36));
		label.setBounds(111, 11, 421, 62);
		panel.add(label);
		
		JLabel label_1 = new JLabel("****TO BE USED BY OWNER OR SALESMAN OF THE SHOP ONLY****");
		label_1.setBounds(168, 62, 388, 14);
		panel.add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 107, 647, 180);
		panel.add(scrollPane);
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button = new JButton("SHOW COMPLETE TABLE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
			}catch(Exception ge){}}
		});
		button.setBounds(47, 365, 210, 23);
		panel.add(button);
		
		te5 = new JTextField();
		te5.addKeyListener(new KeyAdapter() {
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
				pst2.setString(1,te5.getText());
				ResultSet rs2=pst2.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs2));
				
			}catch(Exception e){
				JOptionPane.showMessageDialog(null,e);
			}
			
			}
		});
		te5.setColumns(10);
		te5.setBounds(452, 298, 220, 36);
		panel.add(te5);
		
		JLabel label_2 = new JLabel("Search BOOKNAME");
		label_2.setBounds(325, 309, 164, 14);
		panel.add(label_2);
		
		JButton button_1 = new JButton("LOGOUT");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Loginpage df=new Loginpage();
				df.show();
			}
		});
		button_1.setBounds(583, 365, 89, 23);
		panel.add(button_1);
		
		JLabel label_3 = new JLabel("BOOKS AVAILABLE");
		label_3.setBounds(296, 84, 104, 14);
		panel.add(label_3);
	}
}
