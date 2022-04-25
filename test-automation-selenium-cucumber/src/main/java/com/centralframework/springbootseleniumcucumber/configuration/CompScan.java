package com.centralframework.springbootseleniumcucumber.configuration;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.selenium",
        "com.selenium.demo"})
public class CompScan {
}
