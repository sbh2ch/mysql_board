
package com.son.board00.dao.reply;

import java.util.List;

import com.son.board00.vo.reply.ReplyVO;

/**
 * <pre>
 * com.son.board00.dao.reply 
 *    |_ ReplyDAO.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 6:51:33
 * @version :
 * @author : kiost
 */
public interface ReplyDAO {
	public void insert(String b_no, String content, String email);

	public void update(String r_no, String content);

	public void delete(String r_no);

	public ReplyVO selectOne(String r_no);

	public List<ReplyVO> selectAllbyBno(String b_no);
	
	public String selectEmailByRno(String r_no);
}
