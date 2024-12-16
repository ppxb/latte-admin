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



package com.ppxb.latte.admin.system.model.entity;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ppxb.latte.admin.common.config.mybatis.BCryptEncryptor;
import com.ppxb.latte.admin.common.enums.DisEnableStatusEnum;
import com.ppxb.latte.admin.common.enums.GenderEnum;
import com.ppxb.latte.starter.extension.crud.annotation.DictField;
import com.ppxb.latte.starter.extension.crud.model.entity.BaseDO;
import com.ppxb.latte.starter.security.crypto.annotation.FieldEncrypt;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;

/**
 * 用户实体
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@DictField(labelKey = "nickname", extraKeys = {"username"})
@TableName("sys_user")
public class UserDO extends BaseDO {

    @Serial
    private static final long serialVersionUID = 1L;

    private String username;

    private String nickname;

    @FieldEncrypt(encryptor = BCryptEncryptor.class)
    private String password;

    private GenderEnum gender;

    @FieldEncrypt
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String email;

    @FieldEncrypt
    @TableField(insertStrategy = FieldStrategy.NOT_EMPTY)
    private String phone;

    private String avatar;

    private String description;

    private DisEnableStatusEnum status;

    private Boolean isSystem;

    private LocalDateTime pwdResetTime;

    private Long deptId;
}
