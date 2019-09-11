package examination;

import java.awt.BorderLayout;
import java.lang.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.proteanit.sql.DbUtils;
import oracle.jdbc.driver.Const;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Array;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import java.awt.Color;

public class frame4 extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	//frame5 f6;
	int total;
	int cnt;
	int cnt1;
	static int no1;
	Statement state;
	 ResultSet result;
	 int strnth1=0;
	 String strnth2;
	int dup;
	int temp=0;
	String classroom;
	int classroomno;
	ResultSet capacity10;
	int k1=0;
	int q=0;
	int cunt1;
	int tem=0;
	String strnth;
	String tb;
	
	
	
	PreparedStatement p1;
	PreparedStatement ps1;
	PreparedStatement	ps2;
	PreparedStatement	ps3;
	PreparedStatement ps4;
	PreparedStatement ps5;
	PreparedStatement ps6;
	int ind=0;
	Connection con;
	File src1;
	FileInputStream fis1;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	FileOutputStream fout;
	int capacity;
	ResultSet cse;
	ResultSet ece;
	ResultSet eee;
	ResultSet crows;
	ResultSet cols;
	ResultSet cls;
	ResultSet cunt;
	Statement st8;
	Statement st7;
	Statement st6;
	Statement st5;
	Statement st2;
	Statement st3;
	Statement st4;
	int p=0;
	int a1=0;
	int b1=0;
	int c1=0;
	int d1=0;
	int[] arr=new int[100];
	int[] row=new int[100];
	int[] col=new int[100];
	private JLabel lblNoofStudentPer;
	private JTextField textField_4;
	private JTable table;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame4 frame = new frame4();
					
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
	public frame4() {
	String no=JOptionPane.showInputDialog(null, "ENTER NO OF CLASS ROOMS");
	 no1=Integer.parseInt(no);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterNoOf = new JLabel("ENTER DETAILS OF CLASS");
		lblEnterNoOf.setForeground(Color.RED);
		lblEnterNoOf.setFont(new Font("Arial", Font.BOLD, 11));
		lblEnterNoOf.setBounds(29, 40, 167, 24);
		contentPane.add(lblEnterNoOf);
		
		textField = new JTextField();
		textField.setBounds(206, 42, 35, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNoOfRows = new JLabel("NO OF STUDENT PER ROWS");
		lblNoOfRows.setFont(new Font("Arial", Font.BOLD, 11));
		lblNoOfRows.setBounds(29, 124, 156, 24);
		contentPane.add(lblNoOfRows);
		
		textField_2 = new JTextField();
		textField_2.setBounds(198, 126, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNoOfColums = new JLabel("NO OF ROWS");
		lblNoOfColums.setFont(new Font("Arial", Font.BOLD, 11));
		lblNoOfColums.setBounds(29, 92, 105, 14);
		contentPane.add(lblNoOfColums);
		
		textField_3 = new JTextField();
		textField_3.setBounds(198, 89, 86, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	
		for(int i=temp+1;i<no1+1;i++)
		{
			String j=Integer.toString(i);
		textField.setText(j);
		dup=i++;
		break;
		}
		
		
	try {
		 Driver de1=new oracle.jdbc.driver.OracleDriver();
		 DriverManager.registerDriver(de1);
		 con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
		 
		 Statement state=con.createStatement();
		 ResultSet result;
	result = state.executeQuery("select count(*) from classTable");
		
		 
		 while(result.next())
		 {
			 classroom=result.getString(1);
		 }
		 
		classroomno=Integer.parseInt(classroom);
		
		for(int p=1;p<=classroomno;p++)
		{
			String a=Integer.toString(p);
			tb="table"+a;
			String sql="DROP TABLE "+tb;
			Statement s=con.createStatement();
			s.executeQuery(sql);
			
			
		 }
		
		 
		 
		 
		 
		  String S="classTable";
		ps3=con.prepareStatement("TRUNCATE TABLE classTable");
		ps3.executeQuery();
	}catch(Exception e1) {
		e1.printStackTrace();
	}
	
	
		JButton btnGenerate = new JButton("UPDATE");
		btnGenerate.setFont(new Font("Arial", Font.BOLD, 11));
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i;
	
				try {
					ps2=con.prepareStatement("insert into classTable values(?,?,?,?,?)");
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				String z="1";
				
			
				String b=textField_2.getText();
				 b1=Integer.parseInt(b);
				String c=textField_3.getText();
				c1=Integer.parseInt(c);
			row[ind]=c1;
			col[ind]=c1;
				textField_4.setText(b);
				//d1=Integer.parseInt(d);
				
				 capacity=b1*c1;
				 
				 
				
						//int capacity1=capacity*d1;
						 arr[ind]=capacity;
						 ind++;
				String cap=Integer.toString(capacity);
				JOptionPane.showInputDialog(null, "capacity of the class is",capacity);
				JOptionPane.showInputDialog(null,"No. of columns",b1);
				
				String j;
				for( i=dup+1;i<no1+1;i++)
				{
					 j=Integer.toString(i);
				textField.setText(j);
				dup++;
				
				
				break;
				}
				for(int u=q+1;u<no1+1;u++)
				{	String v;
					v=Integer.toString(u);
					try {
						ps2.setString(1, v);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					q++;
					break;
				}
				
				try {
					ps2.setString(2,c);
					ps2.setString(3,b);
					ps2.setString(4,b);
					ps2.setString(5,cap);
					ps2.executeUpdate();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
					
					
					
			
				p=i;
					
				if(p==no1+1)
				{
					JOptionPane.showMessageDialog(null,"class limit completed ");
				}	
				
			
				
				String qry="select * from classTable";
				
				
				try {
					ResultSet rs2;
					Statement st2=con.createStatement();
					rs2 = st2.executeQuery(qry);
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				}
				
				
				
				
			
		});
		//JOptionPane.showMessageDialog(null,"data uploaded successfully");
		btnGenerate.setBounds(87, 171, 89, 23);
		contentPane.add(btnGenerate);
		
		lblNoofStudentPer = new JLabel("NO OF COLUMNS");
		lblNoofStudentPer.setFont(new Font("Arial", Font.BOLD, 11));
		lblNoofStudentPer.setBounds(29, 263, 147, 24);
		contentPane.add(lblNoofStudentPer);
		
		textField_4 = new JTextField();
		textField_4.setBounds(147, 265, 49, 20);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(312, 84, 298, 105);
		contentPane.add(scrollPane_1);
		
		scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);  
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
	
		
		JButton btnBack = new JButton("BACK");
		btnBack.setFont(new Font("Arial", Font.BOLD, 11));
		btnBack.setForeground(new Color(128, 0, 0));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				frame3 f6=new frame3();
				f6.show();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}); 
		btnBack.setBounds(521, 11, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnAllocate = new JButton("ALLOCATE");
		btnAllocate.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				 
				strnth2= JOptionPane.showInputDialog("ENTER 1 FOR SERIAL ALLOCATION\n OR 2 FOR RANDOM ALLOCATION");
				 
				int h=1;
				
				ArrayList<String> ar=new ArrayList(1000);
			
				
try {
					
					st2 = con.createStatement();
					cse = st2.executeQuery("select rollnumber from csetable");
					st3=con.createStatement();
					ece=st3.executeQuery("select rollnumber from ecetable");
					st4=con.createStatement();
					eee=st4.executeQuery("select rollnumber from eeeTable");
					st5=con.createStatement();
					crows=st5.executeQuery("select crows from classTable");
					st6=con.createStatement();
					cols=st6.executeQuery("select ccolumn from classTable");
					st7=con.createStatement();
					cls=st7.executeQuery("select classno from classTable"); 
					//table.setModel(DbUtils.resultSetToTableModel(ece));
					st8=con.createStatement();
					cunt=st8.executeQuery("select count(rollnumber) from csetable");
					Statement cap=con.createStatement();
					capacity10 =cap.executeQuery("select sum(capacity) from classTable");
					String sr;String sr1;String sr2;
					
					while(capacity10.next())
					{
							strnth=capacity10.getString(1);
							 strnth1=Integer.parseInt(strnth);
							
					} 
					while(cse.next())
					{		
							
							
							sr=cse.getString("rollnumber");  
							ar.add(sr);
						
							
						
					
					}
					
					while(ece.next())
					{ 
						
						
						sr1=ece.getString("rollnumber");
						ar.add(sr1);
					
						
					
					}
				
					while(eee.next())
					{
						
						
						sr2=eee.getString("rollnumber");
						ar.add(sr2);
						
						
					}
					while(ar.size()<=strnth1) {
						ar.add("NULL");
					}
					
					if(strnth2.equals(2))
					{
					
					Collections.shuffle(ar);	// shuffle method
					
					}
					
					
					
					for(int i=1;i<=no1;i++)
					{	
						String a=Integer.toString(i);
					 tb="table"+a;
						String sql="CREATE TABLE "+tb+" (colmn1 char(100))";	//creating the table
						ps1 = con.prepareStatement(sql);
					    ps1.executeQuery();
					  
						while(cols.next())		
						{cnt= cols.getInt(1);									//fetching columns in the class
						
						break;
						}
						for(int j=2;j<=cnt;j++)
						{	String a1=Integer.toString(j);
							String r="colmn"+a1;
							String ty="char(100)";
							String sql1="ALTER TABLE "+tb+" ADD " +r+" "+ty;	//Adding column to the table
							ps1 = con.prepareStatement(sql1);
						    ps1.executeQuery();
						}
						while(crows.next())		
						{cnt1= crows.getInt(1);									
						
						break;
						}
						
						for(int g=0;g<cnt1;g++)
						{	
							switch(cnt)
							{
							
							case 1:
											String q1="insert into "+tb+ " values (?)";
											PreparedStatement n1=con.prepareStatement(q1);
											String s=ar.get(k1++);
											n1.setString(1,s);
											n1.executeUpdate();
											break;
							case 2:			String q2="insert into "+tb+ " values (?,?)";
											PreparedStatement n2=con.prepareStatement(q2);
											String s1=ar.get(k1++);
											String s12=ar.get(k1++);
											n2.setString(1,s1);
											n2.setString(2,s12);
											n2.executeUpdate();
											break;
							case 3:			String q3="insert into "+tb+ " values (?,?,?)";
											PreparedStatement n3=con.prepareStatement(q3);
											String s2=ar.get(k1++);
											String s21=ar.get(k1++);
											String s22=ar.get(k1++);
											n3.setString(1,s2);
											n3.setString(2,s21);
											n3.setString(3,s22);
											n3.executeUpdate();
											break;
							case 4: 		String q4="insert into "+tb+ " values (?,?,?,?)";
											PreparedStatement n4=con.prepareStatement(q4);
											String s3=ar.get(k1++);
											String s31=ar.get(k1++);
											String s32=ar.get(k1++);
											String s33=ar.get(k1++);
											n4.setString(1,s3);
											n4.setString(2,s31);
											n4.setString(3,s32);
											n4.setString(4,s33);
											n4.executeUpdate();
											break;
							case 5:			String q5="insert into "+tb+ " values (?,?,?,?,?)";
											PreparedStatement n5=con.prepareStatement(q5);
											String s4=ar.get(k1++);
											String s41=ar.get(k1++);
											String s42=ar.get(k1++);
											String s43=ar.get(k1++);
											String s44=ar.get(k1++);
											n5.setString(1,s4);
											n5.setString(2,s41);
											n5.setString(3,s42);
											n5.setString(4,s43);
											n5.setString(5,s44);
											n5.executeUpdate();
											
											break;
							case 6:			String q6="insert into "+tb+ " values (?,?,?,?,?,?)";
											PreparedStatement n6=con.prepareStatement(q6);
											String s5=ar.get(k1++);
											String s51=ar.get(k1++);
											String s52=ar.get(k1++);
											String s53=ar.get(k1++);
											String s54=ar.get(k1++);
											String s55=ar.get(k1++);
											n6.setString(1,s5);
											n6.setString(2,s51);
											n6.setString(3,s52);
											n6.setString(4,s53);
											n6.setString(5,s54);
											n6.setString(6,s55);
											n6.executeUpdate();
											break;
							case 7:			String q7="insert into "+tb+ " values (?,?,?,?,?,?,?)";
											PreparedStatement n7=con.prepareStatement(q7);
											String s7=ar.get(k1++);
											String s71=ar.get(k1++);
											String s72=ar.get(k1++);
											String s73=ar.get(k1++);
											String s74=ar.get(k1++);
											String s75=ar.get(k1++);
											String s76=ar.get(k1++);
										
											n7.setString(1,s7);
											n7.setString(2,s71);
											n7.setString(3,s72);
											n7.setString(4,s73);
											n7.setString(5,s74);
											n7.setString(6,s75);
											n7.setString(7,s76);
											n7.executeUpdate();
											
											break;
											
							}
						}
						


						
					} 
					JOptionPane.showMessageDialog(null, "completed"); 
					frame5 f6=new frame5();
					 f6.show();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

frame5 f5=new frame5();
f5.show();
			}
			
			
			   
			   
		
		});
		btnAllocate.setBounds(476, 264, 89, 23);
		contentPane.add(btnAllocate);
	}
}
 