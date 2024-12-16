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
import com.ppxb.latte.admin.common.constsnt.RegexConstants;
import com.ppxb.latte.starter.extension.crud.model.req.BaseReq;
import com.ppxb.latte.starter.extension.crud.validation.CrudValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;

/**
 * 用户导入行数据
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@Schema(description = "用户导入行数据")
public class UserImportRowReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = RegexConstants.USERNAME, message = "用户名长度为 4-64 个字符，支持大小写字母、数字、下划线，以字母开头")
    private String username;

    @Schema(description = "昵称")
    @NotBlank(message = "昵称不能为空")
    @Pattern(regexp = RegexConstants.GENERAL_NAME, message = "昵称长度为 2-30 个字符，支持中文、字母、数字、下划线，短横线")
    private String nickname;

    @Schema(description = "密码")
    @NotBlank(message = "密码不能为空", groups = CrudValidationGroup.class)
    private String password;

    @Schema(description = "所属部门")
    @NotNull(message = "所属部门不能为空")
    private String deptName;

    @Schema(description = "所属角色")
    @NotBlank(message = "所属角色不能为空")
    private String roleName;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "邮箱")
    @Pattern(regexp = "^$|" + RegexPool.EMAIL, message = "邮箱地址格式错误")
    @Length(max = 255, message = "邮箱地址长度不能超过 {max} 个字符")
    private String email;

    @Schema(description = "手机号码")
    @Pattern(regexp = "^$|" + RegexPool.MOBILE, message = "手机号码格式错误")
    private String phone;

    @Schema(description = "描述")
    private String description;
}
