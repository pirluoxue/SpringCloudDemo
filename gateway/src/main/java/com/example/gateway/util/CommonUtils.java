package com.example.gateway.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @Classname CommonUtils
 * @Description TODO
 * @Date 2019-06-13
 * @Created by chen_bq
 */
public class CommonUtils {

    public static String defaultEnCoderUri(String str){
        String encode = str;
        try {
            encode = URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encode;
    }

}
