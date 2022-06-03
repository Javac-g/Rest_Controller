package com.MAX.Configuration;

import com.MAX.Controller.Controller;
import com.MAX.Service.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")

    public Services servicesB(){

        return new Services();

    }
    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controllerB(){

        return new Controller(servicesB());

    }


}
