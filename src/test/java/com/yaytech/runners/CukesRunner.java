package com.yaytech.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
               // "pretty",
        "html:target/default-report/1.html",
        "rerun:target/failed.txt"
        },
        features = "src/test/resources/features",
        glue = "com/yaytech/stepdefinitions",
        dryRun = false,
        tags = "@login and @l1"
)
public class CukesRunner {
}
