package com.example.spring_mail.service;


import com.example.spring_mail.service.sdi.ClientSdi;

import javax.mail.MessagingException;

public interface ClientService {
    Boolean create(ClientSdi sdi) throws MessagingException;
}
