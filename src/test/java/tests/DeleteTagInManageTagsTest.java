package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;


public class DeleteTagInManageTagsTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String newTag = entryData.generateRandomTag();

    @Test
    public void deleteTag() throws IOException {
        loginsteps.logIn("balabama@mailinator.com", "6699273Color");
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .addNewTag(newTag)
                .goMain();
        mainsteps.clickManageTagsLink();
        tagsteps
                .checkOpened()
                .deleteTag();
        headersteps.logOut();
    }
}
