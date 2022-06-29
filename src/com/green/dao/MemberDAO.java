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
	public List<MemberVO> selectInfoGrade() {
		List<MemberVO> list = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT m.M_NO AS mNO, M_NAME, " + 
				"   COUNT(CASE " + 
				"        WHEN v.M_NO = '1' THEN v.M_NO " + 
				"        WHEN v.M_NO = '2' THEN v.M_NO " + 
				"        WHEN v.M_NO = '3' THEN v.M_NO " + 
				"        WHEN v.M_NO = '4' THEN v.M_NO " + 
				"        WHEN v.M_NO = '5' THEN v.M_NO " + 
				"   END) AS vNO " + 
				" FROM TBL_VOTE_202005 v, TBL_MEMBER_202005 m WHERE m.m_no = v.m_no " + 
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
