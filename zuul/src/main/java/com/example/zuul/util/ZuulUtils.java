package com.example.zuul.util;

import com.netflix.zuul.context.RequestContext;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Classname ZuulUtils
 * @Description zuul工具类
 * @Date 2019-06-11
 * @Created by chen_bq
 */
public class ZuulUtils {

    public static final String ResponseDataStreamKey = "responseDataStream";

    public static String getResponseDataByRequestContext(RequestContext requestContext){
        InputStream stream = requestContext.getResponseDataStream();
        String body = null;
        try {
            ByteArrayOutputStream baos = getByteArrayOutputStream(stream);
            InputStream resetInputStream = new ByteArrayInputStream(baos.toByteArray());
            body = baos.toString();
            baos.close();
            stream.close();
            replaceInputstream(requestContext, resetInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return body;
        }
    }

    public static ByteArrayOutputStream getByteArrayOutputStream(InputStream stream){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[1024];
            int len;
            while ((len = stream.read(buffer)) > -1 ) {
                baos.write(buffer, 0, len);
            }
            baos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return baos;
        }
    }

    private static void replaceInputstream(RequestContext requestContext, InputStream replaceInputStream){
        requestContext.replace(ResponseDataStreamKey, replaceInputStream);
    }


}
