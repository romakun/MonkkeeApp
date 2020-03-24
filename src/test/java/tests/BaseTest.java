package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import steps.*;
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
    EntrySteps entrysteps;
    ManageTagSteps tagsteps;
    EditTagSteps edittagsteps;
    HeaderSteps headersteps;

    Properties properties = new Properties();
    Path path = Paths.get("src/test/resources/userData.xml");

    @BeforeClass
    public void setupDriver() {

        Configuration.headless = true;
        Configuration.browserSize = "1920x1080";
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        Configuration.timeout = 6000;
        mailinator = new MailinatorSteps();
        regsteps = new RegistrationSteps();
        loginsteps = new LoginSteps();
        mainsteps = new MainSteps();
        entrysteps = new EntrySteps();
        tagsteps = new ManageTagSteps();
        edittagsteps = new EditTagSteps();
        headersteps = new HeaderSteps();
    }

    @AfterClass
    public void closeDriver() {
        WebDriverRunner.closeWebDriver();
    }
}


