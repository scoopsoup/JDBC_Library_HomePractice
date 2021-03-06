package common;

public class Manual {
	//설명서

	//1. 서비스 이용하기
	//사용자 : 일반회원
	//2. 회원관리
	//사용자 : 메니저
	//3. 대여관리
	//사용자 : 메니저
	//4. 책관리
	//사용자 : 메니저
	//5. 메니저 관리
	//사용자 : 최상위 메니저(MANAGER_NO = 1)
	//0. 종료

	//<1. 서비스 이용하기>
	//1. 회원 로그인
	//로그인 상태에서는 로그아웃을 한 후 이용할 수 있음
	//즉, 한번에 한명만 로그인 가능
	//2. 회원가입
	//3. 내 정보 조회
	//로그인인 상태에서 내 정보를 조회할 수 있음
	//4. 내 대여정보 조회
	//책 대여정보 확익
	//책이름, 대여날짜, 반납날짜, 대여갯수
	//5. 책 조회하기
	//로그인이 아닌 상태에서도 조회할 수 있음
	//5-1. 전체조회
	//5-2. 코드로 조회
	//5-3. 이름으로 조회
	//5-0. 뒤로가기
	//6. 책 대여하기
	//6-1. 책 코드로 검색 후 대어
	//6-2. 책 이름으로 검색 후 대여
	//7. 회원 로그아웃
	//8. 회원 탈퇴
	//0. 돌아가기

	//<2. 회원관리>
	//메니저 로그인 후 사용가능
	//한번에 한명씩만 로그인 할 수 있음

	//로그인 전
	//1. 메니저 로그인
	//0. 뒤로가기

	//로그인 후
	//1. 회원 전체 조회
	//2. 회원 이름으로 조회
	//3. 회훤 번호로 조회
	//4. 로그아웃
	//0. 뒤로가기

	//**회원이 내 정보 조회 했을 시 -> 모든 정보 보여줌
	//**메니저가 회원 정보 조회 했을 시 -> 회원 아이디, 비밀번호 제외하고 보여줌

	//<3. 대여관리>
	//메니저 로그인 후 사용가능
	//한번에 한명씩만 로그인 할 수 있음

	//로그인 전
	//1. 메니저 로그인
	//0. 뒤로가기

	//로그인 후
	//대여번호, 회원이름, 책번호, 대여갯수, 대여일, 반납일
	//1. 전체 대여목록 조회
	//2. 회원코드로 조회
	//3. 책이름으로 조회
	//4. 로그아웃
	//0. 뒤로가기

	//<4. 책관리>
	//메니저 로그인 후 사용가능
	//한번에 한명씩만 로그인 할 수 있음

	//로그인 전
	//1. 메니저 로그인
	//0. 뒤로가기

	//로그인 후
	//책 번호, 책 이름, 저자, 가격, 출판사, 장르
	//1. 책 전체조회
	//2. 책 코드로 조회
	//3. 책 추가하기
	//4. 책 삭제하기
	//5. 로그아웃
	//0. 되돌아가기

	//<5. 메니저 관리>
	//최상위 메니저 로그인 후 사용가능

	//로그인 전
	//1. 메니저 로그인
	//0. 뒤로가기
	
	//로그인 후
	//메니저 아이디, 비밀번호 제외하고 보여줌(조회)
	//1. 메니저 전체 조회
	//2. 메니저 이름으로 조회
	//3. 메니저 번호로 조회
	//4. 메니저 추가
	//5. 메니저 삭제
	//6. 로그아웃
	//0. 뒤로가기
	
}
