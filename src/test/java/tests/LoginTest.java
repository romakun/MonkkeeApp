package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class LoginTest extends BaseTest {

    @Test
    public void logInMonkkeeAppTest() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn(properties.getProperty("userEmail"),properties.getProperty("userPassword"));
        mainsteps.checkOpened();
    }
}
