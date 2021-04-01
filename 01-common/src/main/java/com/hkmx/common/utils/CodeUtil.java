package com.hkmx.common.utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

public class CodeUtil {

    public static String hexSHA1(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(value.getBytes("utf-8"));
            byte[] digest = md.digest();
            return byteToHexString(digest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String hexMD5(String value) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(value.getBytes("utf-8"));
            byte[] digest = md.digest();
            return byteToHexString(digest);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String byteToHexString(byte[] bytes) {
        return String.valueOf(Hex.encodeHex(bytes));
    }

    public static void main(String[] args) {
        String appKey = "xingwne";
        String appSecret = "xingwen";
        // String nonce = String.valueOf(Math.random() * 1000000);
        // String timestamp = String.valueOf(System.currentTimeMillis() / 1000);

        String nonce = "0";
        String timestamp = "0";

        StringBuilder toSign = new StringBuilder(appSecret).append(nonce).append(timestamp);
        String sign = CodeUtil.hexSHA1(toSign.toString());
        System.out.println("RC-App-Key:" + appKey);
        System.out.println("RC-Nonce:" + nonce);
        System.out.println("RC-Timestamp:" + timestamp);
        System.out.println("RC-Signature:" + sign);

    }
}
