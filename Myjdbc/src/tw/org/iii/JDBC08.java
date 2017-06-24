package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC08 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/brad",
				prop)){
			Statement stmt = conn.createStatement();
			
			String account = "eric", passwd = "123456", realname = "Eric Ho";
			if(!isDataRepeat(account, stmt)){
				String sql ="INSERT INTO member (account,passwd,realname)" +
					"VALUES ('" + account + "','" + passwd + "','" + realname + "')";
				stmt.executeUpdate(sql);
			}else{
				System.out.println("帳號重複");
			}
			
			System.out.println("OK");
			

		}catch(Exception e){
			System.out.println(e);
			
		}

	}
	
	static boolean isDataRepeat(String account,Statement stmt) throws Exception{
		String sql = "select count(*) from member where account ='"+ account +"'";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			int num = rs.getInt(1);
			if(num >0) {return true;
			}else{
				return false;}
		}else{
			
			throw new Exception("SQL error");
		}
	}

}
