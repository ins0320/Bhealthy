package com.Bhealthy.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Bhealthy.common.EncryptUtils;
import com.Bhealthy.user.bo.UserBO;
import com.Bhealthy.user.domain.User;

@RequestMapping("/user")
@RestController
public class UserRestController {

	@Autowired
	private UserBO userBO;
		
	/**
	 * 
	  * @ API Name  : 아이디 중복확인 API
	  * @param loginId
	  * @return
	 */
	@RequestMapping("/is-duplicated-id")
	public Map<String, Object> duplicateId(@RequestParam("loginId") String loginId){
		
		
		// DB 조회
		User user = userBO.getUserByLonginId(loginId);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		if (user != null) { // 중복
			result.put("code", 200);
			result.put("is_duplicated_id", true);
		} else { // 중복 아님
			result.put("code", 200);
			result.put("is_duplicated_id", false);
		}
		return result;
	}
	
	@RequestMapping("/sign-up")
	public Map<String, Object> signUp(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email
			){
		
		// sha 256 알고리즘 => password hashing
		String hashedPassword = EncryptUtils.sha256(password);	
		
		// DB 조회
		 userBO.addUser(loginId, hashedPassword, name, email);
		 
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "success");
		
		return result;
	}
	
}
