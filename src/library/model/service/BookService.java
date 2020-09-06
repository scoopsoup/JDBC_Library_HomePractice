package library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import library.model.dao.BookDAO;
import library.model.vo.Book;

public class BookService {
	
	private JDBCTemplate factory;
	
	public BookService() {
		factory = new JDBCTemplate().getConnection();
	}
	
	public ArrayList<Book> selectBookAll() throws Exception{
		Connection conn = factory.createConnection();
		ArrayList<Book> list = new BookDAO().selectBookAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public Book selectBookNo(int bookNo) throws Exception {
		Connection conn = factory.createConnection();
		Book book = new BookDAO().selectBookNo(conn, bookNo);
		JDBCTemplate.close(conn);
		return book;
	}
	
	public ArrayList<Book> selectBookName(String bookName) throws Exception{
		Connection conn = factory.createConnection();
		ArrayList<Book> list = new BookDAO().selectBookName(conn, bookName);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int insertBook(Book book) throws Exception {
		Connection conn = factory.createConnection();
		int result = new BookDAO().insertBook(conn, book);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int deleteBook(Book book) throws Exception{
		Connection conn = factory.createConnection();
		int result = new BookDAO().deleteBook(conn, book);
		JDBCTemplate.close(conn);
		return result;
	}

}
