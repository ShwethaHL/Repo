package p2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleDriver;

public class Model {
String un;
String name;
String accno;
String pw;
String Balance;
String email;
String raccno;
String amt;
String oldpwd;
String newpwd;
public String getOldpwd() {
	return oldpwd;
}
public void setOldpwd(String oldpwd) {
	this.oldpwd = oldpwd;
}
public String getNewpwd() {
	return newpwd;
}
public void setNewpwd(String newpwd) {
	this.newpwd = newpwd;
}
public void setUn(String un) {
	this.un = un;
}
public void setName(String name) {
	this.name = name;
}
public String getRaccno() {
	return raccno;
}
public String getAmt() {
	return amt;
}
public String getUrl() {
	return url;
}
public String getUsername() {
	return username;
}
public String getPwd() {
	return pwd;
}
public Connection getCon() {
	return con;
}
public PreparedStatement getPstmt() {
	return pstmt;
}
public ResultSet getResultset() {
	return resultset;
}
public void setRaccno(String raccno) {
	this.raccno = raccno;
}
public void setAmt(String amt) {
	this.amt = amt;
}
public void setAccno(String accno) {
	this.accno = accno;
}
public void setPw(String pw) {
	this.pw = pw;
}
public void setBalance(String balance) {
	Balance = balance;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUn() {
	return un;
}
public String getName() {
	return name;
}
public String getAccno() {
	return accno;
}
public String getPw() {
	return pw;
}
public String getBalance() {
	return Balance;
}
public String getEmail() {
	return email;
}
String url="jdbc:oracle:thin:@//localhost:1521/XE";
String username="system";
String pwd="system";
Connection con;
PreparedStatement pstmt;
ResultSet resultset;

Model()
{
	try {
		DriverManager.registerDriver(new OracleDriver());
		con=DriverManager.getConnection(url,username,pwd);
	} 
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
int login()
{
	try {
		String s ="SELECT * FROM BANKAPP WHERE UN=? AND PW=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, un);
		pstmt.setString(2, pw);
		resultset=pstmt.executeQuery();
		if(resultset.next()==true)
		{
			name=resultset.getString("Name");
			accno=resultset.getString("Accno");
			return 1;
		}
		else
		{
			return 0;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
}

int CheckBalance()
{
	try {
		String s="SELECT * FROM BANKAPP WHERE ACCNO=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1,accno);
		resultset = pstmt.executeQuery();
		if(resultset.next()==true)
		{
			Balance=resultset.getString("BALANCE");
			return 1;
			
		}
		else
		{
			return 0;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	
}

int TransferMoney()
{
	  try {
		  String s1="SELECT * FROM BANKAPP WHERE ACCNO=?";
				pstmt=con.prepareStatement(s1);
				pstmt.setString(1, raccno); 
				   resultset = pstmt.executeQuery();
				   if(resultset.next()==true)
				   {
					   String s2="UPDATE BANKAPP SET BALANCE=BALANCE+? WHERE ACCNO=?";
					   pstmt=con.prepareStatement(s2);
					   pstmt.setString(1, amt);
					   pstmt.setString(2, raccno);
					  int x= pstmt.executeUpdate();
					  if(x==1)
					  {
						  String s3="UPDATE BANKAPP SET BALANCE=BALANCE-? WHERE ACCNO=?";
						   pstmt=con.prepareStatement(s3);
						   pstmt.setString(1, amt);
						   pstmt.setString(2, accno);
						   x= pstmt.executeUpdate(); 
						   return x;
					  }
					
			}
	  }
				   catch (SQLException e)
				   {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return 0;		  
	 }

	int Resetpwd()
	{
	
	try {
		String s="SELECT * FROM BANKAPP WHERE ACCNO=? AND PW=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, accno);
		pstmt.setString(2, oldpwd);
		resultset=pstmt.executeQuery();
		
		if(resultset.next()==true)
		{
			String s1="UPDATE BANKAPP SET PW=? WHERE ACCNO=?";
			pstmt=con.prepareStatement(s1);
			pstmt.setString(1,newpwd);
			pstmt.setString(2, accno);
			int x=pstmt.executeUpdate();
			return x;
		}
				
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return 0;
	}
}

