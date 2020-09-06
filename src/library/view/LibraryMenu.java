package library.view;

import java.util.ArrayList;
import java.util.Scanner;

import library.controller.BookController;
import library.controller.LibraryBookController;
import library.controller.ManagerController;
import library.controller.MemberController;
import library.model.vo.Book;
import library.model.vo.Manager;
import library.model.vo.ManagerSignIn;
import library.model.vo.Member;
import library.model.vo.MemberSignIn;

public class LibraryMenu {
	Scanner sc;
	MemberController mc;
	BookController bc;
	ManagerController mgc;
	MemberSignIn ms;
	ManagerSignIn mgs;
	LibraryBookController lbc;

	public LibraryMenu() {
		sc = new Scanner(System.in);
		mc = new MemberController();
		bc = new BookController();
		mgc = new ManagerController();
		ms = new MemberSignIn();
		mgs = new ManagerSignIn();
		lbc = new LibraryBookController();
	}

	public void mainMenu() {
		int choice;
		while(true) {
			System.out.println("======도서관 관리 프로그램======");
			System.out.println("1. 서비스 이용하기"); // 회원
			System.out.println("2. 회원 관리"); // 메니저
			System.out.println("3. 대여 관리"); // 메니저
			System.out.println("4. 책 관리"); // 메니저
			System.out.println("5. 메니저 관리"); // 최상위 메니저
			System.out.println("0. 종료");
			System.out.print("선택 >> ");
			try {
				choice = Integer.parseInt(sc.nextLine());
				switch(choice) {
				case 1:
					this.useService();
					break;

				case 2:
					this.customerManage();
					break;

				case 3:
					this.libraryManage();
					break;

				case 4:
					this.bookManage();
					break;

				case 5:
					this.manager();
					break;

				case 0:
					System.out.println("서비스 종료");
					return;

				default:
					System.out.println("잘못된 메뉴선택입니다.");
				}
			}
			catch(Exception e) {
				System.out.println("숫자를 입력해주세요.");
			}
			break;
		}

	}

	public void useService() {
		int choice = 10;
		while(choice != 0) {
			System.out.println("======서비스 이용하기======");
			System.out.println("1. 회원 로그인");
			System.out.println("2. 회원가입");
			System.out.println("3. 내정보 조회");
			System.out.println("4. 내 대여정보 조회");
			System.out.println("5. 책 조회하기");
			System.out.println("6. 책 대여하기");
			System.out.println("7. 회원 로그아웃");
			System.out.println("8. 회원 탈퇴");
			System.out.println("0. 돌아가기");
			System.out.print("선택 >> ");

			try {
				choice = Integer.parseInt(sc.nextLine());

				switch(choice) {
				case 1: // 회원 로그인
					if(ms.list.isEmpty()) {
						ms.list = mc.memberSignIn(this.memberSignIn());
					}
					else {
						System.out.println("로그아웃을 해야 합니다.");
						System.out.print("로그아웃을 하시겠습니까?(Y / N) : ");
						try {
							String answer = sc.nextLine();
							if(answer.equalsIgnoreCase("y")) {
								ms.list.clear();
								System.out.println("로그아웃 완료");
							}
							else if(answer.equalsIgnoreCase("n")) {

							}
							else {
								System.out.println("잘못된 입력값입니다.");
							}
						}
						catch(Exception e) {
							System.out.println("잘못된 입력입니다.");
						}
					}
					break;

				case 2: // 회원 가입
					mc.memberSignUp(this.customerSignUp());
					break;

				case 3: // 내정보 조회
					mc.showMyInfo(ms.list);
					break;

				case 4: // 내 대여정보 조회
					break;

				case 5: // 책 조회
					int searchNum = 10;
					while(searchNum != 0) {
						System.out.println("======책 조회======");
						System.out.println("1. 전체 조회");
						System.out.println("2. 코드로 조회하기");
						System.out.println("3. 이름으로 조회하기");
						System.out.println("0. 뒤로가기");
						System.out.print("선택  >> ");
						try {
							searchNum = Integer.parseInt(sc.nextLine());
							if(searchNum == 1) { // 전체 조회
								bc.selectBookAll();
								break;
							}
							else if(searchNum == 2) { // 코드로 조회
								bc.selectBookNo(this.searchBookNo());
								break;
							}
							else if(searchNum == 3) { // 이름으로 조회
								bc.selectBookName(this.searchBookName());
								break;
							}
							else {
								System.out.println("잘못된 메뉴선택입니다.");
							}
						}
						catch(Exception e) {
							System.out.println("숫자를 입력해주세요.");
						}
					}

					break;

				case 6: // 책대여 -> 로그인을 해야 할 수 있음.
					if(!ms.list.isEmpty()) {
						int answer;
						System.out.println("======책 대여======");
						System.out.println("1. 코드로 검색하기");
						System.out.println("2. 이름으로 검색하기");
						System.out.print("선택 >> ");
						try {
							answer = Integer.parseInt(sc.nextLine());
						}
						catch(Exception e) {
							System.out.println("숫자를 입력해주세요.");
						}
					}
					else {
						System.out.println("로그인을 해야 이용할수 있습니다.");
					}
					break;

				case 7: // 로그아웃
					System.out.print("로그아웃 하시겠습니까?(Y / N) : ");
					try {
						String answer = sc.nextLine();
						if(answer.equalsIgnoreCase("Y")) {
							ms.list.clear();
							System.out.println("로그아웃 완료");
						}
						else if(answer.equalsIgnoreCase("N")) {

						}
						else {
							System.out.println("잘못된 입력값입니다.");
						}
					}
					catch(Exception e) {

					}

					break;

				case 8: // 탈퇴
					while(true) {
						if(!ms.list.isEmpty()) { // 로그인 되있을때
							//							System.out.println(ms.list.get(0).getUserID());
							//							System.out.println(ms.list.get(0).getUserPwd());
							mc.deleteMember(ms.list.get(0).getUserID(), ms.list.get(0).getUserPwd());
							break;
						}
						else { // 로그인 안되있을때
							ms.list = mc.memberSignIn(this.memberSignIn());//로그인
							break;
						}
					}

					break;

				case 0:
					break;

				default:
					System.out.println("잘못된 메뉴션택입니다.");
				}
			}
			catch(Exception e) {
				System.out.println("숫자를 입력해주세요.");
			}
		}
		this.mainMenu();

	}

	public Member customerSignIn() { // 회원 로그인
		Member member = new Member();
		System.out.println("======회원 로그인======");
		System.out.print("아이디 : ");
		member.setUserID(sc.nextLine());
		System.out.print("비밀번호 : ");
		member.setUserPwd(sc.nextLine());

		return member;
	}

	public MemberSignIn memberSignIn() {
		MemberSignIn member = new MemberSignIn();
		System.out.println("======회원 로그인======");
		System.out.print("아이디 : ");
		member.setUserID(sc.nextLine());
		System.out.print("비밀번호 : ");
		member.setUserPwd(sc.nextLine());

		return member;
	}

	public Member customerSignUp() { // 회원 가입
		Member member = new Member();
		System.out.println("======회원 가입======");
		System.out.print("이름 : ");
		member.setUserName(sc.nextLine());
		System.out.print("아이디 : ");
		member.setUserID(sc.nextLine());
		System.out.print("비밀번호 : ");
		member.setUserPwd(sc.nextLine());
		System.out.print("생년월일(19991122 / 991122) : ");
		member.setUserBirth(sc.nextLine());
		System.out.print("성별(M / F) : ");
		member.setUserGender(sc.nextLine());
		System.out.print("주소 : ");
		member.setUserAddr(sc.nextLine());

		return member;
	}

	public void showMyInfo(Member member) { // 내정보 조회
		System.out.println(member.toString());
	}

	public int searchBookNo() { // 책 코드 받기
		System.out.print("책 코드 입력 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public String searchBookName() { // 책 이름 받기
		System.out.print("책 이름 입력 : ");
		return sc.nextLine();
	}

	public void selectBookAll(ArrayList<Book> list) { // 책 여러권 조회
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).toString());
		}
	}

	public void selectBookOne(Book book) { // 책 한권 조회
		System.out.println(book.toString());
	}

	public void customerManage() { // 회원 관리
		int answer = 10;
		int choice = 10;

		while(answer != 0 || choice != 0 || choice != 4) {
			System.out.println("======회원관리======");
			System.out.println("**일반 회원은 사용할 수 없습니다.**");
			if(mgs.list.isEmpty()) {
				while(answer != 0) {
					System.out.println("1. 메니저 로그인");
					System.out.println("0. 뒤로가기");
					System.out.print("선택 >> ");
					try {
						answer = Integer.parseInt(sc.nextLine());
						if(answer == 1) {
							mgs.list = mgc.managerSignIn(this.managerSignIn());
							break;
						}
						else if(answer == 0) {
							break;
						}
						else {
							System.out.println("잘못된 메뉴선택입니다.");
						}
					}
					catch(Exception e) {
						System.out.println("숫자를 입력해주세요.");
					}
				}
			}
			else {
				while(choice != 0 && choice != 4) {
					System.out.println("1. 회원 전체 조회");
					System.out.println("2. 회원 이름으로 조회");
					System.out.println("3. 회원 번호로 조회");
					System.out.println("4. 로그아웃");
					System.out.println("0. 뒤로가기");
					System.out.print("선택 >> ");
					try {
						choice = Integer.parseInt(sc.nextLine());
						switch(choice) {
						case 1:
							mc.selectMemberAll();
							break;

						case 2:
							mc.selectMemberName(this.searchMemberName());
							break;

						case 3:
							mc.selectMemberNo(this.searchMemberNo());
							break;

						case 4:
							mgs.list.clear();
							break;

						case 0:
							break;

						default :
							System.out.println("잘못된 메뉴선택입니다.");
						}
					}
					catch(Exception e) {
						System.out.println("숫자를 입력해주세요.");
					}
				}
			}
			if(answer == 0 || choice == 0 || choice == 4) {
				break;
			}
			else {
				continue;
			}
		}
		this.mainMenu();

	}

	public ManagerSignIn managerSignIn() { // 메니저 로그인
		ManagerSignIn manager = new ManagerSignIn();
		System.out.println("======메니저 로그인======");
		System.out.print("아이디 : ");
		manager.setManagerID(sc.nextLine());
		System.out.print("비밀번호 : ");
		manager.setManagerPwd(sc.nextLine());

		return manager;
	}

	public String searchMemberName() { // 회원 이름 받기
		System.out.print("회원 이름 입력 : ");
		return sc.nextLine();
	}

	public int searchMemberNo() { // 회원 코드 받기
		System.out.print("회원 코드 입력 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public void selectMemberAll(ArrayList<Member> list) { // 회원 전체 조회
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).showString());
		}
	}

	public void selectMemberOne(Member member) { // 회원 한명 조회
		System.out.println(member.showString());
	}

	public void libraryManage() { // 대여 관리
		int answer = 10;
		int choice = 10;
		while(answer != 0 || choice != 0 || choice != 4) {
			System.out.println("======대여관리======");
			System.out.println("**일반 회원은 사용할 수 없습니다.**");
			if(mgs.list.isEmpty()) {
				while(answer != 0) {
					System.out.println("1. 메니저 로그인");
					System.out.println("0. 뒤로가기");
					System.out.print("선택 >> ");
					try {
						answer = Integer.parseInt(sc.nextLine());
						if(answer == 1) {
							mgs.list = mgc.managerSignIn(this.managerSignIn());
							break;
						}
						else if(answer == 0) {
							break;
						}
						else {
							System.out.println("잘못된 메뉴선택입니다.");
						}
					}
					catch(Exception e) {
						System.out.println("숫자를 입력해주세요.");
					}
				}
			}
			else {
				System.out.println("1. 전체 대여목록 조회");
				System.out.println("2. 회원코드로 조회");
				System.out.println("3. 책이름으로 조회");
				System.out.println("4. 로그아웃");
				System.out.println("0. 뒤로가기");
				System.out.print("선택 >>");
				try {
					choice = Integer.parseInt(sc.nextLine());
					switch(choice) {
					case 1:
						break;

					case 2:
						break;

					case 3:
						break;

					case 4:
						mgs.list.clear();
						break;

					case 0:
						break;

					default :
						System.out.println("잘못된 메뉴선택입니다.");
					}
				}
				catch(Exception e) {
					System.out.println("숫자를 입력해주세요.");
				}			
			}

			if(answer == 0 || choice == 0 || choice == 4) {
				break;
			}
			else {
				continue;
			}
		}
		this.mainMenu();

	}

	public void bookManage() { // 책 관리
		int answer = 10;
		int choice = 10;
		while(true) {
			System.out.println("======책 관리======");
			System.out.println("**일반 회원은 사용할 수 없습니다.**");
			if(mgs.list.isEmpty()) {
				while(answer != 0) {
					System.out.println("1. 메니저 로그인");
					System.out.println("0. 되돌아가기");
					System.out.print("선택 >> ");
					try {
						answer = Integer.parseInt(sc.nextLine());
						if(answer == 1) {
							mgs.list = mgc.managerSignIn(this.managerSignIn());
							break;
						}
						else if(answer == 0) {
							break;
						}
						else {
							System.out.println("잘못된 메뉴선택입니다.");
						}
					}
					catch(Exception e) {
						System.out.println("숫자를 입력해주세요.");
					}
				}
			}
			else {
				while(choice != 0 && choice != 5) {
					System.out.println("1. 책 전체 조회");
					System.out.println("2. 책 코드로 조회");
					System.out.println("3. 책 추가하기");
					System.out.println("4. 책 삭제하기");
					System.out.println("5. 로그아웃");
					System.out.println("0. 되돌아가기");
					System.out.print("선택 >> ");
					try {
						choice = Integer.parseInt(sc.nextLine());
						switch(choice) {
						case 1:
							bc.selectBookAll();
							break;

						case 2:
							bc.selectBookNo(this.searchBookNo());
							break;

						case 3:
//							lbc.insertBook(this.insertBook());
							bc.insertBook(this.insertBook());
							break;

						case 4:
							bc.deleteBook(this.deleteBook());
							break;

						case 5:
							mgs.list.clear();
							break;

						case 0:
							break;

						default:
							System.out.println("잘못된 메뉴선택입니다.");
						}
					}
					catch(Exception e) {
						System.out.println("숫자를 입력해주세요.");
					}

				}

			}
			if(answer == 0 || choice == 0 || choice == 5) {
				break;
			}
			else {
				continue;
			}
		}
		this.mainMenu();

	}

	public Book insertBook() {
		Book book = new Book();
		System.out.println("======책 등록======");
		System.out.print("책이름 : ");
		book.setBookName(sc.nextLine());
		System.out.print("저자 : ");
		book.setBookWriter(sc.nextLine());
		System.out.print("가격 : ");
		book.setBookPrice(Integer.parseInt(sc.nextLine()));
		System.out.print("출판사 : ");
		book.setPublisher(sc.nextLine());
		System.out.print("장르 : ");
		book.setGenre(sc.nextLine());

		return book;
	}

	public Book deleteBook() {
		Book book = new Book();
		System.out.println("======책 삭제======");
		System.out.print("책 코드 : ");
		book.setBookNo(Integer.parseInt(sc.nextLine()));
		System.out.print("책 이름 : ");
		book.setBookName(sc.nextLine());

		return book;
	}

	public void manager() { // 메니저 관리 -> MANABER_NO = 1인경우만 가능
		int answer = 10;
		int choice = 10;
		while(answer != 0 || choice != 0 || choice != 6) {
			System.out.println("======메니저 관리======");
			System.out.println("**최상위 메니저만 이용할 수 있습니다.**");
			if(!mgs.list.isEmpty() && mgc.getManagerNo(mgs.list) == 1) {
				System.out.println("1. 메니저 전체 조회");
				System.out.println("2. 메니저 이름으로 조회");
				System.out.println("3. 메니저 번호로 조회");
				System.out.println("4. 메니저 추가");
				System.out.println("5. 메니저 삭제");
				System.out.println("6. 로그아웃");
				System.out.println("0. 뒤로가기");
				System.out.print("선택 >> ");
				try {
					choice = Integer.parseInt(sc.nextLine());
					switch(choice) {
					case 1:
						mgc.selectManagerAll();
						break;

					case 2:
						mgc.selectManagerName(this.searchManagerName());
						break;

					case 3:
						mgc.selectManagerNo(this.searchManagerNo());
						break;

					case 4:
						mgc.insertManager(this.insertManager());
						break;

					case 5:
						mgc.deleteManager(this.deleteManager());
						break;

					case 6:
						mgs.list.clear();
						break;

					case 0:
						break;

					default:
						System.out.println("잘못된 입력값입니다.");
					}
				}
				catch(Exception e) {
					System.out.println("숫자를 입력해주세요.");
				}
			}
			else {
				while(answer != 0) {
					System.out.println("1. 메니저 로그인");
					System.out.println("0. 뒤로가기");
					System.out.print("선택 >> ");
					try {
						answer = Integer.parseInt(sc.nextLine());
						if(answer == 1) {
							mgs.list = mgc.managerSignIn(this.managerSignIn());
							break;
						}
						else if(answer == 0) {
							break;
						}
						else {
							System.out.println("잘못된 메뉴선택입니다.");
						}
					}
					catch(Exception e) {
						System.out.println("숫자를 입력해주세요.");
					}
				}
			}
			if(answer == 0 || choice == 0 || choice == 6) {
				break;
			}
			else {
				continue;
			}
		}
		this.mainMenu();
	}

	public void selectManagerAll(ArrayList<Manager> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).showString());
		}
	}

	public void selectManagerOne(Manager manager) {
		System.out.println(manager.showString());
	}

	public String searchManagerName() {
		System.out.print("관리자 이름 : ");
		return sc.nextLine();
	}

	public int searchManagerNo() {
		System.out.print("메니저 변호 : ");
		return Integer.parseInt(sc.nextLine());
	}

	public Manager insertManager() {
		Manager manager = new Manager();
		System.out.println("======메니저 등록======");
		System.out.print("이름 : ");
		manager.setManagerName(sc.nextLine());
		System.out.print("아이디 : ");
		manager.setManagerID(sc.nextLine());
		System.out.print("비밀범호 : ");
		manager.setManagerPwd(sc.nextLine());
		System.out.print("생년월일 : ");
		manager.setManagerBirth(sc.nextLine());
		System.out.print("성별 : ");
		manager.setManagerGenger(sc.nextLine());
		System.out.print("주소 : ");
		manager.setManagerAddr(sc.nextLine());

		return manager;
	}

	public Manager deleteManager() {
		Manager manager = new Manager();
		System.out.println("======메니저 삭제======");
		System.out.print("메니저 번호 : ");
		manager.setManagerNo(Integer.parseInt(sc.nextLine()));
		System.out.print("메니저 이름 : ");
		manager.setManagerName(sc.nextLine());
		return manager;
	}

	public void display(String text) {
		System.out.println("====================");
		System.out.println("요청 결과 : " + text);
	}

}
