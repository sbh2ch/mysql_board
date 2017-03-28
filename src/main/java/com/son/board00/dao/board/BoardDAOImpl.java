
package com.son.board00.dao.board;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.son.board00.vo.board.BoardVO;
import com.son.board00.vo.member.MemberVO;

/**
 * <pre>
 * com.son.board00.dao.board 
 *    |_ BoardDAOImpl.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 2:17:16
 * @version :
 * @author : kiost
 */
@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;

	@Override
	public List<BoardVO> list() {
		System.out.println("list");

		return session.selectList("com.son.board00.boardMapper.list");
	}

	@Override
	public BoardVO view(String b_no) {
		System.out.println("detail : " + b_no);
		return session.selectOne("com.son.board00.boardMapper.view", b_no);
	}

	@Override
	public void writeBoard(String name, String email, String title, String content) {
		session.insert("com.son.board00.boardMapper.writeBoard", new BoardVO(name, email, title, content));
		session.commit();
	}

	@Override
	public MemberVO login(String email, String password) {
		return null;
	}

	@Override
	public void delete(String b_no) {
	}

}
