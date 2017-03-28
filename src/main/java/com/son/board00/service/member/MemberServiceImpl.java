
package com.son.board00.service.member; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.son.board00.dao.member.MemberDAO;

/**
 * <pre>
 * com.son.board00.service.member 
 *    |_ MemberServiceImpl.java
 * 
 * </pre>
 * @date : 2017. 3. 28. 오후 3:25:12
 * @version : 
 * @author : kiost
 */
@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDao;
	
	@Override
	public void login(Model model) {
		
	}

	@Override
	public void logout(Model model) {
	}

}
