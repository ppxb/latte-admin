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

import com.ppxb.latte.admin.auth.model.query.OnlineUserQuery;
import com.ppxb.latte.admin.auth.model.resp.OnlineUserResp;
import com.ppxb.latte.starter.extension.crud.model.query.PageQuery;
import com.ppxb.latte.starter.extension.crud.model.resp.PageResp;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 在线用户业务接口
 */
public interface OnlineUserService {

    /**
     * 分页查询列表
     *
     * @param query     查询条件
     * @param pageQuery 分页查询条件
     * @return 分页列表信息
     */
    PageResp<OnlineUserResp> page(OnlineUserQuery query, PageQuery pageQuery);

    /**
     * 查询列表
     *
     * @param query 查询条件
     * @return 列表信息
     */
    List<OnlineUserResp> list(OnlineUserQuery query);

    /**
     * 查询 Token 最后活跃时间
     *
     * @param token Token
     * @return 最后活跃时间
     */
    LocalDateTime getLastActiveTime(String token);

    /**
     * 踢出用户
     *
     * @param userId 用户 ID
     */
    void kickOut(Long userId);
}
