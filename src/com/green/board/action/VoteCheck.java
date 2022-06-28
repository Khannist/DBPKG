package com.green.board.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.dao.VoteDAO;
import com.green.vo.VoteVO;

public class VoteCheck implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/page/voteCheck.jsp";
		List<VoteVO> list = new ArrayList<>();
		VoteDAO dao = VoteDAO.getInstance();
		
		list = dao.SelectVoteCheck();
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println("JAVA.V_NAME = " + list.get(i).getV_Name());
		}
		
		
		
		request.setAttribute("List", list);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
