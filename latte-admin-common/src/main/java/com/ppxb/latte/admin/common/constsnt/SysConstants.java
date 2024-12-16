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



package com.ppxb.latte.admin.common.constsnt;

public class SysConstants {

    /**
     * 否
     */
    public static final Integer NO = 0;

    /**
     * 是
     */
    public static final Integer YES = 1;

    /**
     * 超管用户 ID
     */
    public static final Long SUPER_USER_ID = 1L;

    /**
     * 顶级部门 ID
     */
    public static final Long SUPER_DEPT_ID = 1L;

    /**
     * 顶级父 ID
     */
    public static final Long SUPER_PARENT_ID = 0L;

    /**
     * 超管角色编码
     */
    public static final String SUPER_ROLE_CODE = "admin";

    /**
     * 超管角色 ID
     */
    public static final Long SUPER_ROLE_ID = 1L;

    /**
     * 全部权限标识
     */
    public static final String ALL_PERMISSION = "*:*:*";

    /**
     * 账号登录 URI
     */
    public static final String LOGIN_URI = "/auth/account";

    /**
     * 退出 URI
     */
    public static final String LOGOUT_URI = "/auth/logout";

    /**
     * 描述类字段后缀
     */
    public static final String DESCRIPTION_FIELD_SUFFIX = "String";

    private SysConstants() {
    }
}
