package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class SearchEntryByTagTest extends BaseTest {

    String tagName = "buratino";

    @Test
    public void searchEntriesByTag() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn("balabama@mailinator.com","6699273Color"/*properties.getProperty("userEmail"),properties.getProperty("userPassword")*/);
        mainsteps
                .checkOpened()
                .searchEntryByTag(tagName);
    }
}
