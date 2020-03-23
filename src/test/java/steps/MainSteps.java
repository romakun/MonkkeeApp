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

    @Step("Search entry by text '{text}'")
    public MainSteps searchEntryByText(String text){
        page.searchEntryByText(text);
        return this;
    }

    @Step("Search entry by tag '{text}'")
    public MainSteps searchEntryByTag(String text){
        page
                .searchEntryByTag(text)
                .checkEntryCountWithTag(text);
        return this;
    }


}
