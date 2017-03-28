
package com.son.board00.service.board;

import java.util.List;

import org.springframework.ui.Model;

import com.son.board00.vo.board.BoardVO;

/**
 * <pre>
 * com.son.board00.service.board 
 *    |_ BoardService.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 1:53:28
 * @version :
 * @author : kiost
 */
public interface BoardService {
	public List<BoardVO> selectAll();

	public BoardVO selectOne(String b_no);

	public void delete(String b_no);

	public void update(Model model);

	public void write(Model model);

}
