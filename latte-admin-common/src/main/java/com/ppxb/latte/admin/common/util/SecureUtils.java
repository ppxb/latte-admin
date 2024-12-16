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



package com.ppxb.latte.admin.common.util;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.extra.spring.SpringUtil;
import com.ppxb.latte.admin.common.config.properties.RSAProperties;
import com.ppxb.latte.starter.core.exception.BusinessException;
import com.ppxb.latte.starter.core.validation.ValidationUtils;
import com.ppxb.latte.starter.security.crypto.autoconfigure.CryptoProperties;
import com.ppxb.latte.starter.security.crypto.encryptor.AESEncryptor;
import com.ppxb.latte.starter.security.crypto.encryptor.IEncryptor;

import java.util.List;
import java.util.stream.Collectors;

public class SecureUtils {

    private SecureUtils() {
    }

    public static String encryptByRSAPublicKey(String data) {
        String publicKey = RSAProperties.PUBLIC_KEY;
        ValidationUtils.throwIfBlank(publicKey, "请配置 RSA 公钥");
        return encryptByRSAPublicKey(data, publicKey);
    }

    public static String decryptByRSAPrivateKey(String data) {
        String privateKey = RSAProperties.PRIVATE_KEY;
        ValidationUtils.throwIfBlank(privateKey, "请配置 RSA 私钥");
        return decryptByRSAPrivateKey(data, privateKey);
    }

    public static String encryptByRSAPublicKey(String data, String publicKey) {
        return new String(SecureUtil.rsa(null, publicKey).encrypt(data, KeyType.PublicKey));
    }

    public static String decryptByRSAPrivateKey(String data, String privateKey) {
        return new String(SecureUtil.rsa(privateKey, null).decrypt(Base64.decode(data), KeyType.PrivateKey));
    }

    public static List<String> encryptFieldByAES(List<String> values) {
        IEncryptor encryptor = new AESEncryptor();
        CryptoProperties properties = SpringUtil.getBean(CryptoProperties.class);
        return values.stream().map(value -> {
            try {
                return encryptor.encrypt(value, properties.getPassword(), properties.getPublicKey());
            } catch (Exception e) {
                throw new BusinessException("字段加密异常");
            }
        }).collect(Collectors.toList());
    }
}
