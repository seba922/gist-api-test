package com.git.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:",
        glue = "classpath:",
        tags = {"@gist"}
)
public class CucumberRunner {
}
