package com.ay.common.utils.sign;

import cn.dev33.satoken.secure.SaSecureUtil;

/**
 * RSA加密工具
 */
public class RSA {
    // 定义私钥和公钥
    private static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOCoNiRpV/TgFaQkV01fS9H532Z+hY1R4ftehY7RHFwu0cHU5nRGMwnj8atNg1Q6MitDYukmd3ZVZpAgEjI2jfwKYdwmfk2ltApbUg7oTY5MP9rbBeSIJm7SAwQ2msVBiN+c5FoEqzJfxVBARGKzTi5Ki04CfGzXtR4wKAzKd0URAgMBAAECgYAPaXrNZKy0D+tsJ1IV7MO20/2Pen6PA18Nb56Z/Z6EdHHPaluk/mvh8dFSfy7TSGrIrQbMF+d6JsGygYC+ESAMWXHKaOUcGGFINPzsf7SXMMLCQokhu1Dcd5JG37gQZgSoJae52SGqdBg46U0iTjGDYVqh+oUGk/MR0fCPB9enAQJBAOE3Qxtiuc0EpKfzPE80og7o8BCNXavEHGElZb9Q6EzZbTpd5RWKZvEMVtIlrLny2N6u2F0drK1EuuL24OP2rrUCQQD/XWVqyx9glAhrG1JVnnOtvbEYK8HTIEjZtLYKBnCm9bNkWsFpdjpAG4lJVZ923JxRjevJaZ7binq0ANTfvpptAkEAr6QwkuAI9Ypke5Mn+sGajbQ+3TnSzs2wMFdBJdaMhLqhA/8MVSNOKzmrUFMPhSmO1wRXOy+UZsEOW0mclEzjbQJAecn5TG2DkXQIb8yf/+WKFhqaE4UK8746AFqHV1Cq+XXFEN+XzsxsC5cWartDSlT82IhvI6gT83CgBKlA3VTyIQJBAIQVfWQNXzzlBqf/LRo2menyNm5o0GKxaE1ix00a0wvL9bi6j7wizQYoa9K+EAaq8VBtqr9JtB8RHQaMUyfGH+g=";
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDgqDYkaVf04BWkJFdNX0vR+d9mfoWNUeH7XoWO0RxcLtHB1OZ0RjMJ4/GrTYNUOjIrQ2LpJnd2VWaQIBIyNo38CmHcJn5NpbQKW1IO6E2OTD/a2wXkiCZu0gMENprFQYjfnORaBKsyX8VQQERis04uSotOAnxs17UeMCgMyndFEQIDAQAB";


    /**
     * 使用公钥加密
     *
     * @param text 加密文本
     * @return
     */
    public static String rsaEncryptByPublic(String text) {
        return SaSecureUtil.rsaEncryptByPublic(publicKey, text);
    }


    /**
     * 使用私钥解密
     *
     * @param text 解密文本
     * @return
     */
    public static String rsaDecryptByPrivate(String text) {
        return SaSecureUtil.rsaDecryptByPrivate(privateKey, text);
    }
}
