package com.ppxb.latte.admin.common.enums;

import com.ppxb.latte.admin.common.constsnt.UIConstants;
import com.ppxb.latte.starter.core.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SuccessFailureStatusEnum implements BaseEnum<Integer> {

    SUCCESS(1, "成功", UIConstants.COLOR_SUCCESS),

    FAILURE(2, "失败", UIConstants.COLOR_ERROR);

    private final Integer value;

    private final String description;

    private final String color;
}
