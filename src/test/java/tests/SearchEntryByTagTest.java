package tests;

import models.RandomEntryData;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;


public class SearchEntryByTagTest extends BaseTest {

    RandomEntryData entryData = new RandomEntryData();
    String headerText = entryData.generateRandomHeader();
    String bodyText = entryData.generateRandomBody();
    String newTag = entryData.generateRandomTag();

    @Test
    public void searchEntriesByTag() throws IOException {
        properties.loadFromXML(Files.newInputStream(path));
        loginsteps.logIn(properties.getProperty("userEmail"),properties.getProperty("userPassword"));
        mainsteps
                .checkOpened()
                .clickCreateEntry();
        entrysteps
                .checkOpened()
                .editEntryText(headerText, bodyText)
                .addNewTag(newTag)
                .goMain();
        mainsteps
                .checkOpened()
                .searchEntryByTag(newTag);
        headersteps.logOut();
    }
}
