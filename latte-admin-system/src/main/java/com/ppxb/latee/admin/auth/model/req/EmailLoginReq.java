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
@Schema(description = "邮箱登录参数")
public class EmailLoginReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "邮箱")
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = RegexPool.EMAIL, message = "请输入正确的邮箱地址")
    private String email;

    @Schema(description = "验证码")
    @NotBlank(message = "验证码不能为空")
    @Length(max = 6, message = "验证码非法")
    private String captcha;
}
