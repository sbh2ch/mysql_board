
package com.son.board00.vo.reply;

import java.util.Date;

/**
 * <pre>
 * com.son.board00.vo.reply 
 *    |_ ReplyVO.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 5:58:21
 * @version :
 * @author : kiost
 */
public class ReplyVO {
	private int r_no;
	private int b_no;
	private String name;
	private String content;
	private String email;
	private Date reg_date;

	public ReplyVO() {
	}

	public ReplyVO(int b_no, String content, String email) {
		this.b_no = b_no;
		this.content = content;
		this.email = email;
	}

	public ReplyVO(int r_no, String content) {
		super();
		this.r_no = r_no;
		this.content = content;
	}

	public int getR_no() {
		return r_no;
	}

	public void setR_no(int r_no) {
		this.r_no = r_no;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

}
