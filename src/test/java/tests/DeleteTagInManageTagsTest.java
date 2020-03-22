package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;

public class DeleteTagInManageTagsTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String newTag = entryData.generateRandomTag();

    @Test
    public void deleteTag() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn("balabama@mailinator.com","6699273Color"/*properties.getProperty("userEmail"),properties.getProperty("userPassword")*/);
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
    }
}