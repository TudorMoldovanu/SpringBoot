package com.ea.SpringBasic.runner;

import io.cucumber.testng.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@CucumberOptions(
        features = {"src/test/java/com/ea/SpringBasic/features"},
        plugin = {"json:target/cucumber.json", "pretty"},
        glue = "com.ea.SpringBasic.steps"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    //Single execution
    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
