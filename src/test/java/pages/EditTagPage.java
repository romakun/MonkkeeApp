package pages;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
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
        try {
            $(PAGE_HEADER, "По этому элементу определяем, что страница загрузилась " + PAGE_HEADER_TEXT).shouldHave(Condition.text(PAGE_HEADER_TEXT));
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public EditTagPage chooseTagColor(String colorName) {
        try {
            $(TAG_COLORS_LOCATOR_CSS, "Выбираем цвет для тега " + getColor(colorName)).find(getColor(colorName)).click();
        } catch (ElementNotFound e) {
            Assert.fail("Нет такого цвета " + getColor(colorName));
        }
        return this;
    }

    public void saveEditions() {
        try {
            $(SAVE_BUTTON_CSS, "Жмем на кнопку сохранения тега").click();
        } catch (ElementNotFound e) {
            Assert.fail("Не получилось нажать на кнопку " + SAVE_BUTTON_CSS);
        }
    }

    public EditTagPage changeTagName(String newTagName) {
        try {
            $(TAG_NAME_INPUT_ID, "Вводим новое название тега - " + newTagName).setValue(newTagName);
            return this;
        } catch (ElementNotFound e) {
            Assert.fail("Инпут не найден " + TAG_NAME_INPUT_ID);
            return null;
        } catch (InvalidElementStateException e1) {
            Assert.fail("В данный элемент нельзя вводить текст " + TAG_NAME_INPUT_ID);
            return null;
        }
    }


    public String getColor(String colorName) {
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
