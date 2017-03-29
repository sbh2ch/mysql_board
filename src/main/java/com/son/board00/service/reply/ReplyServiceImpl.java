
package com.son.board00.service.reply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.son.board00.dao.reply.ReplyDAO;
import com.son.board00.vo.member.MemberVO;
import com.son.board00.vo.reply.ReplyVO;

/**
 * <pre>
 * com.son.board00.service.reply 
 *    |_ ReplyServiceImpl.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 29. 오전 9:59:25
 * @version :
 * @author : kiost
 */
@Service
public class ReplyServiceImpl implements ReplyService {
	@Autowired
	ReplyDAO replyDao;

	@Override
	public List<ReplyVO> write(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		String b_no = req.getParameter("b_no");
		String email = req.getParameter("email");
		String content = req.getParameter("content").replaceAll("'", "\""); /* Injection 방지 */

		MemberVO user = (MemberVO) req.getSession().getAttribute("user");
		
		if (email.equals(user.getEmail()))
			replyDao.insert(b_no, content, email);

		return replyDao.selectAllbyBno(b_no);
	}

	@Override
	public List<ReplyVO> modify(Model model) {
		return null;
	}

	@Override
	public List<ReplyVO> allReply(Model model) {
		HttpServletRequest req = (HttpServletRequest)model.asMap().get("req");
		
		return replyDao.selectAllbyBno(req.getParameter("b_no"));
	}

	@Override
	public List<ReplyVO> delete(Model model) {
		return null;
	}
}
