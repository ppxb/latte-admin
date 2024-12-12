package com.ppxb.latte.admin.common.context;

import cn.hutool.core.collection.CollUtil;
import com.ppxb.latte.admin.common.constsnt.SysConstants;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class UserContext implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String username;

    private Long deptId;

    private LocalDateTime pwdResetTime;

    private Integer passwordExpirationDays;

    private Set<String> permissions;

    private Set<String> roleCodes;

    private Set<RoleContext> roles;

    public UserContext(Set<String> permissions, Set<RoleContext> roles, Integer passwordExpirationDays) {
        this.permissions = permissions;
        this.setRoles(roles);
        this.passwordExpirationDays = passwordExpirationDays;
    }

    public void setRoles(Set<RoleContext> roles) {
        this.roles = roles;
        this.roleCodes = roles.stream().map(RoleContext::getCode).collect(Collectors.toSet());
    }

    /**
     * 是否为管理员
     *
     * @return true：是；false：否
     */
    public boolean isAdmin() {
        if (CollUtil.isEmpty(roleCodes)) {
            return false;
        }
        return roleCodes.contains(SysConstants.SUPER_ROLE_CODE);
    }

    /**
     * 密码是否已过期
     *
     * @return 是否过期
     */
    public boolean isPasswordExpired() {
        // 永久有效
        if (this.passwordExpirationDays == null || this.passwordExpirationDays <= SysConstants.NO) {
            return false;
        }
        // 初始密码（第三方登录用户）暂不提示修改
        if (this.pwdResetTime == null) {
            return false;
        }
        return this.pwdResetTime.plusDays(this.passwordExpirationDays).isBefore(LocalDateTime.now());
    }
}
