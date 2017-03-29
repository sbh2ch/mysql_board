
package com.son.board00.controller.reply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.son.board00.service.reply.ReplyService;
import com.son.board00.vo.reply.ReplyVO;

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
	 * 		2) 댓글 리스트를 뽑아와서 JSON으로 전달 (전체 리셋)
	 * </pre>
	 * 
	 * @Method Name : addReply
	 * @date : 2017. 3. 28.
	 * @author : kiost
	 * @history : ----------------------------------------------------------------------- 변경일 작성자 변경내용 ----------- ------------------- --------------------------------------- 2017. 3. 28. kiost 최초 작성 -----------------------------------------------------------------------
	 * 
	 * @param res
	 * @param req
	 */
	@RequestMapping("reply_write_ajax.do")
	public void addReply(HttpServletResponse res, HttpServletRequest req, Model model) {
		model.addAttribute("req", req);
		List<ReplyVO> rList = replyService.write(model);
		if (rList == null)
			return;

		try {
			res.getWriter().print(new Gson().toJson(rList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("reply_list_ajax.do")
	public void replyListByBno(HttpServletRequest req, HttpServletResponse res, Model model) {
		model.addAttribute("req", req);
		List<ReplyVO> rList = replyService.allReply(model);

		try {
			res.getWriter().print(new Gson().toJson(rList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
