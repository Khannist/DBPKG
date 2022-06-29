package com.green.board.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.VoteDAO;
import com.green.vo.VoteVO;

public class VoteWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VoteVO vVo = new VoteVO();
		
		//voteWrite.jsp의 폼으로 부터 request받은 것 저장
	
		vVo.setV_Jumin(request.getParameter("v_Jumin"));
		vVo.setV_Name(request.getParameter("v_Name"));
		vVo.setM_No(request.getParameter("m_No"));
		vVo.setV_Time(request.getParameter("v_Time"));
		vVo.setV_Area(request.getParameter("v_Area"));
		vVo.setV_Confirm(request.getParameter("v_Confirm"));
		
		VoteDAO dao = VoteDAO.getInstance();
		dao.insertVote(vVo);
		
		// 전송 후 목록으로 돌아가기
		response.sendRedirect("index.jsp");
		
	}

}