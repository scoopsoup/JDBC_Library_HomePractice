package library.model.vo;

public class LibraryBook {
	
	private int bookNo;
	private String bookName;
	private int bookQTY;
	
	public LibraryBook() {
		
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookQTY() {
		return bookQTY;
	}

	public void setBookQTY(int bookQTY) {
		this.bookQTY = bookQTY;
	}
	
	public String toString() {
		return "======Library Book======" + "\n책코드 : " + bookNo + "\n책 이름 : "+ bookName + "\n재고 : " + bookQTY;
	}
	

}
