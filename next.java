package examination;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;
import java.sql.*;

import net.proteanit.sql.DbUtils;

public class next implements ActionListener {
	int i=1;
	String count;
	int count1;
	
	
	public void actionPerformed(ActionEvent e) {
		
		
		
		try {
			 Driver de1=new oracle.jdbc.driver.OracleDriver();
			 DriverManager.registerDriver(de1);
			 java.sql.Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
			 
			
					
					Statement st=con.createStatement();
					 ResultSet cnt = st.executeQuery("select count(*) from classTable");
					 
					 while(cnt.next())
					 {
						 count=cnt.getString(1);
					 }
					 
					count1=Integer.parseInt(count);
					
		}catch(Exception e1)
			
		{
			e1.printStackTrace();
		}
		
		
		if(i <= count1)
		{	
		try {		int a=i;
					String t=Integer.toString(a);
					frame5.textField.setText(t);
					String tb="table"+t;
					String qry="select * from " +tb;
					
						 Driver de1=new oracle.jdbc.driver.OracleDriver();
						 DriverManager.registerDriver(de1);
						 java.sql.Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","santhu");
					Statement st1=con.createStatement();
					
					 ResultSet cls1= st1.executeQuery(qry);
					 
					frame5.table.setModel(DbUtils.resultSetToTableModel(cls1));
					i++;
		}catch(Exception e1)
			
		{
			e1.printStackTrace();
		}
		}
		else
		{	
			JOptionPane.showMessageDialog(null, "NO CLASSS TO SHOW");
			i=1;
			
		}
		
		

	}
	

}
