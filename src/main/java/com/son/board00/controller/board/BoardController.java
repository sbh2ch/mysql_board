
package com.son.board00.controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.son.board00.service.board.BoardService;

/**
 * <pre>
 * com.son.board00.controller.board 
 *    |_ BoardController.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 1:52:02
 * @version :
 * @author : kiost
 */
@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("list.do")
	public String list(Model model) {
		model.addAttribute("bList", boardService.selectAll());

		return "./boardList";	
	}

	@RequestMapping("boardView.do")
	public String view(HttpServletRequest req, Model model) {
		model.addAttribute("b", boardService.selectOne(req.getParameter("b_no")));

		return "./boardView";
	}

	@RequestMapping("boardWriteForm.do")
	public String boardWriteForm() {
		return "./boardWriteForm";
	}

	@RequestMapping("boardWrite.do")
	public String boardWrite(HttpServletRequest req, Model model) {
		model.addAttribute("req", req);
		boardService.write(model);

		return "redirect:./list.do";
	}

	@RequestMapping("boardModifyForm.do")
	public String boardModifyForm(HttpServletRequest req, Model model) {
		model.addAttribute("b", boardService.selectOne(req.getParameter("b_no")));
		return "./boardModifyForm";
	}

	@RequestMapping("boardModify.do")
	public String modify(HttpServletRequest req, Model model) {
		model.addAttribute("req",req);
		boardService.update(model);
		
		return "redirect:./list.do";
	}

	@RequestMapping("boardDelete.do")
	public String delete(HttpServletRequest req, Model model) {
		return "";
	}
}
