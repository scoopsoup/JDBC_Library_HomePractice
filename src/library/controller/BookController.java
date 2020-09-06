package library.controller;

import java.util.ArrayList;

import library.model.service.BookService;
import library.model.vo.Book;
import library.view.LibraryMenu;

public class BookController {
	
	public BookController() {
		
	}
	
	public void selectBookAll() {
		LibraryMenu menu = new LibraryMenu();
		try {
			ArrayList<Book> list = new BookService().selectBookAll();
			menu.selectBookAll(list);
			menu.display("책 조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			menu.display("책 조회 실패");
		}
	}
	
	public void selectBookNo(int bookNo) {
		LibraryMenu menu = new LibraryMenu();
		try {
			Book book = new BookService().selectBookNo(bookNo);
			menu.selectBookOne(book);
			menu.display("책 조회 성공");
		}
		catch(Exception e) {
			menu.display("책 조회 실패");
		}
	}
	
	public void selectBookName(String bookName) {
		LibraryMenu menu = new LibraryMenu();
		try {
			ArrayList<Book> list = new BookService().selectBookName(bookName);
			menu.selectBookAll(list);
			menu.display("책 조회 성공");
		}
		catch(Exception e) {
			menu.display("책 조회 실패");
		}
	}
	
	public void insertBook(Book book) {
		LibraryMenu menu = new LibraryMenu();
		try {
			int result = new BookService().insertBook(book);
			menu.display("책 등록 성공");
		}
		catch(Exception e) {
			menu.display("책 등록 실패");
		}
	}
	
	public void deleteBook(Book book) {
		LibraryMenu menu = new LibraryMenu();
		try {
			int result = new BookService().deleteBook(book);
			menu.display("책 삭제 성공");
		}
		catch(Exception e) {
			menu.display("책 삭제 실패");
		}
	}

}
