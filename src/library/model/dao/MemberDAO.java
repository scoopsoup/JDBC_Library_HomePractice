package library.model.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import common.JDBCTemplate;
import library.model.vo.Member;
import library.model.vo.MemberSignIn;

public class MemberDAO {
	
	Properties prop = new Properties();
	
	public MemberDAO() {
		try {
			prop.load(new FileReader("resources/query.properties"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public int memberSignIn(Connection conn, Member member) {
//		int result = 0;
//		
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		String query = prop.getProperty("memberSignIn");
//		
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, member.getUserID());
//			pstmt.setString(2, member.getUserPwd());
//			rset = pstmt.executeQuery();
//			
//			if(rset.next()) {
//				result = 1;
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return result;
//	}
	
	public ArrayList<MemberSignIn> memberSignIn(Connection conn, MemberSignIn member) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("memberSignIn");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserID());
			pstmt.setString(2, member.getUserPwd());
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member.list.add(member);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return member.list;
	}
	
	
	public int memberSignUp(Connection conn, Member member) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUserName());
			pstmt.setString(2, member.getUserID());
			pstmt.setString(3, member.getUserPwd());
			pstmt.setString(4, member.getUserBirth());
			pstmt.setString(5, member.getUserGender());
			pstmt.setString(6, member.getUserAddr());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
	
	public ArrayList<Member> selectMemberAll(Connection conn){
		ArrayList<Member> list = null;
		
		Statement stmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberAll");
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset != null) {
				list = new ArrayList<Member>();
				while(rset.next()) {
					Member member = new Member();
					member.setUserNo(rset.getInt("USER_NO"));
					member.setUserName(rset.getString("USER_NAME"));
					member.setUserID(rset.getString("USER_ID"));
					member.setUserPwd(rset.getString("USER_PWD"));
					member.setUserBirth(rset.getString("USER_BIRTH"));
					member.setUserGender(rset.getString("USER_GENDER"));
					member.setUserAddr(rset.getString("USER_ADDR"));
					member.setUserEnrollDate(rset.getDate("USER_ENROLL_DATE"));
					list.add(member);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return list;
	}
	
	public ArrayList<Member> selectMemberName(Connection conn, String memberName){
		ArrayList<Member> list = null;
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + memberName + "%");
			rset = pstmt.executeQuery();
			
			if(rset != null) {
				list = new ArrayList<Member>();
				while(rset.next()) {
					Member member = new Member();
					member.setUserNo(rset.getInt("USER_NO"));
					member.setUserName(rset.getString("USER_NAME"));
					member.setUserID(rset.getString("USER_ID"));
					member.setUserPwd(rset.getString("USER_PWD"));
					member.setUserBirth(rset.getString("USER_BIRTH"));
					member.setUserGender(rset.getString("USER_GENDER"));
					member.setUserAddr(rset.getString("USER_ADDR"));
					member.setUserEnrollDate(rset.getDate("USER_ENROLL_DATE"));
					list.add(member);
				}
			}
		}
		catch(Exception e) {
			
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}
	
	public Member selectMemberNo(Connection conn, int memberNo) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberNo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member();
				member.setUserNo(rset.getInt("USER_NO"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserID(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserBirth(rset.getString("USER_BIRTH"));
				member.setUserGender(rset.getString("USER_GENDER"));
				member.setUserAddr(rset.getString("USER_ADDR"));
				member.setUserEnrollDate(rset.getDate("USER_ENROLL_DATE"));
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return member;
	}
	
	public int deleteMember(Connection conn, String memberID, String memberPwd) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		String query = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberID);
			pstmt.setString(2, memberPwd);
			result = pstmt.executeUpdate();
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}
			else {
				JDBCTemplate.rollback(conn);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Member showMyInfo(Connection conn, ArrayList<MemberSignIn> list) {
		Member member = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("showMyInfo");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, list.get(0).getUserID());
			pstmt.setString(2, list.get(0).getUserPwd());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				member = new Member();
				member.setUserNo(rset.getInt("USER_NO"));
				member.setUserName(rset.getString("USER_NAME"));
				member.setUserID(rset.getString("USER_ID"));
				member.setUserPwd(rset.getString("USER_PWD"));
				member.setUserBirth(rset.getString("USER_BIRTH"));
				member.setUserGender(rset.getString("USER_GENDER"));
				member.setUserAddr(rset.getString("USER_ADDR"));
				member.setUserEnrollDate(rset.getDate("USER_ENROLL_DATE"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return member;
	}

}
