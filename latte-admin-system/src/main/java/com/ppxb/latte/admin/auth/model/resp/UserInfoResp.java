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



package com.ppxb.latte.admin.auth.model.resp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ppxb.latte.admin.common.enums.GenderEnum;
import com.ppxb.latte.starter.security.mask.annotation.JsonMask;
import com.ppxb.latte.starter.security.mask.enums.MaskType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Schema(description = "用户信息")
public class UserInfoResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private GenderEnum gender;

    @Schema(description = "邮箱")
    @JsonMask(MaskType.EMAIL)
    private String email;

    @Schema(description = "手机号码")
    @JsonMask(MaskType.MOBILE_PHONE)
    private String phone;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "最后一次密码修改时间")
    private LocalDateTime pwdResetTime;

    @Schema(description = "密码是否已过期")
    private Boolean pwdExpired;

    @JsonIgnore
    private LocalDateTime createTime;

    @Schema(description = "注册日期")
    private LocalDate registrationDate;

    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "所属部门")
    private String deptName;

    @Schema(description = "权限码集合")
    private Set<String> permissions;

    @Schema(description = "角色编码集合")
    private Set<String> roles;

    public LocalDate getRegistrationDate() {
        return createTime.toLocalDate();
    }
}
