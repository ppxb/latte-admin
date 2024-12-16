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



package com.ppxb.latte.admin.system.enums;

import cn.hutool.core.collection.CollUtil;
import com.ppxb.latte.starter.core.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 数据导入策略
 *
 * @author ppxb
 * @since 1.0.0
 */
@Getter
@RequiredArgsConstructor
public enum ImportPolicyEnum implements BaseEnum<Integer> {

    SKIP(1, "跳过改行"),

    UPDATE(2, "更新数据"),

    EXIT(3, "停止导入");

    private final Integer value;

    private final String description;

    public boolean validate(ImportPolicyEnum importPolicy, String data, List<String> existsList) {
        return this == importPolicy && CollUtil.isNotEmpty(existsList) && existsList.contains(data);
    }
}
