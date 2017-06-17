package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;

public class ODBC01 {

	public static void main(String[] args) {
		try{
			//Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:odbc:HY_DSN");
			System.out.println("Driver OK");
			
		}catch (Exception e){
			System.out.println(e);
		}

	}

}
