package com.ppxb.latee.admin.auth.model.resp;

import cn.crane4j.annotation.Assemble;
import cn.crane4j.annotation.AssembleMethod;
import cn.crane4j.annotation.ContainerMethod;
import cn.crane4j.annotation.MappingType;
import com.ppxb.latee.admin.auth.service.OnlineUserService;
import com.ppxb.latte.admin.common.constsnt.ContainerConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Schema(description = "在线用户信息")
public class OnlineUserResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @Assemble(prop = ":nickname", container = ContainerConstants.USER_NICKNAME)
    private Long id;

    @Schema(description = "令牌")
    @AssembleMethod(prop = ":lastActiveTime", targetType = OnlineUserService.class, method = @ContainerMethod(bindMethod = "getLastActiveTime", type = MappingType.ORDER_OF_KEYS))
    private String token;

    @Schema(description = "用户名")
    private String username;

    @Schema(description = "昵称")
    private String nickname;

    @Schema(description = "登录IP")
    private String ip;

    @Schema(description = "登录地址")
    private String address;

    @Schema(description = "浏览器")
    private String browser;

    @Schema(description = "操作系统")
    private String os;

    @Schema(description = "登录时间")
    private LocalDateTime loginTime;

    @Schema(description = "最后活跃时间")
    private LocalDateTime lastActiveTime;
}
