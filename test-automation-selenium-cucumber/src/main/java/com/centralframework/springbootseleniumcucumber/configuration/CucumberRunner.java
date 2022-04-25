package com.centralframework.springbootseleniumcucumber.configuration;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "classpath:features",
        glue = {"com.demo.project.name.stepDefinitions"
                , "com.centralframework.springbootseleniumcucumber.configuration"
                , "com.centralframework.springbootseleniumcucumber.hooks"},
        plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "rerun:target/cucumber-reports/rerun.txt"
        })
public class CucumberRunner {

}
