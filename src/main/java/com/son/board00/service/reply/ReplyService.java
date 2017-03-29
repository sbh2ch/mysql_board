
package com.son.board00.service.reply;

import java.util.List;

import org.springframework.ui.Model;

import com.son.board00.vo.reply.ReplyVO;

/**
 * <pre>
 * com.son.board00.service.reply 
 *    |_ ReplyService.java
 * 
 * </pre>
 * @date : 2017. 3. 28. 오후 6:51:16
 * @version : 
 * @author : kiost
 */
public interface ReplyService {
	public List<ReplyVO> write(Model model);
	public List<ReplyVO> modify(Model model);
	public List<ReplyVO> allReply(Model model);
	public List<ReplyVO> delete(Model model);
}
