package com.green.board.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.dao.PartyDAO;
import com.green.vo.MemberVO;
import com.green.vo.PartyVO;

public class ViewTableAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/viewTable.jsp";

		
		PartyDAO dao1 = PartyDAO.getInstance();
		MemberDAO dao2 = MemberDAO.getInstance();
		
		List <PartyVO> partyList = dao1.selectPartyList();
		List <MemberVO> memberList = dao2.selectMemberList();
		
		request.setAttribute("partyList", partyList);
		request.setAttribute("memberList", memberList);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
