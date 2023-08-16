package com.humber.eap.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface EmailService {

	String sendEmail(MultipartFile[] file, String to, String[] cc, String subject, String body);

}
