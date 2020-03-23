package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.openqa.selenium.By.id;

public class EntryPage extends BasePage {

    private static final String CHANGE_DATE_OR_TIME_CSS = "[title='Change entry date/time']";
    private static final By EDIT_ENTRY_AREA_ID = id("editable");
    private static final By CKE_PANEL_ID = id("cke_editable");
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
        try {
            $(CHANGE_DATE_OR_TIME_CSS, "Ждем, пока страница загрузится").shouldBe(Condition.visible);
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница по какой-то причине не загрузилась");
            return null;
        }
    }

    public EntryPage changeEntryText(String headerText, String bodyText){
        $(EDIT_ENTRY_AREA_ID, "Кликаем по области редактирования записи").click();
        $(CKE_PANEL_ID, "Ждем покая появится панель ckeditor").shouldBe(Condition.visible);
        $(CKE_BOLD_BUTTON_CSS, "Активируем кнопку bold на панели cke").click();
        $(EDIT_ENTRY_AREA_ID, "Вводим заголовок записи - " + headerText).sendKeys(headerText);
        $(CKE_BOLD_BUTTON_CSS, "Деактивируем кнопку bold на панели cke").click();
        $(EDIT_ENTRY_AREA_ID, "Переводим текстовый курсор на новую строку").sendKeys(Keys.RETURN);
        $(EDIT_ENTRY_AREA_ID, "Вводим текст в тело записи - " + bodyText).sendKeys(bodyText);
        $(CKE_CLOSE_BUTTON_CSS, "Закрываем панель cke").click();
        return this;
    }

    public EntryPage addNewTagInEntry(String newTag){
        $(CREATE_NEW_TAG_INPUT_ID, "Вводим имя нового тега в поле - " + newTag).sendKeys(newTag);
        sleep(1000);
        $(CREATE_NEW_TAG_BUTTON_ID, "Сохраняем новый тег").click();
        sleep(1000);
        $(ASSIGNED_TAGS_BLOCK_CSS, "Проверяем есть ли созданный тег в блоке прикрепленных").find(byText(newTag)).shouldBe(Condition.visible);
        return this;
    }

    public EntryPage addExistTagInEntry(String existTag){
        $(CHOOSE_TAG_SELECT_ID, "Выбираем тег из списка существующих").selectOption(existTag);
        $(CHOOSE_TAG_BUTTON_ID, "Добавляем тег в запись").click();
        $(ASSIGNED_TAGS_BLOCK_CSS, "Проверяем есть ли добавленный тег в блоке прикрепленных").find(byText(existTag)).shouldBe(Condition.visible);
        return this;
    }

    public EntryPage deleteEntry(){
        $(DELETE_ENTRY_BUTTON_ID, "Жмем на кнопку удаления записи").click();
        switchTo().alert().accept();
        return this;
    }

    public EntryPage goMain(){
        $(HOME_BUTTON_ID, "Жмем на кнопку перехода на главную страницу").click();
        sleep(2000);
        return this;
    }

    public EntryPage deleteTag(String tag){
        $(ASSIGNED_TAGS_BLOCK_CSS, "Ищем тег добавленный в запись и удаляем его").find(byText(tag)).click();
        $(ASSIGNED_TAGS_BLOCK_CSS, "Проверяем, что тег удален").find(byText(tag)).shouldNotBe(Condition.visible);
        return this;
    }
}
