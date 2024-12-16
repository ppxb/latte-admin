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



package com.ppxb.latte.admin.system.model.resp.user;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.core.executor.handler.ManyToManyAssembleOperationHandler;
import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.ppxb.latte.admin.common.constsnt.ContainerConstants;
import com.ppxb.latte.admin.common.context.UserContextHolder;
import com.ppxb.latte.admin.common.enums.DisEnableStatusEnum;
import com.ppxb.latte.admin.common.enums.GenderEnum;
import com.ppxb.latte.starter.extension.crud.model.resp.BaseDetailResp;
import com.ppxb.latte.starter.file.excel.converter.ExcelBaseEnumConverter;
import com.ppxb.latte.starter.file.excel.converter.ExcelListConverter;
import com.ppxb.latte.starter.security.crypto.annotation.FieldEncrypt;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * 用户详情信息
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@Schema(description = "用户详情信息")
@ExcelIgnoreUnannotated
@Assemble(key = "id", prop = ":roleIds", sort = 0, container = ContainerConstants.USER_ROLE_ID_LIST)
public class UserDetailResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    @ExcelProperty(value = "用户名", order = 2)
    private String username;

    @Schema(description = "昵称")
    @ExcelProperty(value = "昵称", order = 3)
    private String nickname;

    @Schema(description = "状态")
    @ExcelProperty(value = "状态", order = 4, converter = ExcelBaseEnumConverter.class)
    private DisEnableStatusEnum status;

    @Schema(description = "性别")
    @ExcelProperty(value = "性别", order = 5, converter = ExcelBaseEnumConverter.class)
    private GenderEnum gender;

    @Schema(description = "部门ID")
    @ExcelProperty(value = "部门ID", order = 6)
    private Long deptId;

    @Schema(description = "所属部门")
    @ExcelProperty(value = "所属部门", order = 7)
    private String deptName;

    @Schema(description = "角色ID列表")
    @Assemble(prop = ":roleNames", container = ContainerConstants.USER_ROLE_NAME_LIST, handlerType = ManyToManyAssembleOperationHandler.class)
    @ExcelProperty(value = "角色ID列表", order = 8, converter = ExcelListConverter.class)
    private List<Long> roleIds;

    @Schema(description = "角色名称列表")
    @ExcelProperty(value = "角色", order = 9, converter = ExcelListConverter.class)
    private List<String> roleNames;

    @Schema(description = "手机号码")
    @ExcelProperty(value = "手机号码", order = 10)
    @FieldEncrypt
    private String phone;

    @Schema(description = "邮箱")
    @ExcelProperty(value = "邮箱", order = 11)
    @FieldEncrypt
    private String email;

    @Schema(description = "系统内置")
    @ExcelProperty(value = "系统内置", order = 12)
    private Boolean isSystem;

    @Schema(description = "描述")
    @ExcelProperty(value = "描述", order = 13)
    private String description;

    @Schema(description = "头像地址")
    @ExcelProperty(value = "头像地址", order = 14)
    private String avatar;

    @Schema(description = "最后一次修改密码时间", type = "string")
    private LocalDateTime pwdResetTime;

    @Override
    public Boolean getDisabled() {
        return this.isSystem || Objects.equals(this.getId(), UserContextHolder.getUserId());
    }
}
