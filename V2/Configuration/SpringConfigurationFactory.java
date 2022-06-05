package com.MAX.V2.Configuration;

import com.MAX.V2.Controller.Controllers;
import com.MAX.V2.Service.Services;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SpringConfigurationFactory {
    @Bean(name = "Controllers")
    @Scope(value = "prototype")
    public Controllers controllersBean(){

        return new Controllers(servicesBean());

    }
    @Bean(name = "Services")
    public Services servicesBean(){
        return new Services();
    }

}
