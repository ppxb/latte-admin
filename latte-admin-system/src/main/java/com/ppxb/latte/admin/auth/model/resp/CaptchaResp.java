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

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@Schema(description = "验证码信息")
public class CaptchaResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "验证码UUID")
    private String uuid;

    @Schema(description = "验证码图片（Base64编码，带图片格式：data:image/gif;base64）")
    private String img;

    @Schema(description = "过期时间")
    private Long expireTime;

    @Schema(description = "是否启用")
    private Boolean isEnabled;

    /**
     * 构建验证码信息
     *
     * @param uuid       验证码标识
     * @param img        验证码图片（Base64编码，带图片格式：data:image/gif;base64）
     * @param expireTime 过期时间戳
     * @return 验证码信息
     */
    public static CaptchaResp of(String uuid, String img, Long expireTime) {
        return CaptchaResp.builder().uuid(uuid).img(img).expireTime(expireTime).isEnabled(true).build();
    }
}
