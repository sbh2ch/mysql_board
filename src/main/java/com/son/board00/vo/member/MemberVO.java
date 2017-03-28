package com.son.board00.vo.member;

/**
 * <pre>
 * com.son.board00.vo.member 
 *    |_ MemberVO.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 1:48:09
 * @version :
 * @author : kiost
 */
public class MemberVO {
	private int m_no;
	private String name;
	private String email;
	private String pw;

	public MemberVO() {
	}

	public MemberVO(String email, String pw) {
		this.email = email;
		this.pw = pw;
	}

	public int getM_no() {
		return m_no;
	}

	public void setM_no(int m_no) {
		this.m_no = m_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

}
