package com.green.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.green.db.DBManager;
import com.green.vo.VoteVO;

public class VoteDAO {
	private VoteDAO() {}
	private static VoteDAO dao = new VoteDAO();
	public static VoteDAO getInstance() {
		return dao;
	}
	public List<VoteVO> selectAllVoter() {
		return null;
	}
	
	public void insertVote(VoteVO vVo) {
		String sql = "INSERT INTO TBL_VOTE_202005 VALUES(?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, vVo.getV_Jumin());
			psmt.setString(2, vVo.getV_Name());
			psmt.setString(3, vVo.getM_No());
			psmt.setString(4, vVo.getV_Time());
			psmt.setString(5, vVo.getV_Area());
			psmt.setString(6, vVo.getV_Confirm());
			
			psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, psmt);
		}
	}
}
