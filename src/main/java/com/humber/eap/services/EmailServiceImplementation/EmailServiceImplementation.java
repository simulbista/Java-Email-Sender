package com.humber.eap.services.EmailServiceImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.humber.eap.services.EmailService;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImplementation implements EmailService {
	@Value("${spring.mail.username")
	private String from;

	@Autowired
	private JavaMailSender javaMailSender;

	public String sendEmail(MultipartFile[] file, String to, String[] cc, String subject, String body) {

		try {

			MimeMessage message = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom(from);
			helper.setTo(to);
			helper.setCc(cc);
			helper.setSubject(subject);
			helper.setText(body);

			for (int i = 0; i < file.length; i++) {
				helper.addAttachment(file[i].getOriginalFilename(), new ByteArrayResource(file[i].getBytes()));
			}

			javaMailSender.send(message);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Email has been sent successfully!";
	}
}
