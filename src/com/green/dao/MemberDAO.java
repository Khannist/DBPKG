package com.green.dao;



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
} 
