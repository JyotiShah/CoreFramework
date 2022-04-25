package com.centralframework.springbootseleniumcucumber.service;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WindowSwitchService {

    @Autowired
    private ApplicationContext ctx;

    public void switchByTitle(final String title){
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .map(handle -> driver.switchTo().window(handle).getTitle())
                .filter(t -> t.startsWith(title))
                .findFirst();

//                .orElseThrow(() -> {
//                    throw new RuntimeException("No such window");
//                });
    }

    public void switchByIndex(final int index){
        WebDriver driver = this.ctx.getBean(WebDriver.class);
        String[] handles = driver.getWindowHandles().toArray(new String[0]);
        driver.switchTo().window(handles[index]);
    }

}
