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



package com.ppxb.latte.admin.common.config.mybatis;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.ppxb.latte.admin.common.context.UserContextHolder;
import com.ppxb.latte.starter.extension.crud.model.entity.BaseDO;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

/**
 * MyBatis Plus 元对象处理器配置（插入或修改时自动填充）
 */
public class MyBatisPlusMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建人
     */
    private static final String CREATE_USER = "createUser";

    /**
     * 创建时间
     */
    private static final String CREATE_TIME = "createTime";

    /**
     * 修改人
     */
    private static final String UPDATE_USER = "updateUser";

    /**
     * 修改时间
     */
    private static final String UPDATE_TIME = "updateTime";

    /**
     * 插入数据时填充
     *
     * @param metaObject 元对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject == null) {
            return;
        }
        Long createUser = UserContextHolder.getUserId();
        LocalDateTime createTime = LocalDateTime.now();
        if (metaObject.getOriginalObject() instanceof BaseDO baseDO) {
            // 继承了 BaseDO 的类，填充创建信息字段
            baseDO.setCreateUser(ObjectUtil.defaultIfNull(baseDO.getCreateUser(), createUser));
            baseDO.setCreateTime(ObjectUtil.defaultIfNull(baseDO.getCreateTime(), createTime));
        } else {
            // 未继承 BaseDO 的类，如存在创建信息字段则进行填充
            fillFieldValue(metaObject, CREATE_USER, createUser, false);
            fillFieldValue(metaObject, CREATE_TIME, createTime, false);
        }
    }

    /**
     * 修改数据时填充
     *
     * @param metaObject 元对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        if (metaObject == null) {
            return;
        }
        Long updateUser = UserContextHolder.getUserId();
        LocalDateTime updateTime = LocalDateTime.now();
        if (metaObject.getOriginalObject() instanceof BaseDO baseDO) {
            // 继承了 BaseDO 的类，填充修改信息
            baseDO.setUpdateUser(updateUser);
            baseDO.setUpdateTime(updateTime);
        } else {
            // 未继承 BaseDO 的类，根据类中拥有的修改信息字段进行填充，不存在修改信息字段不进行填充
            fillFieldValue(metaObject, UPDATE_USER, updateUser, true);
            fillFieldValue(metaObject, UPDATE_TIME, updateTime, true);
        }
    }

    /**
     * 填充字段值
     *
     * @param metaObject     元数据对象
     * @param fieldName      要填充的字段名
     * @param fillFieldValue 要填充的字段值
     * @param isOverride     如果字段值不为空，是否覆盖（true：覆盖；false：不覆盖）
     */
    private void fillFieldValue(MetaObject metaObject, String fieldName, Object fillFieldValue, boolean isOverride) {
        if (metaObject.hasSetter(fieldName)) {
            Object fieldValue = metaObject.getValue(fieldName);
            setFieldValByName(fieldName, fieldValue != null && !isOverride ? fieldValue : fillFieldValue, metaObject);
        }
    }
}
