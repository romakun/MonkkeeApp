package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;


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
