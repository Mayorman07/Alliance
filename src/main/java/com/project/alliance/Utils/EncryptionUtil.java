package com.project.alliance.Utils;

import org.apache.commons.codec.binary.Hex;

import java.security.MessageDigest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {

    public static String hashWithSha256(String rawKey) throws Exception {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] encrypted = md.digest(rawKey.getBytes());
            return new String(Hex.encodeHex(encrypted));
        } catch (Exception ex) {
            String errorMessage = "Unable to hash this string";
            throw new Exception(errorMessage);
        }
    }
}
