package com.green.dao;

public class PartyDAO {
	private PartyDAO() {}
	private static PartyDAO dao = new PartyDAO();
	public static PartyDAO getInstance() {
		return dao;
	}
	
	//////////////////////////////////////////////////////////////////////////
	/* 후보 조회1/2 - 정당 테이블을 통해 partyList 생성 */
	public List<PartyVO> selectPartyList(){
		String sql = "SELECT * FROM TBL_PARTY_202005";
		List<PartyVO> partyList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PartyVO pVo = new PartyVO();
				
				pVo.setP_Name(rs.getString("p_name"));
				pVo.setP_Tel1(rs.getString("p_Tel1"));
				pVo.setP_Tel2(rs.getString("p_Tel2"));
				pVo.setP_Tel3(rs.getString("p_Tel3"));
				
				partyList.add(pVo);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return partyList;
		
	}
}
