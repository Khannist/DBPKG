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
}
