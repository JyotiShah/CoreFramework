package com.centralframework.springboot.testngselenium.base;

import com.centralframework.springboot.testngselenium.service.WebDriverManagerUtil;
import lombok.Value;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest  {


    private String URL;

    WebDriver driver = new WebDriverManagerUtil().getWebDriver();

    public WebDriver BaseTest(){
        return driver;
    }
    @BeforeTest
    public void setUp(){
        driver.get(URL);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
