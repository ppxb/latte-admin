package com.ppxb.latte.admin.common.config.properties;

import cn.hutool.extra.spring.SpringUtil;

public class RSAProperties {

    public static final String PRIVATE_KEY;

    public static final String PUBLIC_KEY;

    static {
        PUBLIC_KEY = SpringUtil.getProperty("latte-starter.security.crypto.public-key");
        PRIVATE_KEY = SpringUtil.getProperty("latte-starter.security.crypto.private-key");
    }

    private RSAProperties() {
    }
}
