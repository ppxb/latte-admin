package com.ppxb.latee.admin.system.model.req;

import com.ppxb.latte.starter.extension.crud.model.req.BaseReq;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serial;

/**
 * 修改参数请求参数
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@Schema
public class OptionReq extends BaseReq {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Schema(description = "ID")
    @NotNull(message = "ID不能为空")
    private Long id;

    /**
     * 键
     */
    @Schema(description = "键", example = "site_title")
    @NotBlank(message = "键不能为空")
    @Length(max = 100, message = "键长度不能超过 {max} 个字符")
    private String code;

    /**
     * 值
     */
    @Schema(description = "值")
    private String value;
}
