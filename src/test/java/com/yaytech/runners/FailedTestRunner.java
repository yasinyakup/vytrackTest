package com.yaytech.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = "html:target/failed-report/2.html",
        features = "@target/failed.txt",
        glue = "com/yaytech/stepdefinitions"
)
public class FailedTestRunner {
}
