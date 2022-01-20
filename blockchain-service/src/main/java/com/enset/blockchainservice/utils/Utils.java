package com.enset.blockchainservice.utils;

import java.security.MessageDigest;
public class Utils {

    public static String sha256( String base) {
        try{
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(base.getBytes());
            final StringBuilder hexString = new StringBuilder();
            for (int i = 0; i < hash.length; i++) {
                final String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1)
                    hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
    public static String  zeros(int dificulty){
        StringBuilder str=new StringBuilder();
        for (int i=0;i<dificulty;i++){
            str.append("0");
        }
        return str.toString();

    }
}
