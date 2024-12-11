/*
 * MIT License
 *
 * Copyright (c) 2024 ppxb
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package com.ppxb.latte.admin.api;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.github.xiaoymin.knife4j.spring.configuration.Knife4jProperties;
import com.ppxb.latte.starter.core.autoconfigure.project.ProjectProperties;
import com.ppxb.latte.starter.web.annotation.EnableGlobalResponse;
import com.ppxb.latte.starter.web.model.R;
import io.swagger.v3.oas.annotations.Hidden;
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
@EnableGlobalResponse
@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class LatteAdminBootstrap implements ApplicationRunner {

    private final ProjectProperties projectProperties;

    private final ServerProperties serverProperties;

    public static void main(String[] args) {
        SpringApplication.run(LatteAdminBootstrap.class, args);
    }

    @Hidden
    @GetMapping("/")
    public R<?> index() {
        return R.ok("🚀 %s server started successfully.".formatted(projectProperties.getName()), null);
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
