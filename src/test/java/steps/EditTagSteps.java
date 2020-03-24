package steps;

import io.qameta.allure.Step;
import pages.EditTagPage;

public class EditTagSteps {

    EditTagPage page;


    public EditTagSteps() {
        page = new EditTagPage();
    }

    @Step("Check edit tag page opened")
    public EditTagSteps checkOpened() {
        page.isPageOpened();
        return this;
    }

    @Step("Choose new tag color - '{colorName}'")
    public EditTagSteps chooseNewTagColor(String colorName) {
        page.chooseTagColor(colorName);
        return this;
    }

    @Step("Save tag changes")
    public void saveChanges() {
        page.saveEditions();
    }

    @Step("Change tag name to '{newTagName}'")
    public EditTagSteps changeTagName(String newTagName){
        page.changeTagName(newTagName);
        return this;
    }
}
