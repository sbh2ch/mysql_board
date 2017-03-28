
package com.son.board00.service.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.son.board00.dao.member.MemberDAO;
import com.son.board00.vo.member.MemberVO;

/**
 * <pre>
 * com.son.board00.service.member 
 *    |_ MemberServiceImpl.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 3:25:12
 * @version :
 * @author : kiost
 */
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDao;

	@Override
	public void login(Model model) {
		HttpServletRequest req = (HttpServletRequest) model.asMap().get("req");
		String email = req.getParameter("email").replaceAll("'", "\"");
		String pw = req.getParameter("password").replaceAll("'", "\"");
		System.out.println("email : "+ email);
		System.out.println("pword : "+ pw);
		
		MemberVO user = memberDao.selectOne(req.getParameter("email").replaceAll("'", "\""), req.getParameter("password").replaceAll("'", "\""));
		
		if(user != null)
			req.getSession().setAttribute("user", user);
	}

	@Override
	public void logout(Model model) {
		HttpSession session = (HttpSession) model.asMap().get("session");
		session.invalidate();
	}
}
