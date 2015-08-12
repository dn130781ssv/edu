package edu.hillel.hw8.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBxx {

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("org.h2.Driver");
		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM PERSON");
		while(rs.next())
		{
			System.out.println(rs.getInt(1) + ", " + rs.getString(2) + ", " + rs.getString(3) + ", " + rs.getInt(4));
		}
		rs=st.executeQuery("SELECT FirstName, LastName, Age FROM PERSON WHERE AGE>=18 and AGE<=35");
		while(rs.next())
		{
			System.out.println(rs.getString(1) + ", " + rs.getString(2) + ", " + rs.getInt(3));
		}
		rs=st.executeQuery("select LastName from Person where LastName like '%_�_%'");
		while(rs.next())
		{
			System.out.println(rs.getString(1));
		}
		rs.close();
		st.close();
		conn.close();
	}
	
}
