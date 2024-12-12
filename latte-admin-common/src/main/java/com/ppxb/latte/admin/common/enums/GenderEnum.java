package com.ppxb.latte.admin.common.enums;

import com.ppxb.latte.starter.core.enums.BaseEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum implements BaseEnum<Integer> {

    UNKNOWN(0, "未知"),

    MALE(1, "男"),

    FEMALE(2, "女");

    private final Integer value;

    private final String description;
}
