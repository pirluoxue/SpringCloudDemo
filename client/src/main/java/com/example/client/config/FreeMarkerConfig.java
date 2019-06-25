package com.example.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreeMarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;
    
    
	@PostConstruct
    public void setConfigure() throws Exception {
		configuration.setAPIBuiltinEnabled(false);
		configuration.setDefaultEncoding("UTF-8");
        //configuration.setSharedVariable("static_server", "//www.dev.pangugle.com/static");

    }



}
