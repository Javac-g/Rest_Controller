package com.MAX.V1.Configuration;

import com.MAX.V1.Controller.Controller;
import com.MAX.V1.Service.Services;
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
