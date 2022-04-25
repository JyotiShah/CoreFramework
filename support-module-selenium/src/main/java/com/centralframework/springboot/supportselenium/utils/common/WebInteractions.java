package com.centralframework.springboot.supportselenium.utils.common;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Slf4j
public class WebInteractions {

    static WebDriver driver;

    public static void clickElement(WebElement element){
        element.click();
        log.info("Clicked Element");
    }

    public static void fillTextInElement(WebElement element, String textToFill){
        element.clear();
        element.sendKeys(textToFill);
        log.info("text filled");
    }

    public static String getVisibletextFromElement(WebElement element){
        return  element.getText();
    }
}
