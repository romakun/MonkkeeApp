package steps;

import io.qameta.allure.Step;
import pages.ManageTagsPage;

public class ManageTagSteps {

    ManageTagsPage page;

    public ManageTagSteps() {page = new ManageTagsPage();}


    @Step("Check Manage tag page opened")
    public ManageTagSteps checkOpened(){
        page.isPageOpened();
        return this;
    }

    @Step("Delete first tag in list")
    public ManageTagSteps deleteTag(){
        page.deleteTag();
        return this;
    }

    @Step("Go to tag editor page")
    public void goToTagEdit(){
        page.goToTagEdit();
    }

    @Step("Check color editions int tag '{tagName}', expected color - '{colorName}'")
    public ManageTagSteps checkColor(String colorName, String tagName){
        page.checkTagColor(colorName, tagName);
        return this;
    }

    @Step("Check new tag name - '{tagName}'")
    public ManageTagSteps checkTagName(String tagName){
        page.checkTagName(tagName);
        return this;
    }
}
