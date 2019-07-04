package com.example.client.config;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Classname ApplicationConfiguration
 * @Description 用于获取当前项目的地址
 * @Date 2019-06-25
 * @Created by chen_bq
 */
@Component
public class ApplicationConfiguration implements ApplicationListener<WebServerInitializedEvent> {

    private int serverPort;
    private String serverAddress;

    private static final String PREFIX = "http://";

    @Override
    public void onApplicationEvent(WebServerInitializedEvent webServerInitializedEvent) {
        this.serverPort = webServerInitializedEvent.getWebServer().getPort();
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        serverAddress = PREFIX + address.getHostAddress() + ":" + this.serverPort;
    }

    public int getServerPort() {
        return serverPort;
    }

    public String getServerAddress() {
        return serverAddress;
    }
}
