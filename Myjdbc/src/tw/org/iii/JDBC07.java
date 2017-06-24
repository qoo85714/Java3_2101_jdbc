package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC07 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/brad",
				prop)){
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO member (account,passwd,realname)" +
						"VALUES ('brad','123','Brad Chao')";
			stmt.executeUpdate(sql);
			System.out.println("OK");
//			ResultSet rs = stmt.executeQuery(" select count(*) from gift ");
//			ResultSet rs = stmt.executeQuery(
//					"select count(*) from member account=? and passwd=?");
//			rs.next();
//			System.out.println(rs.getString(1));
			
			
//			System.out.println(rs.getRow());
		}catch(Exception e){
			System.out.println(e);
			
		}

	}

}
