package com.ppxb.latte.admin.common.config.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "captcha")
public class CaptchaProperties {

    @Value("${latte-starter.captcha.graphic.expirationInMinutes}")
    private long expirationInMinutes;

    private CaptchaMail mail;

    private CaptchaSMS sms;

    @Data
    public static class CaptchaMail {

        private int length;

        private long expirationInMinutes;

        private String templatePath;
    }

    @Data
    public static class CaptchaSMS {

        private int length;

        private long expirationInMinutes;

        private String templateId;
    }
}
