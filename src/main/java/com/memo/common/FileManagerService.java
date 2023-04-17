package com.memo.common;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component	// 일반적인 spring bean 
public class FileManagerService {
	// 실제 업로드 된 이미지가 저장될 경로(서버)
	public static final String FILE_UPLOAD_PATH = "C:\\Users\\user\\Documents\\박지호\\박지호\\6_spring_project\\memo\\workspace\\images/";	// 슬래쉬를 마지막에 넣어주어야 한다.
	
	// input: MultipartFIle(이미지파일), loginId 이미지가 겹치게 하지 않기 위해서 loginId도 받아옴.
	// output: image path(String)
	public String saveFIle(String loginId,MultipartFile file) {
		// 파일 디렉토리(폴더) 예)	aaaa_1678687/sun.png
		String directoryName = loginId + "_" + System.currentTimeMillis() + "/";	// aaaa_1678687/
		String filePath = FILE_UPLOAD_PATH + directoryName;	// C:\\Users\\user\\Documents\\박지호\\박지호\\6_spring_project\\memo\\workspace\\images/
		
		File directory = new File(filePath);
		if(directory.mkdir() == false) {
			return null;	// 폴더 만드는데 실패 시 이미지경로 null
		}
		
		// 파일 업로드: byte 단위로 업로드
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(filePath + file.getOriginalFilename());	// 디렉토리명 + OriginalFilename은 사용자가 올린 파일명
			Files.write(path, bytes);	// 파일 업로드
		} catch (IOException e) {
			e.printStackTrace();
			return null;	
		}
		// 파일 업로드가 성공했으면 이미지 url path를 리턴한다.
		// http://localhost/images/aaaa_1678687/sun.png
		return "/images/" + directoryName + file.getOriginalFilename();	// originalFilename은 사용자가 올린 파일명
	}
}
