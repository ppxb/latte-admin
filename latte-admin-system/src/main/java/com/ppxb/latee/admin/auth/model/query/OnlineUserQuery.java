package com.ppxb.latee.admin.auth.model.query;

import cn.hutool.core.date.DatePattern;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 在线用户查询条件
 */
@Data
@Schema(description = "在线用户查询条件")
public class OnlineUserQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 用户昵称
     */
    @Schema(description = "用户昵称")
    private String nickname;

    /**
     * 登录时间
     */
    @Schema(description = "登录时间", example = "2024-08-08 00:00:00,2024-08-08 23:59:59")
    @DateTimeFormat(pattern = DatePattern.NORM_DATETIME_PATTERN)
    private List<Date> loginTime;

    /**
     * 用户 ID
     */
    @Schema(hidden = true)
    private Long id;

    /**
     * 角色 ID
     */
    @Schema(hidden = true)
    private Long roleId;
}