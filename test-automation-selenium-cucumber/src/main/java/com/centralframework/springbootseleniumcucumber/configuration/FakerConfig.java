package com.centralframework.springbootseleniumcucumber.configuration;


import com.centralframework.springboot.supportselenium.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {

    @Bean
    public Faker getFaker(){
        return new Faker();
    }

}
