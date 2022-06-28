package com.green.dao;

public class PartyDAO {
	private PartyDAO() {}
	private static PartyDAO dao = new PartyDAO();
	public static PartyDAO getInstance() {
		return dao;
	}
}
