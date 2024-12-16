/*
 * MIT License
 *
 * Copyright (c) 2024 ppxb
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */



package com.ppxb.latte.admin.auth.service;

import com.ppxb.latte.admin.auth.model.resp.RouteResp;
import jakarta.servlet.http.HttpServletRequest;
import me.zhyd.oauth.model.AuthUser;

import java.util.List;

public interface LoginService {

    /**
     * 账号登录
     *
     * @param username 用户名
     * @param password 密码
     * @param request  请求对象
     * @return 令牌
     */
    String accountLogin(String username, String password, HttpServletRequest request);

    /**
     * 手机号登录
     *
     * @param phone 手机号
     * @return 令牌
     */
    String phoneLogin(String phone);

    /**
     * 邮箱登录
     *
     * @param email 邮箱
     * @return 令牌
     */
    String emailLogin(String email);

    /**
     * 三方账号登录
     *
     * @param authUser 三方账号信息
     * @return 令牌
     */
    String socialLogin(AuthUser authUser);

    /**
     * 构建路由树
     *
     * @param userId 用户 ID
     * @return 路由树
     */
    List<RouteResp> buildRouteTree(Long userId);
}
