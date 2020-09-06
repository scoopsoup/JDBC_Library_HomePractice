package library.model.vo;

import java.util.ArrayList;

public class MemberSignIn {

	private String userID;
	private String userPwd;
	public ArrayList<MemberSignIn> list;
	
	public MemberSignIn() {
		list = new ArrayList<MemberSignIn>();
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
	
	
}
