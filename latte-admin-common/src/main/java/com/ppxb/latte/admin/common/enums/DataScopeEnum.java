package com.ppxb.latte.admin.common.enums;

import com.ppxb.latte.starter.core.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DataScopeEnum implements BaseEnum<Integer> {

    ALL(1, "全部数据权限"),

    DEPT_AND_CHILD(2, "本部门及一下数据权限"),

    DEPT(3, "本部门数据权限"),

    SELF(4, "仅本人数据权限"),

    CUSTOM(5, "自定义数据权限");

    private final Integer value;

    private final String description;
}
