package com.green.vo;

import java.sql.Timestamp;

public class PartyVO {
	private String P_Code;
	private String P_Name;
	private Timestamp P_Indate;
	private String p_Tel1;
	private String p_Tel2;
	private String p_Tel3;
	public String getP_Code() {
		return P_Code;
	}
	public void setP_Code(String p_Code) {
		P_Code = p_Code;
	}
	public String getP_Name() {
		return P_Name;
	}
	public void setP_Name(String p_Name) {
		P_Name = p_Name;
	}
	public Timestamp getP_Indate() {
		return P_Indate;
	}
	public void setP_Indate(Timestamp p_Indate) {
		P_Indate = p_Indate;
	}
	public String getP_Tel1() {
		return p_Tel1;
	}
	public void setP_Tel1(String p_Tel1) {
		this.p_Tel1 = p_Tel1;
	}
	public String getP_Tel2() {
		return p_Tel2;
	}
	public void setP_Tel2(String p_Tel2) {
		this.p_Tel2 = p_Tel2;
	}
	public String getP_Tel3() {
		return p_Tel3;
	}
	public void setP_Tel3(String p_Tel3) {
		this.p_Tel3 = p_Tel3;
	}
	
}
