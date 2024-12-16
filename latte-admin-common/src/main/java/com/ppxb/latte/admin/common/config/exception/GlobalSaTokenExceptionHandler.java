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



package com.ppxb.latte.admin.common.config.exception;

import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.ppxb.latte.starter.web.model.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@Order(99)
@RestControllerAdvice
public class GlobalSaTokenExceptionHandler {

    /**
     * 认证异常-登录认证
     */
    @ExceptionHandler(NotLoginException.class)
    public R handleNotLoginException(NotLoginException e, HttpServletRequest request) {
        log.error("[{}] {}", request.getMethod(), request.getRequestURI(), e);
        String errorMsg = switch (e.getType()) {
            case NotLoginException.KICK_OUT -> "您已被踢下线";
            case NotLoginException.BE_REPLACED_MESSAGE -> "您已被顶下线";
            default -> "您的登录已过期，请重新登录";
        };
        return R.fail(String.valueOf(HttpStatus.UNAUTHORIZED.value()), errorMsg);
    }

    /**
     * 认证异常-权限认证
     */
    @ExceptionHandler(NotPermissionException.class)
    public R handleNotPermissionException(NotPermissionException e, HttpServletRequest request) {
        log.error("[{}] {}", request.getMethod(), request.getRequestURI(), e);
        return R.fail(String.valueOf(HttpStatus.FORBIDDEN.value()), "没有访问权限，请联系管理员授权");
    }

    /**
     * 认证异常-角色认证
     */
    @ExceptionHandler(NotRoleException.class)
    public R handleNotRoleException(NotRoleException e, HttpServletRequest request) {
        log.error("[{}] {}", request.getMethod(), request.getRequestURI(), e);
        return R.fail(String.valueOf(HttpStatus.FORBIDDEN.value()), "没有访问权限，请联系管理员授权");
    }
}
