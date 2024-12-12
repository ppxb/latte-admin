package com.ppxb.latee.admin.auth.model.resp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@Schema(description = "令牌信息")
public class LoginResp implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Schema(description = "令牌")
    private String token;
}
