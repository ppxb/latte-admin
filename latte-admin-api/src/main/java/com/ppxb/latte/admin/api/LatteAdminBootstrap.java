package com.ppxb.latte.admin.api;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.URLUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
public class LatteAdminBootstrap implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(LatteAdminBootstrap.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @Override
    public void run(ApplicationArguments args) {
        String host = NetUtil.localIpv4s().stream().findFirst().orElse("127.0.0.1");
        Integer port = 9527;
        String baseUrl = URLUtil.normalize("%s:%s%s".formatted(host, port, "/"));
        log.info("----------------------------------------------");
        log.info("{} service started successfully.", "Latte Admin");
        log.info("API Url: {}", baseUrl);
        log.info("----------------------------------------------");
    }
}
