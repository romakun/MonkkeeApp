package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class DeleteAllEntriesTest extends BaseTest {

    @Test
    public void deleteAllEntries() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn(properties.getProperty("userEmail"),properties.getProperty("userPassword"));
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .checkOpened()
                .goMain();
        mainsteps
                .checkOpened()
                .deleteAllEntries();
        headersteps.logOut();
    }
}
