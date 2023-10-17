package com.sts.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

import com.sts.dao.UserRepository;
import com.sts.entity.LoginData;
import com.sts.entity.SigninData;
import com.sts.entity.User;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;


@Controller
public class MyController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/login")
	public String login(Model model){
		model.addAttribute("logindata",new LoginData());
		return "/html/login";
	}
	@GetMapping("/signin")
	public String signin(Model model){
		model.addAttribute("signindata",new SigninData());
		return "/html/signin";
	}
	 @GetMapping("/termsandcondition")
	    public String termsAndConditions(Model model) {
	        // Your logic to handle the terms and conditions page
	        return "/html/termsandcondition"; // Return the Thymeleaf template name
	    }
	@PostMapping("/process/login")
	public String process(@Valid @ModelAttribute("logindata") LoginData logindata,BindingResult result){
		if(result.hasErrors()) {
			System.out.println(result);
			return "/html/login";
		}
		User user = userRepository.findFirstByUsername(logindata.getUsername());
		if(user==null) {
			result.addError(new FieldError("logindata", "username", "USER DOES'NT EXSISTS ---- PLSS GO TO SIGN-IN PAGE "));
			System.out.println(result);
			return "/html/login";
		}
		else {
			if(logindata.getPassword().equals(user.getPassword())) {
		System.out.println(logindata);
		return "/html/process";
		}
			else
			{
				result.addError(new FieldError("logindata", "password", "WRONG-PASSWORD "));
				System.out.println(result);
				return "/html/login";
			}
		}
	}
	@PostMapping("/process/signin")
	public String process1(@Valid @ModelAttribute("signindata") SigninData signindata,BindingResult result){
		try{
			if(result.hasErrors()) {
			System.out.println(result);
			return "/html/signin";
		}
		System.out.println(signindata);
		User usr = userRepository.findFirstByUsername(signindata.getUsername());
		if(usr!=null) {
			result.addError(new FieldError("signindata", "username", "USER EXSISTS ---- PLSS GO TO LOG-IN PAGE "));
			System.out.println(result);
			return "/html/signin";
		}
		if(signindata.getPassword().equals(signindata.getrPassword())) {
		User user=new User();
		user.setUsername(signindata.getUsername());
		user.setPassword(signindata.getPassword());
		user.setAgreeme(signindata.isAgreeMe());
		userRepository.save(user);
		return "/html/process";
		}
		 result.addError(new FieldError("signindata", "rPassword", "BOTH THE PASSWORD NEEDS TO BE SAME"));
		//result.addError(new ObjectError("form","BOTH THE PASSWORD NEEDS TO BE SAME"));
		
		return  "/html/signin";
		}
		catch(Exception e) {
			e.printStackTrace();
			result.addError(new FieldError("signindata", "rPassword", "INTERNAL SERVER ERROR"));
			return  "/html/signin";
		}
	}
	

}
