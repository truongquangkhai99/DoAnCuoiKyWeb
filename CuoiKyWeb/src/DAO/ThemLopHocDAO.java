package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThemLopHocDAO {
	public void themLopHoc(int CId, String CName) throws SQLException {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ThiOnline;user=loc1; password=123";
		Connection conn=null;
		PreparedStatement cstmt=null;
		
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn=DriverManager.getConnection(dbURL);
	        }catch(SQLException e) {
	        	System.out.println("Database Connect Failed.");
	            return;
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}		
			String sql= "{call dbo.spThemLopHoc(?,?)}";
			cstmt=conn.prepareStatement(sql);
			
			
			 cstmt.setInt(1,CId);
			 cstmt.setString(2,CName);
			int temp = cstmt.executeUpdate();
			cstmt.close();
			conn.close();
	}
}
