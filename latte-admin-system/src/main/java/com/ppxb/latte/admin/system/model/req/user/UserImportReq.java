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

import com.ppxb.latte.admin.common.enums.DisEnableStatusEnum;
import com.ppxb.latte.admin.system.enums.ImportPolicyEnum;
import com.ppxb.latte.starter.extension.crud.model.req.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;

@Data
@Schema(description = "用户导入参数")
public class UserImportReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "导入会话KEY")
    @NotBlank(message = "导入已过期，请重新上传")
    private String importKey;

    @Schema(description = "重复用户策略")
    @NotNull(message = "重复用户策略不能为空")
    private ImportPolicyEnum duplicateUser;

    @Schema(description = "重复邮箱策略")
    @NotNull(message = "重复邮箱策略不能为空")
    private ImportPolicyEnum duplicateEmail;

    @Schema(description = "重复手机策略")
    @NotNull(message = "重复手机策略不能为空")
    private ImportPolicyEnum duplicatePhone;

    @Schema(description = "默认状态")
    private DisEnableStatusEnum defaultStatus;
}
