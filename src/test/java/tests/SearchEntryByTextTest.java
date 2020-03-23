package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class SearchEntryByTextTest extends BaseTest {

    String searchedText = "d";

    @Test
    public void searchEntryByText() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn("balabama@mailinator.com","6699273Color"/*properties.getProperty("userEmail"),properties.getProperty("userPassword")*/);
        mainsteps
                .checkOpened()
                .searchEntryByText(searchedText);
    }
}
