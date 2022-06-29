package com.green.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.dao.VoteDAO;
import com.green.vo.MemberVO;
import com.green.vo.VoteVO;

public class VoteWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/voteWrite.jsp";

		MemberDAO Mdao = MemberDAO.getInstance();
		
		//List<후보자VO> 후보자 리스트 = 후보자dao.모든 후보자조회()
		List<MemberVO> member_List = Mdao.selectAllMember();
		
		for(int i=0; i<member_List.size(); i++ )
			member_List.get(i).getM_Name();
		
		//request.setAttribute("후보자리스트",후보자 리스트);
		request.setAttribute("member_List", member_List);
		request.getRequestDispatcher(url).forward(request, response);
	}

}