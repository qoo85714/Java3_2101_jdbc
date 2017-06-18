package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC0302close {
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
			Statement stmt = conn.createStatement();
			// 4. query
			String sql = "SELECT * FROM cust";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()){
				String id = rs.getString("id");
				String cname = rs.getString("cname");
				String tel = rs.getString("tel");
				String birthday = rs.getString("birthday");
				System.out.println(
					id + ":" + cname + ":" + tel + ":" + birthday);
			}

		}catch(Exception e){
			System.out.println(e);
		}	
	}
}
