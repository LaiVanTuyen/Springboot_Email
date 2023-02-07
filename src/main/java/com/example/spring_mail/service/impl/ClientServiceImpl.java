package com.example.spring_mail.service.impl;

import com.example.spring_mail.dto.DataMailDTO;
import com.example.spring_mail.service.ClientService;
import com.example.spring_mail.service.MailService;
import com.example.spring_mail.service.sdi.ClientSdi;
import com.example.spring_mail.utils.Const;
import com.example.spring_mail.utils.DataUtils;
import javax.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private MailService mailService;
    @Override
    public Boolean create(ClientSdi sdi) throws MessagingException {
        DataMailDTO dataMail = new DataMailDTO();

        dataMail.setTo(sdi.getEmail());
        dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);

        Map<String, Object> props = new HashMap<>();
        props.put("name", sdi.getName());
        props.put("username", sdi.getUsername());
        props.put("password", DataUtils.generateTempPwd(6));
        dataMail.setProps(props);

        mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
        return true;
    }
}
