package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class DeleteOneEntryTest extends BaseTest {

    int entryNumber = 2;

    @Test
    public void deleteEntry() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn("balabama@mailinator.com","6699273Color"/*properties.getProperty("userEmail"),properties.getProperty("userPassword")*/);
        mainsteps
                .checkOpened()
                .deleteOneEntry(entryNumber);
    }
}
