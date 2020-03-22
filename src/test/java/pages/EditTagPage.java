package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import org.openqa.selenium.By;
import org.testng.Assert;


import static org.openqa.selenium.By.id;

public class EditTagPage extends BasePage {

    private static final String PAGE_HEADER = "h1";
    private static final String PAGE_HEADER_TEXT = "Edit Tag";
    private static final By TAG_NAME_INPUT_ID = id("tag");
    private static final String TAG_COLORS_LOCATOR_CSS = ".col-sm-9";
    private static final String SAVE_BUTTON_CSS = ".btn-text-content";

    @Override
    public EditTagPage openPage() {
        return this;
    }

    @Override
    public EditTagPage isPageOpened() {
        $(PAGE_HEADER).shouldHave(Condition.text(PAGE_HEADER_TEXT));
        return this;
    }

    public EditTagPage chooseTagColor(String colorName){
            try {
                $(TAG_COLORS_LOCATOR_CSS).find(getColor(colorName)).click();
            } catch (ElementNotFound e) {
                Assert.fail("Нет такого цвета");
            }
        return this;
    }

    public void saveEditions(){
        $(SAVE_BUTTON_CSS).click();
    }

    public EditTagPage changeTagName(String newTagName){
        $(TAG_NAME_INPUT_ID).setValue(newTagName);
        return this;
    }


    public String getColor(String colorName){
        switch (colorName) {
            case ("DimGray"):
                return "[style='background-color: rgb(112, 112, 112);']";
            case ("Gold"):
                return "[style='background-color: rgb(255, 204, 0);']";
            case ("DarkOrange"):
                return "[style='background-color: rgb(255, 130, 0);']";
            case ("Crimson"):
                return "[style='background-color: rgb(194, 24, 72);']";
            case ("DarkOrchid"):
                return "[style='background-color: rgb(156, 39, 176);']";
            case ("DodgerBlue"):
                return "[style='background-color: rgb(19, 147, 216);']";
            case ("LimeGreen"):
                return "[style='background-color: rgb(97, 194, 59);']";
            case ("Gray"):
                return "[style='background-color: rgb(146, 112, 96);']";
            case ("Black"):
                return "[style='background-color: rgb(0, 0, 0);']";
            default:
                return null;
        }
    }





}
