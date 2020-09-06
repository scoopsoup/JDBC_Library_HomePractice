package common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	
static Properties prop = new Properties();
	
	public JDBCTemplate() {
		try {
			prop.load(new FileReader("resources/driver.properties"));
			String driver = prop.getProperty("driver");
			Class.forName(driver);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static JDBCTemplate instance;
	
	public static JDBCTemplate getConnection() {
		if(instance == null) {
			instance = new JDBCTemplate();
		}
		return instance;
	}
	
	public static Connection createConnection() throws SQLException {
		Connection conn = null;
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		
		conn = DriverManager.getConnection(url, user, password);
		conn.setAutoCommit(false);
		return conn;
		
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
