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
import com.ppxb.latte.admin.common.enums.DisEnableStatusEnum;
import com.ppxb.latte.admin.common.enums.GenderEnum;
import com.ppxb.latte.starter.extension.crud.model.req.BaseReq;
import com.ppxb.latte.starter.extension.crud.validation.CrudValidationGroup;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.util.List;

@Data
@Schema(description = "创建或修改用户参数")
public class UserReq extends BaseReq {

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

    @Schema(description = "密码（加密）")
    @NotBlank(message = "密码不能为空", groups = CrudValidationGroup.Add.class)
    private String password;

    @Schema(description = "邮箱")
    @Pattern(regexp = "^$|" + RegexPool.EMAIL, message = "邮箱格式错误")
    private String email;

    @Schema(description = "手机号码")
    @Pattern(regexp = "^$|" + RegexPool.MOBILE, message = "手机号码格式错误")
    private String phone;

    @Schema(description = "性别")
    @NotNull(message = "性别非法")
    private GenderEnum gender;

    @Schema(description = "所属部门")
    @NotNull(message = "所属部门不能为空")
    private Long deptId;

    @Schema(description = "所属角色")
    @NotEmpty(message = "所属角色不能为空")
    private List<Long> roleIds;

    @Schema(description = "描述")
    @Length(max = 200, message = "描述长度不能超过 {max} 个字符")
    private String description;

    @Schema(description = "状态")
    private DisEnableStatusEnum status;
}
