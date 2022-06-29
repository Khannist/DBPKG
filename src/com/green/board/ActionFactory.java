package com.green.board;

import com.green.board.action.Action;
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
		
		if(command.equals("vote_write_form")) {
			action = new VoteWriteFormAction();
		}
		else if(command.equals("vote_write")) {
			action = new VoteWriteAction();
		}
		
		return action;
	}
}
