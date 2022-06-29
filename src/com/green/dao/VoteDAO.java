package com.green.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import com.green.db.DBManager;
import com.green.vo.VoteVO;

public class VoteDAO {
	private VoteDAO() {}
	private static VoteDAO dao = new VoteDAO();
	public static VoteDAO getInstance() {
		return dao;
	}
	///////////////////////////////////////////////////////////////////
	public List<VoteVO> SelectVoteCheck() { // 투표검수조회 페이지 메소드
		List<VoteVO> list = new ArrayList<>();
		VoteVO vVo = null;
		
		SimpleDateFormat newJuminFormat = new SimpleDateFormat("YYYY년MM월dd일생"); // 주민번호를 받을 데이터
		SimpleDateFormat dtFormat = new SimpleDateFormat("YYMMdd");
		SimpleDateFormat newTimeFormat = new SimpleDateFormat("HH:mm");  // 투표시간을 받을 데이터
		SimpleDateFormat timeFormat = new SimpleDateFormat("hmm");  // 투표시간을 받을 데이터
		
		
		
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT V_NAME, V_JUMIN, M_NO, V_TIME, V_CONFIRM FROM TBL_VOTE_202005 " + 
				" WHERE V_AREA = '제1투표장'";
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				vVo = new VoteVO();
				/* 쿼리문 값 받아오기 */
				String V_Name = rs.getString("V_NAME");
				String V_Jumin = rs.getNString("V_JUMIN");
				String M_No = rs.getString("M_NO");
				String V_Time = rs.getString("V_TIME");
				String V_Confirm = rs.getString("V_CONFIRM");
				
				/* 쿼리문값의 내용으로 출력할 데이터 초기화 */
				int BackJumin = Integer.parseInt(V_Jumin.substring(6, 7));
				String gender = "";
				
				if(BackJumin/2 == 0) //성별 초기화
					gender = "남";
				else
					gender = "여";
				
				if(V_Confirm.equals("Y")) // 유권자 확인 초기화
					V_Confirm = "확인";
				else
					V_Confirm = "미확인";

				// Time 형식 맞추기 위한 조건문
				String time = "";
				System.out.println("V_Time = " + V_Time);
				System.out.println("V_Time.trim().lenght() = " + V_Time.trim().length());
				if(V_Time.trim().length() == 3) { // [trim() 공백 제거 함수]V_Time의 길이가 3이라면 실행되는 조건문 
					time = "0" + V_Time.substring(0,1) + ":" + V_Time.substring(1);
				}else {
					time = V_Time.substring(0,2) + ":" + V_Time.substring(2);
				}
				
				// String 타입을 Date 타입으로 변환
				Date formatJumin =  dtFormat.parse(V_Jumin);
				String jumin = newJuminFormat.format(formatJumin);

				String juminTmp = jumin.substring(0, 4);
				int ageTmp = (2022 - Integer.parseInt(juminTmp)) - 1;
				String age = "만 " + ageTmp+"세";
				
				System.out.println("DAO.V_NAME = " + V_Name);
				/* VO에 초기화 */
				vVo.setV_Name(V_Name);
				vVo.setV_Jumin(jumin);
				vVo.setAge(age);
				vVo.setGender(gender);
				vVo.setM_No(M_No);
				vVo.setV_Time(time);
				vVo.setV_Confirm(V_Confirm);
				
				/* list에 VO객체 삽입 */
				list.add(vVo);
				
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
}
