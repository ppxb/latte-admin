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

import cn.hutool.core.text.CharSequenceUtil;
import cn.hutool.core.util.NumberUtil;
import com.ppxb.latte.starter.core.exception.BadRequestException;
import com.ppxb.latte.starter.core.exception.BusinessException;
import com.ppxb.latte.starter.web.model.R;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.multipart.MultipartException;

@Slf4j
@Order(99)
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 拦截业务异常
     */
    @ExceptionHandler(BusinessException.class)
    public R handleBusinessException(BusinessException e, HttpServletRequest request) {
        log.error("[{}] {}", request.getMethod(), request.getRequestURI(), e);
        return R.fail(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), e.getMessage());
    }

    /**
     * 拦截自定义验证异常-错误请求
     */
    @ExceptionHandler(BadRequestException.class)
    public R handleBadRequestException(BadRequestException e, HttpServletRequest request) {
        log.error("[{}] {}", request.getMethod(), request.getRequestURI(), e);
        return R.fail(String.valueOf(HttpStatus.BAD_REQUEST.value()), e.getMessage());
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public R handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e,
                                                       HttpServletRequest request) {
        log.error("[{}] {}", request.getMethod(), request.getRequestURI(), e);
        return R.fail(String.valueOf(HttpStatus.BAD_REQUEST.value()), "参数 '%s' 类型不匹配".formatted(e.getName()));
    }

    /**
     * 拦截文件上传异常-超过上传大小限制
     */
    @ExceptionHandler(MultipartException.class)
    public R handleRequestTooBigException(MultipartException e, HttpServletRequest request) {
        log.error("[{}] {}", request.getMethod(), request.getRequestURI(), e);
        String msg = e.getMessage();
        R defaultFail = R.fail(String.valueOf(HttpStatus.BAD_REQUEST.value()), msg);
        if (CharSequenceUtil.isBlank(msg)) {
            return defaultFail;
        }
        String sizeLimit;
        Throwable cause = e.getCause();
        if (null != cause) {
            msg = msg.concat(cause.getMessage().toLowerCase());
        }
        if (msg.contains("size") && msg.contains("exceed")) {
            sizeLimit = CharSequenceUtil.subBetween(msg, "the maximum size ", " for");
        } else if (msg.contains("larger than")) {
            sizeLimit = CharSequenceUtil.subAfter(msg, "larger than ", true);
        } else {
            return defaultFail;
        }
        String errorMsg = "请上传小于 %sKB 的文件".formatted(NumberUtil.parseLong(sizeLimit) / 1024);
        return R.fail(String.valueOf(HttpStatus.BAD_REQUEST.value()), errorMsg);
    }
}
