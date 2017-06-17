package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBC01 {

	public static void main(String[] args) {
		try{Class.forName("com.mysql.jdbc.Driver");
			System.out.println("OK");
		}catch(ClassNotFoundException ee){
			System.out.println(ee);	
			System.exit(0);
		}
		try {
			Connection conn =DriverManager.getConnection(
					"jdbc:mysql://localhost/brad?" +
                    "user=root&password=root");
			Statement stmt = conn.createStatement();
			boolean isQueryOK = stmt.execute(
					"INSERT INTO cust(cname,tel,birthday)"+
					"VALUES ('Brad','123','1990-09-08')");
			if (isQueryOK){
				System.out.println("Ok");
			}else{
				System.out.println("XX");
			}
			System.out.println("OK");
		} catch (SQLException se) {
			System.out.println(se);
		}
	}
}
