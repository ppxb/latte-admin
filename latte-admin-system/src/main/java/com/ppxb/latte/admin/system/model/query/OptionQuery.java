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



package com.ppxb.latte.admin.system.model.query;

import com.ppxb.latte.admin.system.enums.OptionCategoryEnum;
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