package com.company;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException {
        String valueToDigest = "Ho Minh Canh cute";
        byte[] key = "secret".getBytes();

        HmacUtils hm = new HmacUtils();
        String messageDigest = hm.generateHmac256(valueToDigest, key);
        System.out.println(messageDigest);
    }
}
