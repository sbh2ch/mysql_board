package com.son.board00.vo.board;

import java.util.Date;

/**
 * <pre>
 * com.son.board00.vo.board 
 *    |_ BoardVO.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 1:47:51
 * @version :
 * @author : kiost
 */
public class BoardVO {
	private int b_no;
	private String name;
	private String email;
	private String title;
	private String content;
	private Date reg_date;
	private int reply_cnt;

	public BoardVO() {
	}

	public BoardVO(String name, String email, String title, String content) {
		this.name = name;
		this.email = email;
		this.title = title;
		this.content = content;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getReply_cnt() {
		return reply_cnt;
	}

	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}

}