package com.ppxb.latte.admin.common.context;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.JakartaServletUtil;
import com.ppxb.latte.starter.core.util.ExceptionUtils;
import com.ppxb.latte.starter.core.util.IpUtils;
import com.ppxb.latte.starter.web.util.ServletUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class UserExtraContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String ip;

    private String address;

    private String browser;

    private String os;

    private LocalDateTime loginTime;

    public UserExtraContext(HttpServletRequest request) {
        this.ip = JakartaServletUtil.getClientIP(request);
        this.address = ExceptionUtils.exToNull(() -> IpUtils.getIpv4Address(this.ip));
        this.setBrowser(ServletUtils.getBrowser(request));
        this.setOs(StrUtil.subBefore(ServletUtils.getOs(request), " or", false));
        this.setLoginTime(LocalDateTime.now());
    }
}
