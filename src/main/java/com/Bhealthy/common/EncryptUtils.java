package com.Bhealthy.common;

import java.security.MessageDigest;

public class EncryptUtils {

	// input: 원본 비밀번호 
	// output: 해싱된 비밀번호
	
	public static String sha256(String message) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(message.getBytes());
			byte byteData[] = md.digest();
			
			StringBuffer sb = new StringBuffer();
			
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			
			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				String hex = Integer.toHexString(0xff & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}
			return hexString.toString();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

}
