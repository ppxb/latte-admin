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

import com.ppxb.latte.starter.core.constant.StringConstants;

/**
 * 缓存相关常量
 *
 * @author ppxb
 * @since 1.0.0
 */
public class CacheConstants {

    /**
     * 分隔符
     */
    public static final String DELIMITER = StringConstants.COLON;

    /**
     * 验证码键前缀
     */
    public static final String CAPTCHA_KEY_PREFIX = "CAPTCHA" + DELIMITER;

    /**
     * 用户缓存键前缀
     */
    public static final String USER_KEY_PREFIX = "USER" + DELIMITER;

    /**
     * 用户密码错误次数缓存键前缀
     */
    public static final String USER_PASSWORD_ERROR_KEY_PREFIX = USER_KEY_PREFIX + "PASSWORD_ERROR" + DELIMITER;

    /**
     * 菜单缓存键前缀
     */
    public static final String MENU_KEY_PREFIX = "MENU" + DELIMITER;

    /**
     * 字典缓存键前缀
     */
    public static final String DICT_KEY_PREFIX = "DICT" + DELIMITER;

    /**
     * 参数缓存键前缀
     */
    public static final String OPTION_KEY_PREFIX = "OPTION" + DELIMITER;

    /**
     * 仪表盘缓存键前缀
     */
    public static final String DASHBOARD_KEY_PREFIX = "DASHBOARD" + DELIMITER;

    /**
     * 数据导入临时会话key
     */
    public static final String DATA_IMPORT_KEY = "SYSTEM" + DELIMITER + "DATA_IMPORT" + DELIMITER;

    private CacheConstants() {
    }
}
