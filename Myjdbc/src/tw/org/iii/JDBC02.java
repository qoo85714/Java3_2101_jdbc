package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC02 {

	public static void main(String[] args) {
		try{Class.forName("com.mysql.jdbc.Driver");
			System.out.println("OK");
		}catch(ClassNotFoundException ee){
			System.out.println(ee);	
			System.exit(0);
		}
		try {
			Connection conn =DriverManager.getConnection(
					"jdbc:mysql://localhost/brad",
                    "root","root");
			Statement stmt = conn.createStatement();
			String sql = 
					"INSERT INTO cust(cname,tel,birthday)"+
					"VALUES ('Tony','123','1990-09-08')";
			stmt.execute(sql);
			System.out.println(sql);
	
		} catch (SQLException se) {
			System.out.println(se);
		}
	}
}
