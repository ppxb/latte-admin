package com.ppxb.latee.admin.system.model.resp;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Schema(description = "参数管理")
public class OptionResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    private Long id;

    @Schema(description = "名称")
    private String name;

    @Schema(description = "键")
    private String code;

    @Schema(description = "值")
    private String value;

    @JsonIgnore
    private String defaultValue;

    @Schema(description = "描述")
    private String description;

    public String getValue() {
        return StrUtil.nullToDefault(value, defaultValue);
    }
}
