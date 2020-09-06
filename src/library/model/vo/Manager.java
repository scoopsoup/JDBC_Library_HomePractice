package library.model.vo;

import java.sql.Date;

public class Manager {
	
	private int managerNo;
	private String managerName;
	private String managerID;
	private String managerPwd;
	private String managerBirth;
	private String managerGenger;
	private String managerAddr;
	private Date managerEnrollDate;
	
	public Manager() {
		
	}

	public int getManagerNo() {
		return managerNo;
	}

	public void setManagerNo(int managerNo) {
		this.managerNo = managerNo;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerID() {
		return managerID;
	}

	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public String getManagerPwd() {
		return managerPwd;
	}

	public void setManagerPwd(String managerPwd) {
		this.managerPwd = managerPwd;
	}

	public String getManagerBirth() {
		return managerBirth;
	}

	public void setManagerBirth(String managerBirth) {
		this.managerBirth = managerBirth;
	}

	public String getManagerGenger() {
		return managerGenger;
	}

	public void setManagerGenger(String managerGenger) {
		this.managerGenger = managerGenger;
	}

	public String getManagerAddr() {
		return managerAddr;
	}

	public void setManagerAddr(String managerAddr) {
		this.managerAddr = managerAddr;
	}

	public Date getManagerEnrollDate() {
		return managerEnrollDate;
	}

	public void setManagerEnrollDate(Date managerEnrollDate) {
		this.managerEnrollDate = managerEnrollDate;
	}

	@Override
	public String toString() {
		return "Manager [managerNo=" + managerNo + ", managerName=" + managerName + ", managerID=" + managerID
				+ ", managerPwd=" + managerPwd + ", managerBirth=" + managerBirth + ", managerGenger=" + managerGenger
				+ ", managerAddr=" + managerAddr + ", managerEnrollDate=" + managerEnrollDate + "]";
	}
	
	public String showString() {
		return "======Manager Info======" + "\n메니저 번호 : " + managerNo + "\n이름 : " + managerName 
				+ "\n생년월일 : " + managerBirth + "\n성별 : " + managerGenger + "\n주소 : " + managerAddr
				+ "\n발급날짜 : " + managerEnrollDate;
	}

}
