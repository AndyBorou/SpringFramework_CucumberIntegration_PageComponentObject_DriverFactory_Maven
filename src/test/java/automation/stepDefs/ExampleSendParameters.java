package automation.stepDefs;

import automation.example.spring.ApplicationConfig;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

//@ContextConfiguration(classes = ApplicationConfig.class)
public class ExampleSendParameters {

    private String today;

    @Given("today is {string}")
    public void today_is(String today) {
        this.today = today;
    }

    @Given("I ask whether it's Friday yet")
    public void i_ask_whether_its_Friday_yet() {
        this.today = today;
    }

    @Then("I should be told {string}")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, "TGIF");
    }
}
