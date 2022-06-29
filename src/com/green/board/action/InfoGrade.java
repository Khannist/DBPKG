package com.green.board.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.MemberDAO;
import com.green.vo.MemberVO;

public class InfoGrade implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/page/infoGrade.jsp";
		List<MemberVO> list = new ArrayList<>();
		MemberDAO dao = MemberDAO.getInstance();
		
		list = dao.selectInfoGrade();
		
		request.setAttribute("list", list);
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
