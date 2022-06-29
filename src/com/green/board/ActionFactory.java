package com.green.board;

import com.green.board.action.Action;
import com.green.board.action.InfoGrade;
import com.green.board.action.ViewTableAction;
import com.green.board.action.VoteCheck;
import com.green.board.action.VoteWriteAction;
import com.green.board.action.VoteWriteFormAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("viewTable")) { // 후보 조회 command
			action = new ViewTableAction();
		}else if(command.equals("voteCheck")) {
			action = new VoteCheck();
		}else if(command.equals("vote_write_form")) {
			action = new VoteWriteFormAction();
		}else if(command.equals("vote_write")) {
			action = new VoteWriteAction();
		}else if(command.equals("infoGrade")) {
			action = new InfoGrade();
		}
		return action;
	}
}
