
package com.son.board00.dao.member; 

import com.son.board00.vo.member.MemberVO;

/**
 * <pre>
 * com.son.board00.dao.member 
 *    |_ MemberDAO.java
 * 
 * </pre>
 * @date : 2017. 3. 28. 오후 1:51:22
 * @version : 
 * @author : kiost
 */
public interface MemberDAO {
	public MemberVO selectOne(String email, String pw);
}
