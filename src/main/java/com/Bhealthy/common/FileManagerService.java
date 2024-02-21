package com.Bhealthy.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // spring bean으로 등록
public class FileManagerService {

	// 파일 경로(실제 업로드 된 이미지가 저장될 경로(서버))
	//public static final String FILE_UPLOAD_PATH = "D:\\김유정\\6_springProject\\Bhealthy\\Bhealthy_workspace\\images/";
	public static final String FILE_UPLOAD_PATH = "D:\\megastudy2\\spring_project\\workspace\\images/";
	
	// 파일 생성
	// input:File 원본, userLoginId(폴더명)  output: 이미지 경로
	public String saveFile(String loginId, MultipartFile file) {
	
		// 폴더(디렉토리) 생성
		// 예: aaaa_1823478932/sun.png
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/";
		String filePath = FILE_UPLOAD_PATH + directoryName; //D:\\김유정\\6_springProject\\Bhealthy\\Bhealthy_workspace\\images/aaaa_1823478932/sun.png
		
		// 디렉토리 생성
		File directory = new File(filePath);
		if (directory.mkdir() == false) {
			// 폴더 생성 실패 시 이미지 경로 null 리턴
			return null;
		}
		
		// 파일 업로드: byte 단위로 업로드한다.
		try {
			byte[] bytes = file.getBytes();
			
			//파일명 암호화
			String origName = new String(file.getOriginalFilename().getBytes("8859_1"),"UTF-8");
			String ext = origName.substring(origName.lastIndexOf(".")); // 확장자
			String saveFileName = getUuid() + ext;

			Path path = Paths.get(filePath  + saveFileName);
			Files.write(path, bytes); // 실제 파일 업로드
			
			return "/images/" + directoryName + saveFileName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
//		// 파일업로드가 성공했으면 웹 이미지 url path를 리턴
//		// 주소는 이렇게 될 것이다.(예언)
//		// /images/aaaa_1823478932/sun.png
//		return "/images/" + directoryName + "/" + file.getOriginalFilename();
	}
	 // uuid 생성
		public static String getUuid() {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}
		
		
		// 파일 삭제
		// input: imagePath
		// output: void
		public void deleteFile(String imagePath) { // imagePath: /images/aaaa_1823478932/sun.png
			// FILE_UPLOAD_PATH: "D:\\김유정\\6_springProject\\Bhealthy\\Bhealthy_workspace\\images/";
			// directoryName:  /images/aaaa_1823478932/sun.png
			// 주소에 겹치는 /images/ 를 제거한다.	
			Path path = Paths.get(FILE_UPLOAD_PATH + imagePath.replace("/images/", ""));	
		
			// 이미지 삭제
			if (Files.exists(path)) { // 이미지가 존재하는가?
				try {
					Files.delete(path); // 이미지 삭제
				} catch (IOException e) {
					log.info("#####[FileManagerService 이미지 삭제 실패] imagePath:{}", imagePath);
				} 
			}
			
			// 디렉토리(폴더) 삭제
			path = path.getParent();	// path의 부모
			if (Files.exists(path)) {
				try {
					Files.delete(path);
				} catch (IOException e) {
					log.info("###[FileManagerService 이미지 폴더 삭제 실패] imagePath:{}", imagePath);
				}
			}
		}
}
