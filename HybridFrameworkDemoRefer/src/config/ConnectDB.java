package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ConnectDB 
{
	Connection con;
	Statement stmt;
	ResultSet results;
	boolean statusflag=false;
	
	@BeforeTest
	public void basicsetups() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		String connstring="jdbc:mysql://localhost:3306/seleniumpractice";
		String username="root";
		String password="Poornima@123";
		con=DriverManager.getConnection(connstring,username,password);
		System.out.println("Connection established");		
	}
	
	
	
	@Test//Search for an existing user's presence
	public void searchUser() throws SQLException
	{
		statusflag=searchuserexist("Srini");
		Assert.assertTrue(statusflag);		
	}
	
  
	@Test//Check if same empname exists in system
	public void chkmultiplesameusername() throws SQLException
	{
		statusflag=checkifmultiplesameusername("Srini");
		Assert.assertTrue(statusflag);
	}
	
	
	@Test//New user registration
	public void adduser() throws ClassNotFoundException, SQLException
	{
		statusflag=checkregistrationifsuccess("Srinii","4567","Mumbai","Comps");
		Assert.assertTrue(statusflag);		
	}
	
	@Test//Existing user deletion
	public void removeuseracnt() throws SQLException
	{
		statusflag=checkaccntremovalifsuccess("Srinivasan");
		Assert.assertTrue(statusflag);			
	}
	
	public boolean searchuserexist(String emp) throws SQLException
	{
		stmt=con.createStatement();
		results=stmt.executeQuery("select * from empdetails");
		
		while(results.next())
		{
			if((results.getString("empname")).equals(emp))
			  return true;
			else 
			  continue;		
		}
	  return false;
	}
	
	
	public boolean checkaccntremovalifsuccess(String emp) throws SQLException
	{
		int counter=0;
		stmt=con.createStatement();
		results=stmt.executeQuery("select * from empdetails");
		while(results.next())
		{	
			if(!(results.getString("empname")).equals(emp))
				counter=0;
			else
				counter=1;
			
		}
		
		if(counter==0)
         return true;
		else
		 return false;
	}
	
	public boolean checkifmultiplesameusername(String emp) throws SQLException
	{
		int counter=0;
		stmt=con.createStatement();
		results=stmt.executeQuery("select * from empdetails");
		while(results.next())
		{	
			if((results.getString("empname")).equals(emp))
			{	
				counter++;
			}			
		}
		
		if(counter > 1)
         return true;
		else 
		 return false;
	}
	
	
	
	public boolean checkregistrationifsuccess(String empname, String empid,String address, String department) throws ClassNotFoundException, SQLException
	{
		stmt=con.createStatement();
		//stmt.executeQuery("insert into empdetails values("Srinivasan","4567","Mumbai","Comps");
		results=stmt.executeQuery("select * from empdetails");
		while(results.next())
		{
		//	results.next();
			if((results.getString("empname")).equals(empname))
			{
				return true;				
			}
			else
				continue;
			
		}
		return false;
		
	}    	
          /*
           String Empname="Default";
		   String EmpId="Default";
		   String address="NA";
		   String department="NA";
		   int counter=0;
                     
            System.out.println("Record"+(counter+1)+":");
        	Empname=results.getString("empname");
        	System.out.println("Emp name: " + Empname);
        	
        	EmpId=results.getString("empid");
        	System.out.println("Emp Id: " + EmpId);
        	
        	address=results.getString("address");
        	System.out.println("Address: " + address);
        	
        	
        	department=results.getString("department");
        	System.out.println("Department: " + department);
        	
        	System.out.println("\n");
        	counter++;
        	*/
    

}
