package com.example.client.config;

import com.example.client.util.SpringContextUtils;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.annotation.PostConstruct;

@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

//    @Autowired
//    private ApplicationConfiguration applicationConfiguration;
    
	@PostConstruct
    public void setConfigure() throws Exception {
		configuration.setAPIBuiltinEnabled(false);
		configuration.setDefaultEncoding("UTF-8");
        //configuration.setSharedVariable("static_server", "//www.dev.pangugle.com/static");
//        configuration.setSharedVariable("static_server", applicationConfiguration.getServerAddress());

//        configuration.setSharedVariable("static_server", System.getProperty("server.address"));
    }



}
