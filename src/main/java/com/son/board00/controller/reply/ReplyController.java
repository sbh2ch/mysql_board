
package com.son.board00.controller.reply;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.son.board00.service.reply.ReplyService;

/**
 * <pre>
 * com.son.board00.controller.reply 
 *    |_ ReplyController.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 6:50:49
 * @version :
 * @author : kiost
 */
@Controller
public class ReplyController {
	@Autowired
	private ReplyService replyService;

	/**
	 * <pre>
	 * 1. 개요 : 댓글 추가 AJAX
	 * 2. 처리내용 : 
	 * 		1) 아이디와 댓글내용을 받아서 DB에 추가한다.
	 * </pre>
	 * 
	 * @Method Name : addReply
	 * @date : 2017. 3. 28.
	 * @author : kiost
	 * @param res
	 */
	@RequestMapping("reply_write_ajax.do")
	public void addReply(HttpServletRequest req, HttpServletResponse res, Model model) {
		model.addAttribute("req", req);
		replyService.write(model);
		
		try {
			res.getWriter().print("{}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("reply_list_ajax.do")
	public void replyListByBno(HttpServletRequest req, HttpServletResponse res, Model model) {
		model.addAttribute("req", req);

		try {
			res.getWriter().print(replyService.allReply(model));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("reply_mod_ajax.do")
	public void modReply(HttpServletRequest req, HttpServletResponse res, Model model) {
		System.out.println("update ctr");
		model.addAttribute("req", req);
		replyService.modify(model);
		
		try {
			res.getWriter().print("{}");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
