package library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import library.model.dao.ManagerDAO;
import library.model.vo.Manager;
import library.model.vo.ManagerSignIn;

public class ManagerService {

	private JDBCTemplate factory;
	private ManagerSignIn mgs;

	public ManagerService() {
		factory = JDBCTemplate.getConnection();
		mgs = new ManagerSignIn();
	}

	public ArrayList<ManagerSignIn> managerSignIn(ManagerSignIn mgs) throws Exception{
		Connection conn = factory.createConnection();
		mgs.list = new ManagerDAO().managerSignIn(conn, mgs);
		JDBCTemplate.close(conn);
		return mgs.list;
	}
	
	public int getManagerNo(ArrayList<ManagerSignIn> list) throws Exception {
		Connection conn = factory.createConnection();
		int result =  new ManagerDAO().getManagerNo(conn, list);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Manager> selectManagerAll() throws Exception{
		Connection conn = factory.createConnection();
		ArrayList<Manager> list = new ManagerDAO().selectManagerAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public ArrayList<Manager> selectManagerName(String managerName) throws Exception {
		Connection conn = factory.createConnection();
		ArrayList<Manager> list = new ManagerDAO().selectManagerName(conn, managerName);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public Manager selectManagerNo(int managerNo) throws Exception {
		Connection conn = factory.createConnection();
		Manager manager = new ManagerDAO().selectManagerNo(conn, managerNo);
		JDBCTemplate.close(conn);
		return manager;
	}
	
	public int insertManager(Manager manager) throws Exception {
		Connection conn = factory.createConnection();
		int result = new ManagerDAO().insertManager(conn, manager);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteManager(Manager manager) throws Exception{
		Connection conn = factory.createConnection();
		int result = new ManagerDAO().deleteManager(conn, manager);
		JDBCTemplate.close(conn);
		return result;
	}

}
