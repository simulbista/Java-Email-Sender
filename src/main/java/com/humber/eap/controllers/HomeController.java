package com.humber.eap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.humber.eap.annotation.TimeCheck;
import com.humber.eap.services.EmailService;

@RestController
@RequestMapping(value = "api/mail")
public class HomeController {

	@Autowired
	EmailService emailservice;

	@PostMapping("/send")
	@TimeCheck
	public String sendEmail(@RequestParam(value = "file", required = false) MultipartFile[] file, @RequestParam String to,
			@RequestParam String[] cc, @RequestParam String subject, @RequestParam String body) {
		return emailservice.sendEmail(file, to, cc, subject, body);
	}
}
