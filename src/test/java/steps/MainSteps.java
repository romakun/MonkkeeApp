package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    MainPage page;

    public MainSteps() {
        page = new MainPage();
    }

    @Step("Check main page opened")
    public MainSteps checkOpened() {
        page.isPageOpened();
        return this;
    }

    @Step("Delete all entries")
    public MainSteps deleteAllEntries() {
        page.deleteAllEntries();
        return this;
    }

    @Step("Delete one entry by number '{elementNumber}'")
    public MainSteps deleteOneEntry(int elementNumber) {
        page.deleteOneEntry(elementNumber);
        return this;
    }

    @Step("Go in entry by number '{elementNumber}'")
    public MainSteps goInEntry(int elementNumber) {
        page.goInEntry(elementNumber);
        return this;
    }

    @Step("Click create entry button")
    public MainSteps clickCreateEntry() {
        page.clickCreateEntryButton();
        return this;
    }

    @Step("Go to manage tags page")
    public MainSteps clickManageTagsLink() {
        page.clickManageTagsLink();
        return this;
    }

    @Step("Search entry by header text '{text}'")
    public MainSteps searchEntryByHeaderText(String text){
        page.searchEntryByHeaderText(text);
        return this;
    }

    @Step("Search entry by body text '{text}'")
    public MainSteps searchEntryByBodyText(String text){
        page.searchEntryByBodyText(text);
        return this;
    }


    @Step("Search entry by tag '{text}'")
    public MainSteps searchEntryByTag(String text){
        page
                .searchEntryByTag(text)
                .checkEntryCountWithTag(text);
        return this;
    }

    @Step("Check created entry by Header - '{headerText}', text - '{bodyText}' and tag - '{tagName}'")
    public MainSteps checkAddedEntryByData(String headerText, String bodyText, String tagName){
        page.checkEntryAdded(headerText, bodyText, tagName);
        return this;
    }

    @Step("Return entries count")
    public int entriesCount(){
        return page.checkEntriesCount();
    }

    @Step("Compare entries count before and after deleting")
    public MainSteps entriesCount(int entriesBeforeDeleting){
        page.checkEntriesCount(entriesBeforeDeleting);
        return this;
    }

    @Step("Check lack of entries with deleting tag")
    public MainSteps checkLackOfEntries(){
        page.checkLackOfEntries();
        return this;
    }

    @Step("Open main page")
    public MainSteps openPage(){
        page.openPage();
        return this;
    }
}
