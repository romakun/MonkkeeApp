package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import steps.MailinatorSteps;


public class BaseTest {

    MailinatorSteps mailinator;


    @BeforeClass
    public void setupDriver() {

        //   Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        mailinator = new MailinatorSteps();

    }


}
