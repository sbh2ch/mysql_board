
package com.son.board00.service.member;

import org.springframework.ui.Model;

/**
 * <pre>
 * com.son.board00.service.member 
 *    |_ MemberService.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 1:53:37
 * @version :
 * @author : kiost
 */
public interface MemberService {
	public void login(Model model);

	public void logout(Model model);
}
