
package com.son.board00.controller.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.son.board00.service.board.BoardService;
import com.son.board00.service.file.FileService;

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
	
	@Autowired
	private FileService fileService;
	
	/**
	 * <pre>
	 * 1. 개요 : 글 리스트 불러오기
	 * 2. 처리내용 : 
	 * 		1) 전체 글 목록 불러오기
	 * </pre>
	 * @Method Name : list
	 * @date : 2017. 3. 28.
	 * @author : kiost
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 3. 28.		kiost				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @param model
	 * @return
	 */ 	
	@RequestMapping("list.do")
	public String list(Model model) {
		model.addAttribute("bList", boardService.selectAll());

		return "./boardList";	
	}

	/**
	 * <pre>
	 * 1. 개요 : 글 하나 불러오기
	 * 2. 처리내용 : 
	 * 		1) b_no 파라미터 받음
	 * 		2) 해당 번호의 글 불러옴
	 * 		3) view 페이지로 전달
	 * </pre>
	 * @Method Name : view
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
	@RequestMapping("boardView.do")
	public String view(HttpServletRequest req, Model model) {
		model.addAttribute("b", boardService.selectOne(req.getParameter("b_no")));

		return "./boardView";
	}

	/**
	 * <pre>
	 * 1. 개요 : 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : boardWriteForm
	 * @date : 2017. 3. 28.
	 * @author : kiost
	 * @history : 
	 *	-----------------------------------------------------------------------
	 *	변경일				작성자						변경내용  
	 *	----------- ------------------- ---------------------------------------
	 *	2017. 3. 28.		kiost				최초 작성 
	 *	-----------------------------------------------------------------------
	 * 
	 * @return
	 */ 	
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
		model.addAttribute("req", req);
		boardService.delete(model);
		
		return "redirect:./list.do";
	}
}
