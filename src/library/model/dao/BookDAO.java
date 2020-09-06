package library.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;

import common.JDBCTemplate;
import library.model.vo.Book;

public class BookDAO {
	
	Properties prop = new Properties();
	
	public BookDAO() {
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Book> selectBookAll(Connection conn){
		ArrayList<Book> list = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectBookAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book book = new Book();
					book.setBookNo(rset.getInt("BOOK_NO"));
					book.setBookName(rset.getString("BOOK_NAME"));
					book.setBookWriter(rset.getString("BOOK_WRITER"));
					book.setBookPrice(rset.getInt("BOOK_PRICE"));
					book.setPublisher(rset.getString("PUBLISHER"));
					book.setGenre(rset.getString("GENRE"));
					list.add(book);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public Book selectBookNo(Connection conn, int bookNo) {
		Book book = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectBookNo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bookNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				book = new Book();
				book.setBookNo(rset.getInt("BOOK_NO"));
				book.setBookName(rset.getString("BOOK_NAME"));
				book.setBookWriter(rset.getString("BOOK_WRITER"));
				book.setBookPrice(rset.getInt("BOOK_PRICE"));
				book.setPublisher(rset.getString("PUBLISHER"));
				book.setGenre(rset.getString("GENRE"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return book;
	}
	
	public ArrayList<Book> selectBookName(Connection conn, String bookName){
		ArrayList<Book> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectBookName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + bookName + "%");
			rset = pstmt.executeQuery();
			if(rset != null) {
				list = new ArrayList<Book>();
				while(rset.next()) {
					Book book = new Book();
					book.setBookNo(rset.getInt("BOOK_NO"));
					book.setBookName(rset.getString("BOOK_NAME"));
					book.setBookWriter(rset.getString("BOOK_WRITER"));
					book.setBookPrice(rset.getInt("BOOK_PRICE"));
					book.setPublisher(rset.getString("PUBLISHER"));
					book.setGenre(rset.getString("GENRE"));
					list.add(book);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public int insertBook(Connection conn, Book book) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertBook");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookWriter());
			pstmt.setInt(3, book.getBookPrice());
			pstmt.setString(4, book.getPublisher());
			pstmt.setString(5, book.getGenre());
			
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
		finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int deleteBook(Connection conn, Book book) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteBook");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, book.getBookNo());
			pstmt.setString(2, book.getBookName());
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
		finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

}
