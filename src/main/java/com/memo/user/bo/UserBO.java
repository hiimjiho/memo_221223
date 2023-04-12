package com.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.memo.user.dao.UserMapper;
import com.memo.user.model.User;

@Service
public class UserBO {
	@Autowired
	private UserMapper userMapper;
	
	public User getUserByloginId(String loginId) {
		return userMapper.selectUserByloginId(loginId);
	}
}
