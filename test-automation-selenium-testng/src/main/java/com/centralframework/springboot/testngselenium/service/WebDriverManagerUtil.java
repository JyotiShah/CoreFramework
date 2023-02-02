package com.centralframework.springboot.testngselenium.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;
import java.util.Optional;

@Slf4j
public class WebDriverManagerUtil {
    WebDriver driver;

    public WebDriver getWebDriver(){
        String browser = Optional.ofNullable(System.getProperty("browser.name")).orElse("chrome");
        switch (browser.toLowerCase(Locale.ROOT)){
            case "chrome" :
                driver = getChromeDriver();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browser.toLowerCase(Locale.ROOT));
        }
        return driver;
    }

    private WebDriver getChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        String env = Optional.ofNullable(System.getProperty("spring.profiles.active")).orElse("uat");
        log.info("Envrionment - " + env);
        options.addArguments("--no-sandbox"); // Bypass OS security model, MUST BE THE VERY FIRST OPTION
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");

        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        log.info("Launching URL " );
        return driver;
    }


}
