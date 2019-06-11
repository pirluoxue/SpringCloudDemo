package com.example.zuul.util;

import org.springframework.util.StreamUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * @Classname HttpUtils
 * @Description http的工具类
 * @Date 2019-06-11
 * @Created by chen_bq
 */
public class HttpUtils {

    public static String getBodyByInputStream(InputStream inputStream){
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) > -1 ) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
            String body = baos.toString();
            inputStream.close();
            return body;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
