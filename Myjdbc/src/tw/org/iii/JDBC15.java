package tw.org.iii;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC15 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = 
			DriverManager.getConnection(
				"jdbc:mysql://127.0.0.1/brad",prop)){
			
    		PreparedStatement pstmt =
    				conn.prepareStatement("SELECT * FROM member WHERE id = 2");
    		ResultSet rs = pstmt.executeQuery();
    		rs.next();
    		
    		ObjectInputStream in = new ObjectInputStream(rs.getBinaryStream("obj"));
    		Student s3 = (Student)(in.readObject());
    		System.out.println(s3.getId()+":"+s3.total()+":"+s3.avg());
    		in.close();
    		
//    		Student s4 =(Student)(rs.getObject("obj"));
//    		System.out.println(s4.getId()+":"+s4.total()+":"+s4.avg());
    		
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}