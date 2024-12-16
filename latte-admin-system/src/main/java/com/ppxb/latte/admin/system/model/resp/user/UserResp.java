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
import com.ppxb.latte.admin.common.constsnt.ContainerConstants;
import com.ppxb.latte.admin.common.context.UserContextHolder;
import com.ppxb.latte.admin.common.enums.DisEnableStatusEnum;
import com.ppxb.latte.admin.common.enums.GenderEnum;
import com.ppxb.latte.starter.extension.crud.model.resp.BaseDetailResp;
import com.ppxb.latte.starter.security.mask.annotation.JsonMask;
import com.ppxb.latte.starter.security.mask.enums.MaskType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.util.List;
import java.util.Objects;

/**
 * 用户信息
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@Schema(description = "用户信息")
@Assemble(key = "id", prop = ":roleIds", sort = 0, container = ContainerConstants.USER_ROLE_ID_LIST)
public class UserResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "性别")
    private GenderEnum gender;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "邮箱")
    @JsonMask(MaskType.EMAIL)
    private String email;

    @Schema(description = "手机号码")
    @JsonMask(MaskType.MOBILE_PHONE)
    private String phone;

    @Schema(description = "状态")
    private DisEnableStatusEnum status;

    @Schema(description = "是否为系统内置数据")
    private Boolean isSystem;

    @Schema(description = "描述")
    private String description;

    @Schema(description = "部门ID")
    private Long deptId;

    @Schema(description = "所属部门")
    private String deptName;

    @Schema(description = "角色ID列表")
    @Assemble(prop = ":roleNames", container = ContainerConstants.USER_ROLE_NAME_LIST, handlerType = ManyToManyAssembleOperationHandler.class)
    private List<Long> roleIds;

    @Schema(description = "角色名称列表")
    private List<String> roleNames;

    @Override
    public Boolean getDisabled() {
        return this.getIsSystem() || Objects.equals(this.getId(), UserContextHolder.getUserId());
    }
}
