package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ThemDeThiDAO {
	public void CreateTest(String TestName,String Time_Test) throws SQLException {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ThiOnline;user=loc1;password=123";
		Connection conn = null;
		PreparedStatement cstmt = null;
		
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn=DriverManager.getConnection(dbURL);
	        }catch(SQLException e) {
	        	System.out.println("Database Connect Failed.");
	            return;
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String sql= "{call dbo.spCreateTest(?,?)}";
			cstmt=conn.prepareStatement(sql);
	
			cstmt.setString(1, TestName);
			int time = Integer.valueOf(Time_Test);
			cstmt.setInt(2, time);
			
			int temp = cstmt.executeUpdate();
			
			cstmt.close();
			conn.close();
	}
	
	public void CreateNoiDungTest(String TestId,String QuestionId) throws SQLException {
		String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=ThiOnline;user=loc1;password=123";
		Connection conn = null;
		PreparedStatement cstmt = null;
		
		try {
			 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			 conn=DriverManager.getConnection(dbURL);
	        }catch(SQLException e) {
	        	System.out.println("Database Connect Failed.");
	            return;
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String sql= "{call dbo.spCreateNoiDungTest(?,?)}";
			cstmt=conn.prepareStatement(sql);
	
			int id = Integer.valueOf(TestId);
			cstmt.setInt(1, id);
			int qid = Integer.valueOf(QuestionId);
			cstmt.setInt(2, qid);
			
			int temp = cstmt.executeUpdate();
			
			cstmt.close();
			conn.close();
	}
}
