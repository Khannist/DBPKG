package com.green.dao;

public class VoteDAO {
	private VoteDAO() {}
	private static VoteDAO dao = new VoteDAO();
	public static VoteDAO getInstance() {
		return dao;
	}
}
