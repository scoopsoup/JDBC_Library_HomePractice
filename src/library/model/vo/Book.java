package library.model.vo;

public class Book {
	
	private int bookNo;
	private String bookName;
	private String bookWriter;
	private int bookPrice;
	private String publisher;
	private String genre;
	
	public Book() {
		
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

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String toString() {
		return "======BookInfo======" + "\n책 번호 : " + bookNo + "\n책 이름 : " + bookName + "\n저자 : " + bookWriter 
				+ "\n가격 : " + bookPrice + "\n출판사 : " + publisher + "\n장르 : " + genre;
	}

}
