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
        loginsteps.logIn(properties.getProperty("userEmail"),properties.getProperty("userPassword"));
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .checkOpened()
                .addNewTag(newTag)
                .goMain();
        mainsteps
                .checkOpened()
                .clickManageTagsLink();
        tagsteps
                .checkOpened()
                .deleteTag();
        headersteps.logOut();
    }
}
