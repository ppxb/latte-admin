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
                .map(r -> new RoleContext(
                        Convert.toStr(r.getId()),
                        DataScope.valueOf(r.getDataScope().name())
                ))
                .collect(Collectors.toSet()));
        return userContext;
    }
}
