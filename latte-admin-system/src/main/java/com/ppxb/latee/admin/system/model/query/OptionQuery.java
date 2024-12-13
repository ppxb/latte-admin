package com.ppxb.latee.admin.system.model.query;

import com.ppxb.latee.admin.system.enums.OptionCategoryEnum;
import com.ppxb.latte.starter.core.validation.constraints.EnumValue;
import com.ppxb.latte.starter.data.core.annotation.Query;
import com.ppxb.latte.starter.data.core.enums.QueryType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 参数查询条件
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@Schema(description = "参数查询条件")
public class OptionQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "键列表")
    @Query(type = QueryType.IN)
    private List<String> code;

    @Schema(description = "类别")
    @EnumValue(value = OptionCategoryEnum.class, message = "参数类别非法")
    private String category;
}
