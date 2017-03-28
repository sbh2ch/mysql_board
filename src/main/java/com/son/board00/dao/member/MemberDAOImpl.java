
package com.son.board00.dao.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.son.board00.vo.member.MemberVO;

/**
 * <pre>
 * com.son.board00.dao.member 
 *    |_ MemberDAOImpl.java
 * 
 * </pre>
 * 
 * @date : 2017. 3. 28. 오후 3:41:29
 * @version :
 * @author : kiost
 */
@Repository
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	private SqlSession session;

	@Override
	public MemberVO selectOne(String email, String pw) {
		return session.selectOne("com.son.board00.memberMapper.selectOne", new MemberVO(email, pw));
	}
}
