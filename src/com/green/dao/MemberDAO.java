package com.green.dao;



public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	public static MemberDAO getInstance() {
		return dao;
	}
}
