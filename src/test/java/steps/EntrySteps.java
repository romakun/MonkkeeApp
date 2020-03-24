package steps;

import io.qameta.allure.Step;
import pages.EntryPage;

public class EntrySteps {

    EntryPage page;

    public EntrySteps() { page = new EntryPage();}

    @Step("Check Entry page opened")
    public EntrySteps checkOpened(){
        page.isPageOpened();
        return this;
    }

    @Step("Edit entry text, Header='{headerText}' Text='{bodyText}'")
    public EntrySteps editEntryText(String headerText, String bodyText){
        page.changeEntryText(headerText, bodyText);
        return this;
    }

    @Step("Add new tag - '{newTag}' in entry")
    public EntrySteps addNewTag(String newTag){
        page.addNewTagInEntry(newTag);
        return this;
    }

    @Step("Add existing tag in entry")
    public EntrySteps addTag(String existTag){
        page.addExistTagInEntry(existTag);
        return this;
    }

    @Step("Go to main page")
    public void goMain(){
        page.goMain();
    }

    @Step("Delete entry by button inside")
    public void deleteEntryInside(){
        page.deleteEntry();
    }

    @Step("Delete tag - '{tagName}' in entry")
    public EntrySteps deleteTag(String tagName){
        page.deleteTag(tagName);
        return this;
    }
}
