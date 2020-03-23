package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class EditTagTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String newTag = entryData.generateRandomTag();
    String newTagName = entryData.generateRandomTag();

    String[] colors = new String[]{
            "DimGray",
            "Gold",
            "DarkOrange",
            "Crimson",
            "DarkOrchid",
            "DodgerBlue",
            "LimeGreen",
            "Gray",
            "Black"
    };

    @Test
    public void editTag() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn(properties.getProperty("userEmail"),properties.getProperty("userPassword"));
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .addNewTag(newTag)
                .goMain();
        mainsteps.clickManageTagsLink();
        tagsteps
                .checkOpened()
                .goToTagEdit();
        edittagsteps
                .checkOpened()
                .changeTagName(newTagName)
                .chooseNewTagColor(colors[4])
                .saveChanges();
        tagsteps
                .checkOpened()
                .checkTagName(newTagName)
                .checkColor(colors[4], newTagName);
        headersteps.logOut();
    }
}
