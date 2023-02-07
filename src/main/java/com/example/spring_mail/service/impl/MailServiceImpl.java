package com.example.spring_mail.service.impl;

import com.example.spring_mail.dto.DataMailDTO;
import com.example.spring_mail.service.MailService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
@Slf4j // log.info("message")
public class MailServiceImpl implements MailService {
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;
    @Override
    public void sendHtmlMail(DataMailDTO dataMailDTO, String templateName) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage(); // create a message

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8"); // true = multipart message

        Context context = new Context();
        context.setVariables(dataMailDTO.getProps());

        String html = templateEngine.process(templateName, context);

        helper.setTo(dataMailDTO.getTo());
        helper.setSubject(dataMailDTO.getSubject());
        helper.setText(html, true);

        mailSender.send(message);
    }
}
