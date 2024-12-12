package com.ppxb.latee.admin.auth.model.resp;

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
