
package com.son.board00.dao.reply;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.son.board00.vo.reply.ReplyVO;

/**
 * <pre>
 * com.son.board00.dao.reply 
 *    |_ ReplyDAOImpl.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 29. 오전 10:04:45
 * @version :
 * @author : kiost
 */
@Repository
public class ReplyDAOImpl implements ReplyDAO {
	@Autowired
	private SqlSession session;

	@Override
	public void insert(String b_no, String content, String email) {
		session.insert("com.son.board00.replyMapper.insert", new ReplyVO(Integer.parseInt(b_no), content, email));
	}

	@Override
	public void update(String r_no, String content) {
		System.out.println("update dao > " + content);
		session.update("com.son.board00.replyMapper.update", new ReplyVO(Integer.parseInt(r_no), content));
	}

	@Override
	public void delete(String r_no) {
	}

	@Override
	public ReplyVO selectOne(String r_no) {
		return null;
	}

	@Override
	public List<ReplyVO> selectAllbyBno(String b_no) {
		return session.selectList("com.son.board00.replyMapper.selectAllbyBno", b_no);
	}

	@Override
	public String selectEmailByRno(String r_no) {
		return session.selectOne("com.son.board00.replyMapper.selectEmailbyRno", r_no);
	}

}
