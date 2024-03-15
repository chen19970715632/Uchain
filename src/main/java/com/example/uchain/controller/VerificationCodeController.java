package com.example.uchain.controller;

import com.example.uchain.demo.Result;
import com.example.uchain.dto.MenberCodeDto;
import com.example.uchain.service.impl.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@Slf4j
@RestController

@RequestMapping("/code")
public class VerificationCodeController {

    private final EmailService emailService;
    public VerificationCodeController(EmailService emailService) {
        this.emailService = emailService;
    }



    @PostMapping("/send")
    public Result sendVerificationCode(@RequestBody MenberCodeDto menberCodeDto) throws MessagingException {

        log.info("发送验证码...");
        // 发送验证码邮件
        emailService.sendVerificationCode(menberCodeDto);
        return Result.success("发送成功！");
    }




}
