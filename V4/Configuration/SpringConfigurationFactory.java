package com.MAX.V4.Configuration;

import com.MAX.V4.Controller.Controller;
import com.MAX.V4.Service.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")
    Services servicesBean(){

        return new Services();

    }
    @Bean(name = "Controller")
    @Scope(value = "prototyype")
    Controller controller(){

        return new Controller(servicesBean());

    }





}
