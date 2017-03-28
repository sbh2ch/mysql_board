
package com.son.board00.service.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.son.board00.dao.board.BoardDAO;
import com.son.board00.vo.board.BoardVO;
import com.son.board00.vo.member.MemberVO;

/**
 * <pre>
 * com.son.board00.service.board 
 *    |_ BoardServiceImpl.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 1:58:41
 * @version :
 * @author : kiost
 */
@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;

	@Override
	public List<BoardVO> selectAll() {
		return boardDao.list();
	}

	@Override
	public BoardVO selectOne(String b_no) {
		return boardDao.view(b_no);
	}

	@Override
	public void delete(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		String b_no = req.getParameter("b_no");
		
		/* 작성자와 세션 일치하는지 검사 */
		if (!user.getEmail().equals(boardDao.view(b_no).getEmail()))
			return;
		
		boardDao.delete(b_no);
	}

	@Override
	public void update(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		String b_no = req.getParameter("b_no");
		String title = req.getParameter("title").replaceAll("'", "\"");
		String content = req.getParameter("content").replaceAll("'", "\"");
		
		/* 작성자와 세션 일치하는지 검사 */
		if (!user.getEmail().equals(boardDao.view(b_no).getEmail()))
			return;
		
		boardDao.updateBoard(b_no, title, content);
	}

	@Override
	public void write(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		boardDao.writeBoard(user.getName(), user.getEmail(), req.getParameter("title").replaceAll("'", "\""), req.getParameter("content").replaceAll("'", "\""));
	}
}
