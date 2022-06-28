package com.green.board;

import com.green.board.action.Action;
import com.green.board.action.VoteCheck;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if(command.equals("")) {
			
		}else if(command.equals("voteCheck")) {
			action = new VoteCheck();
		}
		return action;
	}
}
