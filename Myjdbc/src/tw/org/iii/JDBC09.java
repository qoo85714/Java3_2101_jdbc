package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC09 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/brad",
				prop)){
			Statement stmt = conn.createStatement();
			
			String account = "eric", passwd = "123456";
			
			Member loginMemeber;
			if((loginMemeber = checkMember(stmt, account, passwd)) !=null){
				System.out.println("Welcome,"+loginMemeber.realname);
			}else{
				System.out.println("Error Login");
			}
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);		
		}
	}
	
	static Member checkMember(Statement stmt,String account,String passwd) throws Exception{
		String[] ret = new String[4];
		String sql = "SELECT * from member where account ='"+
				account +"'and passwd ='"+passwd+"'";
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()){
			Member member = new Member(rs.getString("id"),
					rs.getString("account"),
					rs.getString("realname"));
			return member;		
		}else{
			return null;
		}	
	}
}
class Member{
	String id,accout,realname;
	Member(String id,String accout,String realname){
		this.id=id;
		this.accout=accout;
		this.realname=realname;
	}
}
