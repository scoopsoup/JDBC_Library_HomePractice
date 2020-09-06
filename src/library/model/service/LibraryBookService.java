package library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import common.JDBCTemplate;
import library.model.dao.LibraryBookDAO;
import library.model.vo.Book;

public class LibraryBookService {
	
	private JDBCTemplate factory;
	
	public LibraryBookService() {
		factory = JDBCTemplate.getConnection();
	}
	
//	public int insertBook(Book book) throws Exception {
//		Connection conn = factory.createConnection();
//		int result = new LibraryBookDAO().insertBook(conn, book);
//		JDBCTemplate.close(conn);
//		return result;
//	}

}
