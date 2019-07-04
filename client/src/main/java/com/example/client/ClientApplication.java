package com.example.client;

import com.example.client.config.ApplicationConfiguration;
import com.example.client.config.FreeMarkerConfig;
import com.example.client.util.SpringContextUtils;
import com.netflix.discovery.converters.Auto;
import freemarker.template.Configuration;
import freemarker.template.TemplateModelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ClientApplication {

    public static void main(String[] args) throws TemplateModelException {
        SpringApplication.run(ClientApplication.class, args);
        //动态配置资源地址
        ApplicationConfiguration applicationConfiguration = SpringContextUtils.getBean(ApplicationConfiguration.class);
        Configuration freeMarkerConfig = SpringContextUtils.getBean(Configuration.class);
        freeMarkerConfig.setSharedVariable("static_server", applicationConfiguration.getServerAddress());
    }

}
