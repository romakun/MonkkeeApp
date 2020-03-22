package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.openqa.selenium.By.id;

public class EntryPage extends BasePage {

    private static final String CHANGE_DATE_OR_TIME_CSS = "[title='Change entry date/time']";
    private static final By EDIT_ENTRY_AREA_ID = id("editable");
    private static final String PREVIOUS_ENTRY_BUTTON_CSS = ".icon-chevron-left";
    private static final String NEXT_ENTRY_BUTTON_CSS = ".icon-chevron-right";
    private static final By CKEDITOR_PANEL_ID = id("cke_editable");
    private static final String CKE_BOLD_BUTTON_CSS = (".cke_button__bold_icon");
    private static final String CKE_CLOSE_BUTTON_CSS = (".cke_button__close_icon");
    private static final By HOME_BUTTON_ID = id("back-to-overview");
    private static final By DELETE_ENTRY_BUTTON_ID = id("delete-entry");
    private static final By CREATE_NEW_TAG_INPUT_ID = id("new-tag");
    private static final By CREATE_NEW_TAG_BUTTON_ID = id("assign-new-tag");
    private static final By CHOOSE_TAG_SELECT_ID = id("select-tag");
    private static final By CHOOSE_TAG_BUTTON_ID = id("assign-existing-tag");
    private static final String ASSIGNED_TAGS_BLOCK_CSS = ".assigned-tags";

    @Override
    public EntryPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public EntryPage isPageOpened() {
        $(CHANGE_DATE_OR_TIME_CSS).shouldBe(Condition.visible);
        return this;
    }

    public EntryPage changeEntryText(String headerText, String bodyText){
        $(EDIT_ENTRY_AREA_ID).click();
        $(CKEDITOR_PANEL_ID).shouldBe(Condition.visible);
        $(CKE_BOLD_BUTTON_CSS).click();
        $(EDIT_ENTRY_AREA_ID).sendKeys(headerText);
        $(CKE_BOLD_BUTTON_CSS).click();
        $(EDIT_ENTRY_AREA_ID).sendKeys(Keys.RETURN);
        $(EDIT_ENTRY_AREA_ID).sendKeys(bodyText);
        $(CKE_CLOSE_BUTTON_CSS).click();
        return this;
    }

    public EntryPage addNewTagInEntry(String newTag){
        $(CREATE_NEW_TAG_INPUT_ID).sendKeys(newTag);
        $(CREATE_NEW_TAG_BUTTON_ID).click();
        $(ASSIGNED_TAGS_BLOCK_CSS, "Проверяем есть ли созданный тег в блоке прикрепленных").find(byText(newTag)).shouldBe(Condition.visible);
        return this;
    }

    public EntryPage addExistTagInEntry(String existTag){
        $(CHOOSE_TAG_SELECT_ID).selectOption(existTag);
        $(CHOOSE_TAG_BUTTON_ID).click();
        $(ASSIGNED_TAGS_BLOCK_CSS, "Проверяем есть ли добавленный тег в блоке прикрепленных").find(byText(existTag)).shouldBe(Condition.visible);
        return this;
    }

    public EntryPage deleteEntry(){
        $(DELETE_ENTRY_BUTTON_ID).click();
        switchTo().alert().accept();
        return this;
    }

    public EntryPage goMain(){
        $(HOME_BUTTON_ID).click();
        return this;
    }

    public EntryPage deleteTag(String tag){
        $(ASSIGNED_TAGS_BLOCK_CSS).find(byText(tag)).click();
        $(ASSIGNED_TAGS_BLOCK_CSS).find(byText(tag)).shouldNotBe(Condition.visible);
        return this;
    }
}
