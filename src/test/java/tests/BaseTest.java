package tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.LoginSteps;
import steps.MailinatorSteps;
import steps.MainSteps;
import steps.RegistrationSteps;
import tests.base.TestListener;


import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

@Listeners(TestListener.class)
public class BaseTest {

    MailinatorSteps mailinator;
    RegistrationSteps regsteps;
    LoginSteps loginsteps;
    MainSteps mainsteps;

    Properties properties = new Properties();
    Path path = Paths.get("src/test/resources/userData.xml");

    @BeforeClass
    public void setupDriver() {

        //   Configuration.headless = true;
        Configuration.startMaximized = true;
        Configuration.screenshots = true;
        Configuration.clickViaJs = true;
        Configuration.timeout = 6000;
        mailinator = new MailinatorSteps();
        regsteps = new RegistrationSteps();
        loginsteps = new LoginSteps();
        mainsteps = new MainSteps();
    }

}


