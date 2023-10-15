package com.sts.controller;

//import org.apache.tomcat.util.http.fileupload.FileUpload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sts.helper.Helper;

@RestController
public class Controller {
    @Autowired
    private Helper helper;

    @PostMapping("/controller/upload")
    public ResponseEntity<String> upload(@RequestParam MultipartFile file) {
        try {
            if (file.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("FileISEmpty");
            }
            if (helper.uploadFile(file) && (file.getContentType().equals("image/jpg") || file.getContentType().equals("image/jpeg") )) {
                System.out.println(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()));
                return ResponseEntity.ok("file uploaded");
            } else {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Please upload expected jpg file!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("FileISEmpty");

    }

}
