
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
	public void write(Model model);
	public void modify(Model model);
	public String allReply(Model model);
	public void delete(Model model);
}
