package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class DeleteTagInsideEntryTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String newTag = entryData.generateRandomTag();

    @Test
    public void deleteTagInsideEntry() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn("balabama@mailinator.com", "6699273Color"/*properties.getProperty("userEmail"),properties.getProperty("userPassword")*/);
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .addNewTag(newTag)
                .goMain();
        mainsteps
                .searchEntryByTag(newTag)
                .goInEntry(1);
        entrysteps
                .deleteTag(newTag)
                .goMain();
        mainsteps
                .searchEntryByTag(newTag)
                .checkLackOfEntries();
        headersteps.logOut();
    }
}
