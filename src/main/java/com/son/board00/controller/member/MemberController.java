
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

	@RequestMapping("/login.do")
	public String login(HttpServletRequest req, Model model) {
		model.addAttribute("req", req);
		memberService.login(model);

		return "redirect:./list.do";
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req, Model model) {
		model.addAttribute("session", req.getSession());
		memberService.logout(model);

		return "redirect:./list.do";
	}
}
