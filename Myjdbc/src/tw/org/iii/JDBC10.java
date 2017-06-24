package tw.org.iii;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC10 {

	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "root");
		
		try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/brad",
				prop)){
			Statement stmt = conn.createStatement();
//			String sql ="SELECT * FROM gift WHERE ProduceOrg='水里鄉農會'";
//			String sqlCond ="WHERE Name LIKE '%禮盒' ";
//			String sqlCount ="SELECT count(*) as num FROM gift "+sqlCond;
			String keyword = "金棗"; 
			String sqlCond = "WHERE Name LIKE '%" + keyword + 
					"%' or Feature LIKE '%" + keyword + 
					"%' or SalePlace LIKE '%" + keyword + "%'";
			
			String sqlCount = "SELECT count(*) as num FROM gift " + sqlCond;
			System.out.println(sqlCount);
			ResultSet rsCount = stmt.executeQuery(sqlCount);
			if (!rsCount.next()) return;
			
			int total = rsCount.getInt("num");	// 50
			int rpp = 20;
			int page = 1;
			
			int lastPage = (total%rpp==0)?(total/rpp):(total/rpp+1);	// 
			page = (page<=lastPage)?page:lastPage;
			int start = (page-1)*rpp;
			
			String sql = "SELECT * FROM gift " + sqlCond + " limit " + 
					start + ", " + rpp;
			ResultSet rs = stmt.executeQuery(sql);
			int i = 0;
			while (rs.next()){
				String gid = rs.getString("gid");
				String name = rs.getString("Name");
				System.out.println((++i) + " : "  + gid + " : " + name);
			}
			
			System.out.println("OK");
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
}