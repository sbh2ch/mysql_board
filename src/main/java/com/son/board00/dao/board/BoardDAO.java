package com.son.board00.dao.board;

import java.util.List;

import com.son.board00.vo.board.BoardVO;
import com.son.board00.vo.member.MemberVO;

/**
 * <pre>
 * com.son.board00.dao.board 
 *    |_ BoardDAO.java
 * 
 * </pre>
 * @date : 2017. 3. 28. 오후 1:49:18
 * @version : 
 * @author : kiost
 */
public interface BoardDAO {
	public List<BoardVO> list();

	public BoardVO view(String b_no);

	public void writeBoard(String name, String email, String title, String content);

	public MemberVO login(String email, String password);

	public void delete(String b_no);
}
