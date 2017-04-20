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

public class newsalesman extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	
static final String JDBC_DRIVER="com.mysql.jdbc.Driver";
static final String Db_url="jdbc:mysql://localhost:3307/gs_bookshop";
static final String user="root";
static final String pass="root";
private JTextField gy2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newsalesman frame = new newsalesman();
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
	public newsalesman() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 478);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(102, 204, 204));
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
				Loginpage j=new Loginpage();
				j.show();
			}
		});
		button_3.setBounds(520, 357, 89, 23);
		panel.add(button_3);
		
		JLabel lblEnterSalesMan = new JLabel("ENTER SALES MAN USERNAME");
		lblEnterSalesMan.setBounds(133, 138, 182, 23);
		panel.add(lblEnterSalesMan);
		
		JLabel lblEnterPassword = new JLabel("ENTER PASSWORD");
		lblEnterPassword.setBounds(150, 195, 152, 29);
		panel.add(lblEnterPassword);
		
		t1 = new JTextField();
		t1.setBounds(312, 139, 182, 29);
		panel.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(312, 195, 182, 29);
		panel.add(t2);
		t2.setColumns(10);
		
		JButton btnAddNewSales = new JButton("ADD NEW SALES MAN");
		btnAddNewSales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection con=null;
				Statement sta=null,sta2=null;
				try{
				Class.forName(JDBC_DRIVER);
				con=DriverManager.getConnection(Db_url,user,pass);
				sta=con.createStatement();
				String a1=t1.getText();
				String a2=t2.getText();
				String a3=gy2.getText();
				int hu=Integer.parseInt(a3);
				String sql="insert into login(eid,username,password) values("+hu+",'"+a1+"','"+a2+"')";
				int yy=sta.executeUpdate(sql);
				if(yy==1){
					JOptionPane.showMessageDialog(null,"new sales man added");
				}else
				{
					JOptionPane.showMessageDialog(null,"error try again");
						
				}}catch(Exception e){	JOptionPane.showMessageDialog(null,e);
				}
				
			}
		});
		btnAddNewSales.setBounds(357, 268, 160, 23);
		panel.add(btnAddNewSales);
		
		JButton btnGoBack = new JButton("GO BACK");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adminpage tr=new adminpage();
				tr.show();
			}
		});
		btnGoBack.setBounds(226, 268, 89, 23);
		panel.add(btnGoBack);
		
		JLabel lblNewLabel = new JLabel("ENTER EMPLOYEE ID");
		lblNewLabel.setBounds(133, 105, 143, 14);
		panel.add(lblNewLabel);
		
		gy2 = new JTextField();
		gy2.setBounds(312, 93, 182, 29);
		panel.add(gy2);
		gy2.setColumns(10);
	}

}
