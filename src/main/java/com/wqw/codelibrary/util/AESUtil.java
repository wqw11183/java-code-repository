package com.wqw.codelibrary.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {

    private final static String aes = "AES";

    private final static String mode = "AES/ECB/PKCS5Padding";

    private final static String charSet = "utf-8";

    // 加密
    public static String encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            throw new IllegalArgumentException("sKey参数为空");
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            throw new IllegalArgumentException("Key长度不是16位");
        }
        byte[] raw = sKey.getBytes(charSet);
        SecretKeySpec skeySpec = new SecretKeySpec(raw, aes);
        Cipher cipher = Cipher.getInstance(mode);//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes(charSet));

        return new Base64().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                throw new IllegalArgumentException("sKey参数为空");
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                throw new IllegalArgumentException("Key长度不是16位");
            }
            byte[] raw = sKey.getBytes(charSet);
            SecretKeySpec skeySpec = new SecretKeySpec(raw, aes);
            Cipher cipher = Cipher.getInstance(mode);
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new Base64().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,charSet);
                return originalString;
            } catch (Exception e) {
                throw new Exception("解密失败");
            }
        } catch (Exception ex) {
            throw new Exception("解密失败");
        }
    }

}