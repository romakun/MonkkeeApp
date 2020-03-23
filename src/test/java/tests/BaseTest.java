package tests;

import com.codeborne.selenide.Configuration;
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
        Configuration.startMaximized = true;
        Configuration.clickViaJs = true;
        Configuration.screenshots = true;
        Configuration.timeout = 8000;
        mailinator = new MailinatorSteps();
        regsteps = new RegistrationSteps();
        loginsteps = new LoginSteps();
        mainsteps = new MainSteps();
        entrysteps = new EntrySteps();
        tagsteps = new ManageTagSteps();
        edittagsteps = new EditTagSteps();
        headersteps = new HeaderSteps();
    }
}


