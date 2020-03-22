package tests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class DeleteEntryInsideTest extends BaseTest{

    int entriesBeforeDeleting;

    @Test
    public void deleteEntryInside() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn("balabama@mailinator.com","6699273Color"/*properties.getProperty("userEmail"),properties.getProperty("userPassword")*/);
        mainsteps
                .checkOpened();
        entriesBeforeDeleting = mainsteps.entriesCount();
        mainsteps.goInEntry(1);
        entrysteps
                .checkOpened()
                .deleteEntryInside();
        mainsteps.entriesCount(entriesBeforeDeleting);
    }
}
