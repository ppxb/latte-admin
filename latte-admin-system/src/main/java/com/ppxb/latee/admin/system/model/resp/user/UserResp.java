package com.ppxb.latee.admin.system.model.resp.user;

import cn.crane4j.annotation.Assemble;
import com.ppxb.latte.admin.common.constsnt.ContainerConstants;
import com.ppxb.latte.starter.extension.crud.model.resp.BaseDetailResp;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;

/**
 * 用户信息
 *
 * @author ppxb
 * @since 1.0.0
 */
@Data
@Schema(description = "用户信息")
@Assemble(key = "id", prop = ":roleIds", sort = 0, container = ContainerConstants.USER_ROLE_ID_LIST)
public class UserResp extends BaseDetailResp {

    @Serial
    private static final long serialVersionUID = 1L;

    
}
