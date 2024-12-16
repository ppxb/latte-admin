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

import cn.hutool.core.convert.Convert;
import com.ppxb.latte.admin.common.context.UserContextHolder;
import com.ppxb.latte.starter.extension.datapermission.enums.DataScope;
import com.ppxb.latte.starter.extension.datapermission.filter.DataPermissionUserContextProvider;
import com.ppxb.latte.starter.extension.datapermission.model.RoleContext;
import com.ppxb.latte.starter.extension.datapermission.model.UserContext;

import java.util.stream.Collectors;

public class DefaultDataPermissionUserContextProvider implements DataPermissionUserContextProvider {

    @Override
    public boolean isFilter() {
        return !UserContextHolder.isAdmin();
    }

    @Override
    public UserContext getUserContext() {
        com.ppxb.latte.admin.common.context.UserContext context = UserContextHolder.getContext();
        UserContext userContext = new UserContext();
        userContext.setUserId(Convert.toStr(context.getId()));
        userContext.setDeptId(Convert.toStr(context.getDeptId()));
        userContext.setRoles(context.getRoles()
            .stream()
            .map(r -> new RoleContext(Convert.toStr(r.getId()), DataScope.valueOf(r.getDataScope().name())))
            .collect(Collectors.toSet()));
        return userContext;
    }
}
