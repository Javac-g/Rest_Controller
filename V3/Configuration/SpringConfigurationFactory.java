package com.MAX.V3.Configuration;

import com.MAX.V3.Controller.Controller;
import com.MAX.V3.Services.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {

    @Bean(name = "Service")
    public Services servicesBean(){
        return new Services();
    }

    @Bean(name = "Controller")
    @Scope(value = "prototype")
    public Controller controllerBean(){

        return new Controller(servicesBean());
    }


}
