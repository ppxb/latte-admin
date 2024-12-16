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



package com.ppxb.latte.admin.system.service;

import com.ppxb.latte.admin.system.model.entity.UserDO;
import com.ppxb.latte.admin.system.model.query.UserQuery;
import com.ppxb.latte.admin.system.model.req.user.*;
import com.ppxb.latte.admin.system.model.resp.user.UserDetailResp;
import com.ppxb.latte.admin.system.model.resp.user.UserImportParseResp;
import com.ppxb.latte.admin.system.model.resp.user.UserImportResp;
import com.ppxb.latte.admin.system.model.resp.user.UserResp;
import com.ppxb.latte.starter.extension.crud.service.BaseService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 用户业务接口
 *
 * @author ppxb
 * @since 1.0.0
 */
public interface UserService extends BaseService<UserResp, UserDetailResp, UserQuery, UserReq> {

    /**
     * 下载导入模板
     *
     * @param response 响应对象
     * @throws IOException /
     */
    void downloadImportTemplate(HttpServletResponse response) throws IOException;

    /**
     * 解析导入数据
     *
     * @param file 导入文件
     * @return 解析结果
     */
    UserImportParseResp parseImport(MultipartFile file);

    /**
     * 导入数据
     *
     * @param req 导入信息
     * @return 导入结果
     */
    UserImportResp importUser(UserImportReq req);

    /**
     * 重置密码
     *
     * @param req 重置信息
     * @param id  ID
     */
    void resetPassword(UserPasswordResetReq req, Long id);

    /**
     * 修改角色
     *
     * @param updateReq 修改信息
     * @param id        ID
     */
    void updateRole(UserRoleUpdateReq updateReq, Long id);

    /**
     * 上传头像
     *
     * @param avatar 头像文件
     * @param id     ID
     * @return 新头像路径
     * @throws IOException /
     */
    String updateAvatar(MultipartFile avatar, Long id) throws IOException;

    /**
     * 修改基础信息
     *
     * @param req 修改信息
     * @param id  ID
     */
    void updateBasicInfo(UserBasicInfoUpdateReq req, Long id);

    /**
     * 修改密码
     *
     * @param oldPassword 当前密码
     * @param newPassword 新密码
     * @param id          ID
     */
    void updatePassword(String oldPassword, String newPassword, Long id);

    /**
     * 修改手机号
     *
     * @param newPhone    新手机号
     * @param oldPassword 当前密码
     * @param id          ID
     */
    void updatePhone(String newPhone, String oldPassword, Long id);

    /**
     * 修改邮箱
     *
     * @param newEmail    新邮箱
     * @param oldPassword 当前密码
     * @param id          ID
     */
    void updateEmail(String newEmail, String oldPassword, Long id);

    /**
     * 新增
     *
     * @param user 用户信息
     * @return ID
     */
    Long add(UserDO user);

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @return 用户信息
     */
    UserDO getByUsername(String username);

    /**
     * 根据手机号查询
     *
     * @param phone 手机号
     * @return 用户信息
     */
    UserDO getByPhone(String phone);

    /**
     * 根据邮箱查询
     *
     * @param email 邮箱
     * @return 用户信息
     */
    UserDO getByEmail(String email);

    /**
     * 根据部门 ID 列表查询
     *
     * @param deptIds 部门 ID 列表
     * @return 用户数量
     */
    Long countByDeptIds(List<Long> deptIds);
}
