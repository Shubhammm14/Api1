package com.sts.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class Helper {
	public boolean uploadFile(MultipartFile file) {
		Boolean b=false;
		try {
			// Fix: File is already sent from the request param hence removed creating URL
			//url=new ClassPathResource("static/images").getFile().getAbsolutePath();
			InputStream is= file.getInputStream();
			byte[] data=new byte[is.available()];
			is.read(data);
			
			//Fix : After taking the file from request param saving this to static Folder.
			FileOutputStream fos= new FileOutputStream("src/main/resources/static/images"+file.getOriginalFilename());
			fos.write(data);
			fos.flush();
			fos.close();
			b=true;
			//Files.copy(file.getInputStream(), Paths.get(url+File.separator+file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
