package library.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import library.model.dao.MemberDAO;
import library.model.vo.Member;
import library.model.vo.MemberSignIn;

public class MemberService {

	private JDBCTemplate factory;
	MemberSignIn ms;
	
	public MemberService() {
		factory = JDBCTemplate.getConnection();
		ms = new MemberSignIn();
	}
	
//	public int memberSignIn(Member member) throws Exception {
//		Connection conn = JDBCTemplate.createConnection();
//		int result = new MemberDAO().memberSignIn(conn, member);
//		JDBCTemplate.close(conn);
//		return result;
//	}
	
	public ArrayList<MemberSignIn> memberSignIn(MemberSignIn member) throws Exception {
		Connection conn = JDBCTemplate.createConnection();
		ms.list = new MemberDAO().memberSignIn(conn, member);
		JDBCTemplate.close(conn);
		return ms.list;
	}
	
	public int memberSignUp(Member member) throws Exception {
		Connection conn = factory.createConnection();
		int result = new MemberDAO().memberSignUp(conn, member);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<Member> selectMemberAll() throws Exception{
		Connection conn = factory.createConnection();
		ArrayList<Member> list = new MemberDAO().selectMemberAll(conn);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public ArrayList<Member> selectMemberName(String memberName) throws Exception{
		Connection conn = factory.createConnection();
		ArrayList<Member> list = new MemberDAO().selectMemberName(conn, memberName);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public Member selectMemberNo(int memberNo) throws Exception{
		Connection conn = factory.createConnection();
		Member member = new MemberDAO().selectMemberNo(conn, memberNo);
		JDBCTemplate.close(conn);
		return member;
	}
	
	public int deleteMember(String memberID, String memberPwd) throws Exception {
		Connection conn = factory.createConnection();
		int result = new MemberDAO().deleteMember(conn, memberID, memberPwd);
		JDBCTemplate.close(conn);
		return result;
	}
	
	public Member showMyInfo(ArrayList<MemberSignIn> list) throws Exception {
		Connection conn = factory.createConnection();
		Member member = new MemberDAO().showMyInfo(conn, list);
		JDBCTemplate.close(conn);
		return member;
	}

}
