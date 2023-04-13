package com.memo.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.memo.common.EncryptUtils;
import com.memo.user.bo.UserBO;
import com.memo.user.model.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/user")
@RestController
public class UserRestController {
	@Autowired
	private UserBO userBO;
	
	
	
	@RequestMapping("/is_duplicated_id")
	public Map<String, Object> isDuplicatedId(
			@RequestParam("loginId") String loginId){
		Map<String, Object> result = new HashMap<>();
		// select
		User user = userBO.getUserByloginId(loginId);
		
		if(user != null) {
			result.put("code", 1);
			result.put("result", true);
		}else {
			result.put("code", 1);
			result.put("result", false);
		}
		
		return result;
	}
	
	/*
	 * *
	 */
	@PostMapping("/sign_up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("email") String email){
		
		// 비밀번호 해싱 - md5
		// 예) aaaa => asfsdfbdfbgdbdfg
		String hashedPassword = EncryptUtils.md5(password);
		
		int countRow = userBO.getUserId(loginId, hashedPassword, name, email);
		
		// db insert
		Map<String, Object> result = new HashMap<>();
		if(countRow > 0) {
			result.put("code", 1);
			result.put("result", "성공");
		} else {
			result.put("code", 500);
			result.put("result", "실패");
		}
		return result;
	}
	
	@PostMapping("/sign_in")
	public Map<String, Object> signIn(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request){
		
		// password hashing
		String hashedPassword = EncryptUtils.md5(password);
		
		// select null or 1행
		User user = userBO.getUserByLoginIdPassword(loginId, hashedPassword);
		
		// 로그인 처리
		Map<String, Object> result = new HashMap<>();
		if(user != null) {
			result.put("code", 1);
			result.put("result", "성공");
			
			// 세션에 유저 정보 담기(로그인 상태 유지)
			HttpSession session = request.getSession();
			session.setAttribute("userId", user.getId());
			session.setAttribute("userName", user.getName());
			session.setAttribute("userLoginId", user.getLoginId());
		} else {
			result.put("code", 500);
			result.put("errorMessage", "존재하지 않는 사용자입니다.");
		}
		
		return result;
	}
}
