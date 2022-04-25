package com.centralframework.springboot.supportselenium.utils.common;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Slf4j
public class Waits {

    static WebDriver driver;

    public static void setImplicitWait(Duration timeout) {
        log.info("Implicit Wait has been set to: " + timeout);
        driver.manage().timeouts().implicitlyWait(timeout);
    }

    public static WebDriverWait getWait(WebDriver driver, Duration timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        return wait;
    }

    public static void WaitForElementClickable(WebDriver driver, WebElement element, Duration timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        log.info("element is clickable now");
    }

    public static boolean waitForElementNotPresent(WebElement element, Duration timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(driver, timeOutInSeconds);
        boolean status = wait.until(ExpectedConditions.invisibilityOf(element));
        log.info("element is invisibile now");
        return status;
    }

    public static void waitForElement(WebElement element, Duration timeOutInSeconds) {
        log.info("waiting for :" + element.toString() + " for :" + timeOutInSeconds + " seconds");
        WebDriverWait wait = getWait(driver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("element is visible now");
    }
}
