
package com.son.board00.controller.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.son.board00.service.member.MemberService;

/**
 * <pre>
 * com.son.board00.controller.member 
 *    |_ MemberController.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 1:52:10
 * @version :
 * @author : kiost
 */
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;

	/**
	 * <pre>
	 * 1. 개요 : 로그인
	 * 2. 처리내용 : 
	 * 		1) ID, PW 받음
	 * 		2) SQL Injection 방지
	 * 		3) ID, PW 가 맞는 아이디 존재 시 세션에 추가
	 * </pre>
	 * @Method Name : login
	 * @date : 2017. 3. 28.
	 * @author : kiost
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 3. 28.		kiost				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param req
	 * @param model
	 * @return
	 */ 	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest req, Model model) {
		model.addAttribute("req", req);
		memberService.login(model);

		return "redirect:./list.do";
	}

	/**
	 * <pre>
	 * 1. 개요 : 로그아웃
	 * 2. 처리내용 : 세션 invalidate
	 * </pre>
	 * @Method Name : logout
	 * @date : 2017. 3. 28.
	 * @author : kiost
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 3. 28.		kiost				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param req
	 * @param model
	 * @return
	 */ 	
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req, Model model) {
		model.addAttribute("session", req.getSession());
		memberService.logout(model);

		return "redirect:./list.do";
	}
}
