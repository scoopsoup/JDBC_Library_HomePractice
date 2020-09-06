package library.model.vo;

import java.sql.Date;

public class LibraryCustomer {
	
	private int leaseNo;
	private int bookNo;
	private int userID;
	private Date leaseDate;
	private Date returnDate;
	
	public LibraryCustomer() {
		
	}

	public int getLeaseNo() {
		return leaseNo;
	}

	public void setLeaseNo(int leaseNo) {
		this.leaseNo = leaseNo;
	}

	public int getBookNo() {
		return bookNo;
	}

	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public Date getLeaseDate() {
		return leaseDate;
	}

	public void setLeaseDate(Date leaseDate) {
		this.leaseDate = leaseDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	@Override
	public String toString() {
		return "LibraryCustomer [leaseNo=" + leaseNo + ", bookNo=" + bookNo + ", userID=" + userID + ", leaseDate="
				+ leaseDate + ", returnDate=" + returnDate + "]";
	}

}
