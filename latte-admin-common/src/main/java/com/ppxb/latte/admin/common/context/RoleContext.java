package com.ppxb.latte.admin.common.context;

import com.ppxb.latte.admin.common.enums.DataScopeEnum;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 角色上下文
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
public class RoleContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    private Long id;

    /**
     * 角色编码
     */
    private String code;

    /**
     * 数据权限
     */
    private DataScopeEnum dataScope;
}
