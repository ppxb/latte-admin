package com.ppxb.latee.admin.auth.service;

import com.ppxb.latee.admin.auth.model.query.OnlineUserQuery;
import com.ppxb.latee.admin.auth.model.resp.OnlineUserResp;
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
