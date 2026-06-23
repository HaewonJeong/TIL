package com.ohgiraffers.springsecurity;

import java.util.Base64;

public class EncodingDecoding {
    public static void main(String[] args) {
        //java 8에서 제공하는 기본 Base64 Encoder와 Decoder
        Base64.Encoder encoder = Base64.getEncoder();
        Base64.Decoder decoder = Base64.getDecoder();

        String testStr = "base64로인코딩한비밀키";
        byte[] encodeArr = testStr.getBytes();

        byte[] encodeByte = encoder.encode(encodeArr);
        String encodeStr = new String(encodeByte);
        System.out.println("encodeStr = " + encodeStr); //먼저 실행해서 encodeStr 값을 얻는다.

        byte[] decodeByte = decoder.decode("YmFzZTY066Gc7J247L2U65Sp7ZWc67mE67CA7YKk");
        System.out.println("new String(decodeByte) = " + new String(decodeByte));
    }
}
