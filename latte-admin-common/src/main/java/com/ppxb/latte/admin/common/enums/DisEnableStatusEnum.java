package com.ppxb.latte.admin.common.enums;

import com.ppxb.latte.admin.common.constsnt.UIConstants;
import com.ppxb.latte.starter.core.enums.BaseEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DisEnableStatusEnum implements BaseEnum<Integer> {

    ENABLE(1, UIConstants.COLOR_SUCCESS),

    DISABLE(2, UIConstants.COLOR_ERROR);

    private final Integer value;

    private final String description;
}
