
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
	public void write(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		String b_no = req.getParameter("b_no");
		String email = req.getParameter("email");
		String content = req.getParameter("content").replaceAll("'", "\""); /* Injection 방지 */

		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		if (user != null && email.equals(user.getEmail()))
			replyDao.insert(b_no, content, email);
	}

	@Override
	public void modify(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		String r_no = req.getParameter("r_no");
		String email = req.getParameter("email");
		String content = req.getParameter("content").replaceAll("'", "\""); /* Injection 방지 */

		System.out.println("update svc > " + content);
		if (user != null && user.getEmail().equals(email) && email.equals(replyDao.selectEmailByRno(r_no)))
			replyDao.update(r_no, content);
	}

	@Override
	public String allReply(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		MemberVO user = (MemberVO) req.getSession().getAttribute("user");

		return makeReplyHtml(replyDao.selectAllbyBno(req.getParameter("b_no")), user != null ? user.getEmail() : "");
	}

	@Override
	public void delete(Model model) {
	}

	public String makeReplyHtml(List<ReplyVO> list, String userEmail) {
		String html = "";
		for (int i = 0; i < list.size(); i++) {
			html += "<tr>";
			html += "<td>";
			html += list.get(i).getName();
			html += "</td>";
			html += "<td>";
			html += list.get(i).getContent();
			html += "<div class='replyModCls' id='replyModInput" + list.get(i).getR_no() + "' style='display: none;'><input type='text'><button>mod</button></div>";
			html += "</td>";
			html += "<td>";
			html += list.get(i).getReg_date();
			html += "</td>";
			html += "<td>";
			if (list.get(i).getEmail().equals(userEmail)) {
				html += "<button type='button' class='replyModBtn' value='" + list.get(i).getR_no() + "'>mod</button>";
				html += "<a href='list.do'>del</a>";
			}
			html += "</td>";
			html += "</tr>";
		}

		return html;
	}
}
