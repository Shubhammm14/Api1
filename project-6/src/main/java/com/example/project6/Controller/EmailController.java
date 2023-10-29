package com.example.project6.Controller;

import com.example.project6.modle.EmailRequest;
import com.example.project6.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    @Autowired
    private EmailService emailService;

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    //api to snn email
    @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
    public ResponseEntity<?> senEmail(@RequestBody EmailRequest request) {
        emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
        return ResponseEntity.ok("done.....");
    }
}
