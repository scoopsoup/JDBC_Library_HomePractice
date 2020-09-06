package library.model.vo;

import java.util.ArrayList;

public class ManagerSignIn {
	
	private String managerID;
	private String managerPwd;
	public ArrayList<ManagerSignIn> list;
	
	public ManagerSignIn() {
		list = new ArrayList<ManagerSignIn>();
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
	
	

}
