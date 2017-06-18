package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC0303 {
	public static void main(String[] args) {
	
		// 1. Driver
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//		}catch(ClassNotFoundException ee){
//			System.exit(-1);
//		}
		
		// -------------------
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try(Connection conn = 
			DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/brad",prop)){
			// 3. SQL statement
			String sql = "INSERT INTO cust(cname,tel,birthday) VALUES(?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "Peter");
			pstmt.setString(2, "321");
			pstmt.setString(3, "1990-05-09");
			pstmt.execute();
			// 4. query
		

		}catch(Exception e){
			System.out.println(e);
		}	
	}
}
