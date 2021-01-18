package automation.cucumberRunner;

import automation.example.framework.driver.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.event.annotation.AfterTestClass;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/itemSearch",
        glue = {"automation/stepDefs"}
)
//http://automationpractice.com/index.php
@Component
public class  CucumberRunner {

    @AfterTestClass
    @AfterClass
    public static void driverQiute(){
        new DriverProvider().getInstance().quit();

    }
}
