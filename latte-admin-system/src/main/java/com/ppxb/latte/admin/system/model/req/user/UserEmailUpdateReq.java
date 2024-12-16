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



package com.ppxb.latte.admin.system.model.req.user;

import cn.hutool.core.lang.RegexPool;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户邮箱修改参数
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@Schema(description = "用户邮箱修改参数")
public class UserEmailUpdateReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "新邮箱地址")
    @NotBlank(message = "新邮箱地址不能为空")
    @Pattern(regexp = RegexPool.EMAIL, message = "邮箱地址格式错误")
    private String email;

    @Schema(description = "验证码")
    @NotBlank(message = "验证码不能为空")
    @Length(max = 6, message = "验证码非法")
    private String captcha;

    @Schema(description = "当前密码（加密）")
    @NotBlank(message = "当前密码不能为空")
    private String oldPassword;
}
