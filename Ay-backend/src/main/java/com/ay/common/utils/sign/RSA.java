package com.ay.common.utils.sign;

import cn.dev33.satoken.secure.SaSecureUtil;

/**
 * RSA加密工具
 */
public class RSA {
    // 定义私钥和公钥
    private static String privateKey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAOCoNiRpV/TgFaQkV01fS9H532Z+hY1R4ftehY7RHFwu0cHU5nRGMwnj8atNg1Q6MitDYukmd3ZVZpAgEjI2jfwKYdwmfk2ltApbUg7oTY5MP9rbBeSIJm7SAwQ2msVBiN+c5FoEqzJfxVBARGKzTi5Ki04CfGzXtR4wKAzKd0URAgMBAAECgYAPaXrNZKy0D+tsJ1IV7MO20/2Pen6PA18Nb56Z/Z6EdHHPaluk/mvh8dFSfy7TSGrIrQbMF+d6JsGygYC+ESAMWXHKaOUcGGFINPzsf7SXMMLCQokhu1Dcd5JG37gQZgSoJae52SGqdBg46U0iTjGDYVqh+oUGk/MR0fCPB9enAQJBAOE3Qxtiuc0EpKfzPE80og7o8BCNXavEHGElZb9Q6EzZbTpd5RWKZvEMVtIlrLny2N6u2F0drK1EuuL24OP2rrUCQQD/XWVqyx9glAhrG1JVnnOtvbEYK8HTIEjZtLYKBnCm9bNkWsFpdjpAG4lJVZ923JxRjevJaZ7binq0ANTfvpptAkEAr6QwkuAI9Ypke5Mn+sGajbQ+3TnSzs2wMFdBJdaMhLqhA/8MVSNOKzmrUFMPhSmO1wRXOy+UZsEOW0mclEzjbQJAecn5TG2DkXQIb8yf/+WKFhqaE4UK8746AFqHV1Cq+XXFEN+XzsxsC5cWartDSlT82IhvI6gT83CgBKlA3VTyIQJBAIQVfWQNXzzlBqf/LRo2menyNm5o0GKxaE1ix00a0wvL9bi6j7wizQYoa9K+EAaq8VBtqr9JtB8RHQaMUyfGH+g=";
    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDgqDYkaVf04BWkJFdNX0vR+d9mfoWNUeH7XoWO0RxcLtHB1OZ0RjMJ4/GrTYNUOjIrQ2LpJnd2VWaQIBIyNo38CmHcJn5NpbQKW1IO6E2OTD/a2wXkiCZu0gMENprFQYjfnORaBKsyX8VQQERis04uSotOAnxs17UeMCgMyndFEQIDAQAB";

//    //私钥
//    private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJ2OFpew9LhR2GLF\n" +
//            "YwlUfHml4DKe4VXWU1MVcBjJIo79FBknlGsQFSuMWyer9LY3uvtyYpaYj+7UqPww\n" +
//            "o98A7IIr1XwrgBb0fQebqJ17APx3OulsveFTMTT0mHWLSLA4VtLtnjW4xrrj+guO\n" +
//            "FB6XohwNdJyPRaoYF+9OF/U2tB5bAgMBAAECgYA5laIaRRnceEV/LCebVF6+U2sS\n" +
//            "9VDkf5Yqyq4S0QipfEQpQXcUfmdOaFk0sbuaEdpsZo0z/4SzxNQSgHCUZBEMmtO9\n" +
//            "hocIyhvCh7oa+eGdcWb/MQSemx8hCNg/YYPSWBZ70siJeCdmjR+YNepz2q/sAm9p\n" +
//            "414haEDmEOTMfASRAQJBAOFLfqi5+KLLOxB65s6sNSNw2kA0sXLmzcRhTmXSVrrM\n" +
//            "uCalLPUtBKDOuxQcHICTrEqq9gAigKSBRL5mz1sSMoECQQCzByjeF+r8LVy20eZM\n" +
//            "F/6q4LioYAW82nhf0KKUdiXkQoJkAHWcHzFIHbHd9y1PKHFWvgThJ11TM6ygUAlN\n" +
//            "eerbAkB/g4BDtUaBtW9Pq5AZJ6TH02bj8i8BLpsF7GE4Bi3qelY8IT7p4bn93iRK\n" +
//            "hIKpT2uzs0Ga3+xZr4SeE4iHLiyBAkBQe/yEdC5BNseCrTSiqvrjqWl60Mhjkbgi\n" +
//            "IzKkGcWJK9lgydAV4vQN3sOy7UeiWaUygPTCoCbVm9qUq8ay3QeXAkEAuz0eqWFS\n" +
//            "zu+j5A11OYo1RMQlB2U10qwLj9FAwtkTNzDQcgiB/SLLWgXfcWO5lNTv2M/ha87c\n" +
//            "BZxtQL4TbghDPg==";
//    //公钥
//    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdjhaXsPS4UdhixWMJVHx5peAy\n" +
//            "nuFV1lNTFXAYySKO/RQZJ5RrEBUrjFsnq/S2N7r7cmKWmI/u1Kj8MKPfAOyCK9V8\n" +
//            "K4AW9H0Hm6idewD8dzrpbL3hUzE09Jh1i0iwOFbS7Z41uMa64/oLjhQel6IcDXSc\n" +
//            "j0WqGBfvThf1NrQeWwIDAQAB";


    /**
     * 使用公钥加密
     * @param text 加密文本
     * @return
     */
    public static String rsaEncryptByPublic(String text){
        return SaSecureUtil.rsaEncryptByPublic(publicKey,text);
    }


    /**
     * 使用私钥解密
     * @param text 解密文本
     * @return
     */
    public static String rsaDecryptByPrivate(String text){
        return SaSecureUtil.rsaDecryptByPrivate(privateKey,text);
    }
}
