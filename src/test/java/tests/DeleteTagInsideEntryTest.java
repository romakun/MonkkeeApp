package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;


public class DeleteTagInsideEntryTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String newTag = entryData.generateRandomTag();

    @Test
    public void deleteTagInsideEntry() throws IOException {
        loginsteps.logIn("balabama@mailinator.com", "6699273Color");
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
