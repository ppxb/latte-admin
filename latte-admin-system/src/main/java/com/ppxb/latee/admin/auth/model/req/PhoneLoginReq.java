package com.ppxb.latee.admin.auth.model.req;

import cn.hutool.core.lang.RegexPool;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "手机号登录参数")
public class PhoneLoginReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "手机号")
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = RegexPool.MOBILE, message = "请输入正确的手机号")
    private String phone;

    @Schema(description = "验证码")
    @NotBlank(message = "验证码不能为空")
    @Length(max = 4, message = "验证码非法")
    private String captcha;
}
