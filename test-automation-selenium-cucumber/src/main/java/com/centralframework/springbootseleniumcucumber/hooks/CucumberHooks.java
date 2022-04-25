package com.centralframework.springbootseleniumcucumber.hooks;

import com.centralframework.springboot.supportselenium.annotation.LazyAutowired;
import com.centralframework.springbootseleniumcucumber.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;


public class CucumberHooks {

    @LazyAutowired
    private ScreenshotService screenshotService;

    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario){
        if(scenario.isFailed()){
            byte[] f = this.screenshotService.getScreenshot();
            scenario.getName();
        }
    }

    @After
    public void afterScenario(){
        this.applicationContext.getBean(WebDriver.class).quit();
    }

}
