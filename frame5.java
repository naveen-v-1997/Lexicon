package examination;

import java.awt.BorderLayout;
import javafx.print.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.print.*;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
public class frame5 extends JFrame {

	private JPanel contentPane;
	public static JTable table;
	static Connection con;
	int i=1;
	Statement st;
	Statement st1;
	private JScrollPane scrollPane_1;
	static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			
					frame5 frame = new frame5();
					frame.setVisible(true);
				}
				
		});
	}

	/**
	 * Create the frame.
	 */
	public frame5() {
		setTitle(" ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 791, 656);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(70, 95, 666, 379);
		contentPane.add(scrollPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnShow = new JButton("SHOW");
		btnShow.setFont(new Font("Arial", Font.BOLD, 11));
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText("DETALIS");
				try {
					 Driver de1=new oracle.jdbc.driver.OracleDriver();
					 DriverManager.registerDriver(de1);
					 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
					 
					
							
							st=con.createStatement();
							 ResultSet cls = st.executeQuery("select * from classTable");
							
							 
							 table.setModel(DbUtils.resultSetToTableModel(cls));
							
				}catch(Exception e1)
					
				{
					e1.printStackTrace();
				}
				
				
			}
			
			
				
				
			
			
		});
		btnShow.setBounds(70, 489, 89, 23);
		contentPane.add(btnShow);
		
		JButton btnPrint = new JButton("PRINT");
		btnPrint.setFont(new Font("Arial", Font.BOLD, 11));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setBounds(305, 489, 89, 23);
		contentPane.add(btnPrint);
		
		JButton btnNext = new JButton(" NEXT");
		btnNext.setFont(new Font("Arial", Font.BOLD, 11));
		btnNext.addActionListener(new next());
			
		btnNext.setBounds(185, 489, 89, 23);
		contentPane.add(btnNext);
		
		textField = new JTextField();
		textField.setBounds(131, 70, 100, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblClass = new JLabel("CLASS");
		lblClass.setFont(new Font("Arial", Font.BOLD, 11));
		lblClass.setBounds(75, 73, 46, 14);
		contentPane.add(lblClass);
		
		JButton btnNewButton = new JButton("FINISH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JOptionPane.showMessageDialog(null,"THANK YOU");
				setVisible(false);
				setDefaultCloseOperation(frame5.EXIT_ON_CLOSE);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 11));
		btnNewButton.setBounds(412, 489, 89, 23);
		contentPane.add(btnNewButton);
		
		
		
	}
}
