package library.controller;

import java.util.ArrayList;

import library.model.service.ManagerService;
import library.model.vo.Manager;
import library.model.vo.ManagerSignIn;
import library.view.LibraryMenu;

public class ManagerController {

	private ManagerSignIn mgs;

	public ManagerController() {
		mgs = new ManagerSignIn();
	}

	public ArrayList<ManagerSignIn> managerSignIn(ManagerSignIn mgs) {
		LibraryMenu menu = new LibraryMenu();
		try {
			mgs.list = new ManagerService().managerSignIn(mgs);
			if(mgs.list.isEmpty()) {
				menu.display("로그인 실패");
			}
			else {
				menu.display("로그인 성공");
			}

		}
		catch(Exception e) {
			menu.display("로그인 실패");
		}
		return mgs.list;
	}

	public int getManagerNo(ArrayList<ManagerSignIn> list) {
		LibraryMenu menu = new LibraryMenu();
		int result = 0;
		try {
			result = new ManagerService().getManagerNo(list);
		}
		catch(Exception e) {

		}
		return result;
	}

	public void selectManagerAll() {
		LibraryMenu menu = new LibraryMenu();
		try {
			ArrayList<Manager> list = new ManagerService().selectManagerAll();
			menu.selectManagerAll(list);
			menu.display("관리자 조회 성공");
		}
		catch(Exception e) {
			menu.display("관리자 조회 실패");
		}
	}

	public void selectManagerName(String managerName) {
		LibraryMenu menu = new LibraryMenu();
		try {
			ArrayList<Manager> list = new ManagerService().selectManagerName(managerName);
			menu.selectManagerAll(list);
			menu.display("관리자 조회 성공");
		}
		catch(Exception e) {
			menu.display("관리자 조회 실패");
		}
	}

	public void selectManagerNo(int managerNo) {
		LibraryMenu menu = new LibraryMenu();
		try {
			Manager manager = new ManagerService().selectManagerNo(managerNo);
			menu.selectManagerOne(manager);
			menu.display("관리자 조회 성공");
		}
		catch(Exception e) {
			menu.display("관리자 조회 실패");
		}
	}
	
	public void insertManager(Manager manager) {
		LibraryMenu menu = new LibraryMenu();
		try {
			int result = new ManagerService().insertManager(manager);
			menu.display("메니저 등록 성공");
		}
		catch(Exception e) {
			menu.display("메니저 등록 실패");
		}
	}
	
	public void deleteManager(Manager manager) {
		LibraryMenu menu = new LibraryMenu();
		try {
			int result = new ManagerService().deleteManager(manager);
			menu.display("메니저 삭제 성공");
		}
		catch(Exception e) {
			menu.display("메니저 삭제 실패");
		}
	}

}
