package com.company;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.TreeMap;
public class VadsSignature{
        /**
         * Build signature (HMAC SHA-256 version) from provided parameters and secret key.
         * Parameters are provided as a TreeMap (with sorted keys).
         */
        public static String buildSignature(TreeMap<String, String> formParameters, String
                secretKey) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
            // Build message from parameters
            String message = String.join("+", formParameters.values());
            message += "+" + secretKey;
            // Sign
            return hmacSha256Base64(message, secretKey);
        }
        /**
         * Actual signing operation.
         */
        public static String hmacSha256Base64(String message, String secretKey) throws
                NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
            // Prepare hmac sha256 cipher algorithm with provided secretKey
            Mac hmacSha256;
            try {
                hmacSha256 = Mac.getInstance("HmacSHA256");
            } catch (NoSuchAlgorithmException nsae) {
                hmacSha256 = Mac.getInstance("HMAC-SHA-256");
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            hmacSha256.init(secretKeySpec);
            // Build and return signature
            return Base64.getEncoder().encodeToString(hmacSha256.doFinal(message.getBytes("UTF-8")));
        }
}

