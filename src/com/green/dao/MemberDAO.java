package com.green.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.MemberVO;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
	
	//////////////////////////////////////////////////////////////////////////
	/* 후보 조회2/2 - 후보자 테이블을 통해 memberList 생성 */
	public List<MemberVO> selectMemberList(){
	String sql = "SELECT * FROM TBL_MEMBER_202005";
	
	List<MemberVO> memberList = new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
	conn = DBManager.getConnection();
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
	while(rs.next()) {
	MemberVO mVo = new MemberVO();
	
	mVo.setM_No(rs.getString("m_No"));
	mVo.setM_Name(rs.getString("m_Name"));
	mVo.setP_School(rs.getString("p_School"));
	mVo.setM_Jumin(rs.getString("m_Jumin"));
	mVo.setM_City(rs.getString("m_City"));
	
	memberList.add(mVo);
	
	}
	
	}catch(Exception e) {
	e.printStackTrace();
	}finally {
	DBManager.close(conn, stmt, rs);
	}
	
	return memberList;
	
	}
	
public List<MemberVO> selectAllMember() {
		
		List<MemberVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT m_NO, m_NAME, m.P_CODE, P_SCHOOL, M_JUMIN, M_CITY "
				+ " FROM TBL_MEMBER_202005 m, TBL_PARTY_202005 p "
				+ " WHERE m.P_CODE = p.P_CODE ORDER BY M_NAME ASC ";
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVO mVo = new MemberVO();
				
				mVo.setM_No(rs.getString("m_No"));
				mVo.setM_Name(rs.getString("m_Name"));
				mVo.setP_Code(rs.getString("p_Code"));
				mVo.setP_School(rs.getString("p_School"));
				mVo.setM_Jumin(rs.getString("m_Jumin"));
				mVo.setM_City(rs.getString("m_City"));
				
				list.add(mVo);
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

public List<MemberVO> selectInfoGrade() {
	List<MemberVO> list = new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	String sql = "SELECT m.M_NO AS mNO, M_NAME,  " + 
			"   COUNT(CASE  " + 
			"        WHEN v.M_NO = '1' THEN v.M_NO  " + 
			"        WHEN v.M_NO = '2' THEN v.M_NO " + 
			"        WHEN v.M_NO = '3' THEN v.M_NO " + 
			"        WHEN v.M_NO = '4' THEN v.M_NO " + 
			"        WHEN v.M_NO = '5' THEN v.M_NO " + 
			"   END) AS vNO " + 
			" FROM TBL_VOTE_202005 v, TBL_MEMBER_202005 m  " + 
			" WHERE m.m_no = v.m_no " + 
			" GROUP BY m.M_NO, M_NAME, V_CONFIRM " + 
			" HAVING V_CONFIRM = 'Y' " + 
			" ORDER BY vNO DESC ";
	
	try {
		conn = DBManager.getConnection();
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			MemberVO mVo = new MemberVO();
			mVo.setM_No(rs.getString("mNO"));
			mVo.setM_Name(rs.getString("M_NAME"));
			mVo.setvNo(rs.getString("vNO"));
			
			list.add(mVo);
			
		}
	} catch (Exception e) {
		 e.printStackTrace();
	}finally {
		DBManager.close(conn, stmt, rs);
	}
	
	
	return list;
}






















} 