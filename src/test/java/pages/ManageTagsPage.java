package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import org.testng.Assert;
import utils.ColorUtils;


import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

public class ManageTagsPage extends BasePage {

    private static final String URL = "https://my.monkkee.com/#/tags";
    private static final String PAGE_HEADER = "h1";
    private static final String PAGE_HEADER_TEXT = "Manage Tags";
    private static final String TAG_LOCATOR_CSS = "[ng-repeat='tag in tags']";
    private static final String EDIT_TAG_BUTTON_CSS = ".icon-plus";
    private static final String DELETE_TAG_BUTTON_CSS = ".icon-trash";
    private static final String TAG_NAME_CSS = ".tag.ng-binding";


    @Override
    public ManageTagsPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public ManageTagsPage isPageOpened() {
        $(PAGE_HEADER).shouldHave(Condition.text(PAGE_HEADER_TEXT));
        return this;
    }

    public ManageTagsPage deleteTag() {
        try {
            String tagName = $$(TAG_LOCATOR_CSS, 0).getText();
            $$(TAG_LOCATOR_CSS, 0).find(DELETE_TAG_BUTTON_CSS).click();
            switchTo().alert().accept();
            $(TAG_LOCATOR_CSS).find(byText(tagName)).shouldNotBe(Condition.visible);
            return this;
        } catch (IndexOutOfBoundsException e) {
            Assert.fail("У данного пользователя нет ни одного тега");
            return null;
        }
    }

    public void goToTagEdit() {
        $$(TAG_LOCATOR_CSS, 0).find(EDIT_TAG_BUTTON_CSS).click();
    }

    public ManageTagsPage checkTagColor(String colorName, String tagName) {
        ColorUtils color = new ColorUtils();
        String[] style = selectTag(tagName).find(TAG_NAME_CSS).getAttribute("style").split(";");
        String elementStyle = style[0].replaceAll("[^0-9,]", "");
        String[] rgb = elementStyle.split(",");
        int[] RGB = new int[3];
        for (int i = 0; i < RGB.length; i++) {
            RGB[i] = Integer.parseInt(rgb[i]);
        }
        if (color.getColorNameFromRgb(RGB[0], RGB[1], RGB[2]).equals(colorName)) {
            return this;
        } else {
            Assert.fail("Цвет не изменился");
            return null;
        }
    }

    public ManageTagsPage checkTagName(String tagName){
        try {
            $(byText(tagName));
        } catch (ElementNotFound e) {
            Assert.fail("Тега с таким именем нет");
        }

        return this;
    }

    public SelenideElement selectTag(String tagName){
        List<SelenideElement> tagList = $$(TAG_LOCATOR_CSS);
        SelenideElement element = null;
        for(int i = 0; i < tagList.size(); i++){
            if(tagList.get(i).find(TAG_NAME_CSS).getText().equals(tagName)) {
                element = tagList.get(i);
            }
        }
        return element;
    }
}
