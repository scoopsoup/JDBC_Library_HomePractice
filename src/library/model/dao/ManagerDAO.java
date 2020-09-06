package library.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import common.JDBCTemplate;
import library.model.vo.Manager;
import library.model.vo.ManagerSignIn;

public class ManagerDAO {

	private Properties prop = new Properties();

	public ManagerDAO() {
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ManagerSignIn> managerSignIn(Connection conn, ManagerSignIn mgs){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("managerSignIn");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mgs.getManagerID());
			pstmt.setString(2, mgs.getManagerPwd());
			rset = pstmt.executeQuery();

			if(rset.next()) {
				mgs.list.add(mgs);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return mgs.list;
	}

	public int getManagerNo(Connection conn, ArrayList<ManagerSignIn> list) {
		int managerNo = 0;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("getManagerNo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, list.get(0).getManagerID());
			pstmt.setString(2, list.get(0).getManagerPwd());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				managerNo = rset.getInt("MANAGER_NO");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return managerNo;
	}

	public ArrayList<Manager> selectManagerAll(Connection conn){
		ArrayList<Manager> list = null;

		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectManagerAll");

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				list = new ArrayList<Manager>();
				while(rset.next()) {
					Manager manager = new Manager();
					manager.setManagerNo(rset.getInt("MANAGER_NO"));
					manager.setManagerName(rset.getString("MANAGER_NAME"));
					manager.setManagerID(rset.getString("MANAGER_ID"));
					manager.setManagerPwd(rset.getString("MANAGER_PWD"));
					manager.setManagerBirth(rset.getString("MANAGER_BIRTH"));
					manager.setManagerGenger(rset.getString("MANAGER_GENDER"));
					manager.setManagerAddr(rset.getString("MANAGER_ADDR"));
					manager.setManagerEnrollDate(rset.getDate("MANAGER_ENROLL_DATE"));
					list.add(manager);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}

		return list;
	}

	public ArrayList<Manager> selectManagerName(Connection conn, String managerName){
		ArrayList<Manager> list = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectManagerName");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + managerName + "%");
			rset = pstmt.executeQuery();

			if(rset != null) {
				list = new ArrayList<Manager>();
				while(rset.next()) {
					Manager manager = new Manager();
					manager.setManagerNo(rset.getInt("MANAGER_NO"));
					manager.setManagerName(rset.getString("MANAGER_NAME"));
					manager.setManagerID(rset.getString("MANAGER_ID"));
					manager.setManagerPwd(rset.getString("MANAGER_PWD"));
					manager.setManagerBirth(rset.getString("MANAGER_BIRTH"));
					manager.setManagerGenger(rset.getString("MANAGER_GENDER"));
					manager.setManagerAddr(rset.getString("MANAGER_ADDR"));
					manager.setManagerEnrollDate(rset.getDate("MANAGER_ENROLL_DATE"));
					list.add(manager);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return list;

	}

	public Manager selectManagerNo(Connection conn, int managerNo) {
		Manager manager = null;

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectManagerNo");

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, managerNo);
			rset = pstmt.executeQuery();

			if(rset.next()) {
				manager = new Manager();
				manager.setManagerNo(rset.getInt("MANAGER_NO"));
				manager.setManagerName(rset.getString("MANAGER_NAME"));
				manager.setManagerID(rset.getString("MANAGER_ID"));
				manager.setManagerPwd(rset.getString("MANAGER_PWD"));
				manager.setManagerBirth(rset.getString("MANAGER_BIRTH"));
				manager.setManagerGenger(rset.getString("MANAGER_GENDER"));
				manager.setManagerAddr(rset.getString("MANAGER_ADDR"));
				manager.setManagerEnrollDate(rset.getDate("MANAGER_ENROLL_DATE"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}

		return manager;
	}
	
	public int insertManager(Connection conn, Manager manager) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertManager");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, manager.getManagerName());
			pstmt.setString(2, manager.getManagerID());
			pstmt.setString(3, manager.getManagerPwd());
			pstmt.setString(4, manager.getManagerBirth());
			pstmt.setString(5, manager.getManagerGenger());
			pstmt.setString(6, manager.getManagerAddr());
			result = pstmt.executeUpdate();
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteManager(Connection conn, Manager manager) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteManager");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, manager.getManagerNo());
			pstmt.setString(2, manager.getManagerName());
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
