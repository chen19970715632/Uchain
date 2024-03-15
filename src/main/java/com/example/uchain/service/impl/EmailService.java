package com.example.uchain.service.impl;

import com.example.uchain.dto.MenberCodeDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendVerificationCode(MenberCodeDto menberCodeDto) throws MessagingException {

        // 生成随机验证码
        String code = generateVerificationCode(6);
        log.info(code);
        String email = menberCodeDto.getEmail();

        // 构造邮件消息对象
        MimeMessage message = mailSender.createMimeMessage();
        message.setFrom(new InternetAddress("2326211920@qq.com"));
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email);
        helper.setSubject("Verification Code");
        helper.setText("尊敬的用户，\n"
                + "您正在进行邮箱验证操作。请使用以下验证码完成验证步骤：\n"
                + "验证码：" + code +"\n"
                + "请在页面上输入该验证码以完成验证。请勿将验证码泄露给他人。\n"
                + "如果您未进行此操作，请忽略此邮件。\n"
                + "如有任何问题，请随时联系我们的客服团队。\n"
                + "谢谢！");

        // 发送邮件
        mailSender.send(message);

        //将验证码存入缓存中
        saveVerificationCode(email, code);
    }

    // 生成随机验证码的方法
    private String generateVerificationCode(int length) {
        // 实现自己的生成逻辑
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
                //通过 withinRange 方法指定了随机字符的范围，我们这里设置为从 '0' 到 '9'。
                .withinRange('0', '9')
                //通过 filteredBy 方法筛选了只保留字母和数字字符。
                .filteredBy(Character::isLetterOrDigit)
                .build();
        return randomStringGenerator.generate(length);
    }

    // 将验证码保存在缓存中
    private void saveVerificationCode(String email, String code) {
        // 将验证码存入缓存
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        opsForValue.set(email, code,  60,TimeUnit.SECONDS);
        log.info(opsForValue.get(email));
    }

    //将缓存中的验证码和页面传来的验证码进行比对
    public boolean verificationCode(String email, String code){
        ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
        String s = opsForValue.get(email);
        if (!s.equals(code)){
            return false;
        }
        return true;
    }
}
