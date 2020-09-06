package library.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import library.model.vo.Book;

public class LibraryBookDAO {
	Properties prop = new Properties();
	
	public LibraryBookDAO() {
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public int insertBook(Connection conn, Book book) {
//		int result = 0;
//		int count = 0;
//		PreparedStatement pstmt = null;
//		Statement stmt = null;
//		ResultSet rset = null;
//		String queryIn = prop.getProperty("insertBook");
//		String queryUp = prop.getProperty("updateBook");
//		String queryse = prop.getProperty("searchBookNo");
//		
//		int bookNo = 0;
//		try {
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(queryse);
//			if(rset != null) {
//				while(rset.next()) {
//					bookNo = rset.getInt("BOOK_NO");
//					if(bookNo == book.getBookNo()) {
//						pstmt = conn.prepareStatement(queryUp);
//						pstmt.setInt(1, book.getBookNo());
//						result = pstmt.executeUpdate();
//						count = 1;
//						break;
//					}
//				}
//				if(count != 1) {
//					pstmt = conn.prepareStatement(queryIn);
//					pstmt.setString(1, book.getBookName());
//					pstmt.setString(2, book.getBookWriter());
//					pstmt.setInt(3, book.getBookPrice());
//					pstmt.setString(4, book.getPublisher());
//					pstmt.setString(5, book.getGenre());
//					result = pstmt.executeUpdate();
//				}
//			}
//			
//			if(result > 0) {
//				
//			}
//			else {
//				
//			}
//		}
//		catch(Exception e) {
//			
//		}
//		
//		
//		return result;
//	}

}
