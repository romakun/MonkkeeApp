package tests;

import models.RandomUserData;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class RegistrationTest extends BaseTest {

    @BeforeTest
    public void generateNewUserData() throws IOException {
        RandomUserData userData = new RandomUserData();

        properties.setProperty("userEmail", userData.generateRandomEmail());
        properties.setProperty("userPassword", userData.generateRandomPassword());
        properties.storeToXML(Files.newOutputStream(path), "file with new user data");
    }

    @Test
    public void registrationTest() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        regsteps
                .openRegistrationPage()
                .fillInRegistrationData(properties.getProperty("userEmail"), properties.getProperty("userPassword"))
                .checkRegResult();
    }
}
