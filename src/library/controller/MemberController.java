package library.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import library.model.service.ManagerService;
import library.model.service.MemberService;
import library.model.vo.Member;
import library.model.vo.MemberSignIn;
import library.view.LibraryMenu;

public class MemberController {
	MemberSignIn ms;
	
	public MemberController() {
		ms = new MemberSignIn();
	}
	
//	public int memberSignIn(Member member) {
//		LibraryMenu menu = new LibraryMenu();
//		int result = 0;
//		try {
//			result = new MemberService().memberSignIn(member);
//			menu.display("로그인 성공");
//		} catch (Exception e) {
//			e.printStackTrace();
//			menu.display("로그인 실패");
//		}
//		return result;
//	}
	
	public ArrayList<MemberSignIn> memberSignIn(MemberSignIn member) {
		LibraryMenu menu = new LibraryMenu();
		ms.list = null;
		try {
			ms.list = new MemberService().memberSignIn(member);
			menu.display("로그인 성공");
		} catch (Exception e) {
			e.printStackTrace();
			menu.display("로그인 실패");
		}
		return ms.list;
	}
	
	
	public void memberSignUp(Member member) {
		LibraryMenu menu = new LibraryMenu();
		try {
			int result = new MemberService().memberSignUp(member);
			menu.display("회원가입 성공");
		} catch (Exception e) {
			e.printStackTrace();
			menu.display("회원가입 실패");
		}
	}
	
	public void selectMemberAll() {
		LibraryMenu menu = new LibraryMenu();
		try {
			ArrayList<Member> list = new MemberService().selectMemberAll();
			menu.selectMemberAll(list);
			menu.display("회원 조회 성공");
		} catch (Exception e) {
			menu.display("회원 조회 실패");
		}
	}
	
	public void selectMemberName(String memberName) {
		LibraryMenu menu = new LibraryMenu();
		try {
			ArrayList<Member> list = new MemberService().selectMemberName(memberName);
			menu.selectMemberAll(list);
			menu.display("회원 조회 성공");
		}
		catch(Exception e) {
			menu.display("회원 조회 실패");
		}
	}
	
	public void selectMemberNo(int memberNo) {
		LibraryMenu menu = new LibraryMenu();
		try {
			Member member = new MemberService().selectMemberNo(memberNo);
			menu.selectMemberOne(member);
			menu.display("회원 조회 성공");
		}
		catch(Exception e) {
			menu.display("회원 조회 실패");
		}
	}
	
	public void deleteMember(String memberID, String memberPwd) {
		LibraryMenu menu = new LibraryMenu();
		try {
			int result = new MemberService().deleteMember(memberID, memberPwd);
			menu.display("회원 탈퇴 성공");
		}
		catch(Exception e) {
			menu.display("회원 탈퇴 실패");
		}
	}
	
	public void showMyInfo(ArrayList<MemberSignIn> list) {
		LibraryMenu menu = new LibraryMenu();
		try {
			Member member = new MemberService().showMyInfo(list);
			menu.showMyInfo(member);
			menu.display("내정보 조회 성공");
		}
		catch(Exception e) {
			menu.display("내정보 조회 실패");
		}
	}

}
