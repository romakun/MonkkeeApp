package steps;

import io.qameta.allure.Step;
import pages.EditTagPage;

public class EditTagSteps {

    EditTagPage page;


    public EditTagSteps() {
        page = new EditTagPage();
    }

    @Step("check page opened")
    public EditTagSteps checkOpened() {
        page.isPageOpened();
        return this;
    }

    @Step("choose new tag color - '{colorName}'")
    public EditTagSteps chooseNewTagColor(String colorName) {
        page.chooseTagColor(colorName);
        return this;
    }

    @Step("Save changes")
    public void saveChanges() {
        page.saveEditions();
    }

    @Step("Change tag name")
    public EditTagSteps changeTagName(String newTagName){
        page.changeTagName(newTagName);
        return this;
    }
}
