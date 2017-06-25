package tw.org.iii;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC12 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = 
			DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/brad",prop);
			FileInputStream in = 
				new FileInputStream("./dir1/java.png")){
			
    		PreparedStatement pstmt =
    				conn.prepareStatement("UPDATE member set img = ? where id =1");
    		pstmt.setBinaryStream(1, in);
    		pstmt.executeUpdate();
    	
    		
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}