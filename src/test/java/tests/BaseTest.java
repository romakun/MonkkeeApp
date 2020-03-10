package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import steps.LoginSteps;
import steps.MoodSteps;

public class BaseTest {

    LoginSteps loginSteps;
    MoodSteps moodSteps;

    @BeforeClass
    public void setupDriver(){

     //   Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        loginSteps = new LoginSteps();
        moodSteps = new MoodSteps();
    }
}
