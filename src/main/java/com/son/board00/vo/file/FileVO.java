
package com.son.board00.vo.file;

import java.util.Date;

/**
 * <pre>
 * com.son.board00.vo.file 
 *    |_ FileVO.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 29. 오후 9:16:21
 * @version :
 * @author : kiost
 */
public class FileVO {
	private int f_no;
	private int b_no;
	private String ori_name;
	private String real_name;
	private String file_path;
	private Date reg_date;
	private int file_size;

	public FileVO() {
	}

	public int getF_no() {
		return f_no;
	}

	public void setF_no(int f_no) {
		this.f_no = f_no;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getOri_name() {
		return ori_name;
	}

	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}

	public String getReal_name() {
		return real_name;
	}

	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

}
