package com.example.spring_mail.service;

import com.example.spring_mail.dto.DataMailDTO;

import javax.mail.MessagingException;


public interface MailService {
    void sendHtmlMail(DataMailDTO dataMailDTO, String templateName)throws MessagingException;
}
