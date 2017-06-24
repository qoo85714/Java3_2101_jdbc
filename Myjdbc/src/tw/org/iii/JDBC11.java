package tw.org.iii;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC11 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = 
			DriverManager.getConnection("jdbc:mysql://127.0.0.1/brad",
				prop)){
			DatabaseMetaData metadata = conn.getMetaData();
			boolean isOK = metadata.supportsResultSetConcurrency(
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
			System.out.println(isOK);
			
			
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
    		String sql ="SELECT * FROM  member WHERE id=2";
    		ResultSet rs =stmt.executeQuery(sql);
    		rs.next();
    		System.out.println(rs.getString("account"));
    		
    		rs.updateString("account", "peter");
    		rs.updateString("passwd", "peter");
    		rs.updateRow();
    		PreparedStatement pstmt =
    				conn.prepareStatement("SELECT * FROM member",
    				ResultSet.TYPE_FORWARD_ONLY,
					ResultSet.CONCUR_UPDATABLE);
    		ResultSet rs2 = pstmt.executeQuery();
    		while (rs2.next()){
    			rs2.updateString("passwd", "111111");
    			rs2.updateRow();
    		}
    		
    		rs2.moveToInsertRow();
    		rs2.updateString("account", "Tony");
    		rs2.updateString("passwd", "Tony");
    		rs2.updateString("realname", "Tony");
    		rs2.insertRow();
    		
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}