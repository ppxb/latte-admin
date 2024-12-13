package com.ppxb.latte.admin.controller.auth;

import com.ppxb.latte.starter.log.interceptor.annotation.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log(module = "登录")
@Tag(name = "认证 API")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
}
