package com.ppxb.latte.admin.common.config.websocket;

import cn.dev33.satoken.stp.StpUtil;
import com.ppxb.latte.starter.core.exception.BusinessException;
import com.ppxb.latte.starter.messaging.websocket.core.WebSocketClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class WebSocketClientServiceImpl implements WebSocketClientService {

    @Override
    public String getClientId(ServletServerHttpRequest request) {
        HttpServletRequest servletRequest = request.getServletRequest();
        String token = servletRequest.getParameter("token");
        if (StpUtil.getLoginIdByToken(token) == null) {
            throw new BusinessException("登录已过期，请重新登录");
        }
        return token;
    }
}
