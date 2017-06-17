package tw.org.iii;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;

public class JDBC04 {

	public static void main(String[] args) {
		try {
			// Establish the connection. 
			SQLServerDataSource ds = new SQLServerDataSource();
			ds.setIntegratedSecurity(true);
			ds.setServerName("localhost");
			ds.setPortNumber(1433); 
			ds.setUser("brad");
			ds.setPassword("123456");
			ds.setDatabaseName("AdventureWorks");
			Connection conn = ds.getConnection();
		}catch (Exception e){
			System.out.println(e);
			
		}
	}
}
