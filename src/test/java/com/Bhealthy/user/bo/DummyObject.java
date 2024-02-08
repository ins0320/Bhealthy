package com.Bhealthy.user.bo;
import com.Bhealthy.common.EncryptUtils;
import com.Bhealthy.user.domain.User;

public class DummyObject {

	EncryptUtils passwordUtils = new EncryptUtils();
	
	// 가짜 stub -> when.thenReturn 구조에서 사용
	 protected User MockUser(String loginId, String password){
	        //String hashedPassword = EncryptUtils.sha256("bbbb");
	        User user = new User();
	        user.setPassword("aaaa");
	        user.setLoginId("aaaa");
	        user.setName("aaaa");
	        user.setEmail("aaaa@naver.com");

	        
	        return user;
	    }
	 // insert 용
	 protected User newMockUser(String loginId, String password){
	        String hashedPassword = EncryptUtils.sha256("bbbb");
	        User user = new User();
	        user.setPassword(hashedPassword);
	        user.setLoginId("bbbb");
	        user.setName("bbbb");
	        user.setEmail("bbbb@");
	        
	        return user;
	    }

}
