package com.ppxb.latte.admin.api;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.github.xiaoymin.knife4j.spring.configuration.Knife4jProperties;
import com.ppxb.latte.starter.core.autoconfigure.project.ProjectProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class LatteAdminBootstrap implements ApplicationRunner {

    private final ProjectProperties projectProperties;

    private final ServerProperties serverProperties;

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
        Integer port = serverProperties.getPort();
        String contextPath = serverProperties.getServlet().getContextPath();
        String baseUrl = URLUtil.normalize("%s:%s%s".formatted(host, port, contextPath));

        log.info("----------------------------------------------");
        log.info("🚀 Server started successfully.");
        log.info("{} - {}", projectProperties.getName(), projectProperties.getDescription());
        log.info("API 地址：{}", baseUrl);
        Knife4jProperties knife4jProperties = SpringUtil.getBean(Knife4jProperties.class);
        if (!knife4jProperties.isProduction()) {
            log.info("API 文档地址：{}/doc.html", baseUrl);
        }
        log.info("----------------------------------------------");
    }
}
