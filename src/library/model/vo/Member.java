package library.model.vo;

import java.sql.Date;

public class Member {
	
	private int userNo;
	private String userName;
	private String userID;
	private String userPwd;
	private String userBirth;
	private String userGender;
	private String userAddr;
	private Date userEnrollDate;
	
	public Member() {
		
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAddr() {
		return userAddr;
	}

	public void setUserAddr(String userAddr) {
		this.userAddr = userAddr;
	}

	public Date getUserEnrollDate() {
		return userEnrollDate;
	}

	public void setUserEnrollDate(Date userEnrollDate) {
		this.userEnrollDate = userEnrollDate;
	}

	public String toString() {
		return "======Customer Info======" + "\n회원 이름 : " + userName + "\n회원 아이디 : " + userID + "\n회원 비밀번호 : " + userPwd 
				+ "\n회원 생년월일 : " + userBirth + "\n회원 성별 : " + userGender + "\n회원 주소 : " 
				+ userAddr + "\n가입날짜 : " + userEnrollDate;
	}
	
	public String showString() {
		return "======Customer Info======" + "\n회원 이름 : " + userName + "\n회원 생년월일 : " + userBirth 
				+ "\n회원 성별 : " + userGender + "\n회원 주소 : " + userAddr + "\n가입날짜 : " + userEnrollDate;
	}
	
}
