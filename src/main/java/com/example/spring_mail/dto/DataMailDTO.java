package com.example.spring_mail.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataMailDTO {
    private String to;//email người nhận
    private String subject;//tiêu đề
    private String content;//nội dung
    private Map<String, Object> props;//tham số truyền vào template html
}
