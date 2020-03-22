package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import com.codeborne.selenide.ex.ElementShould;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

@Log4j2
public class MainPage extends BasePage {

    private static final By CREATE_ENTRY_BUTTON_ID = id("create-entry");
    private static final By DELETE_ENTRY_BUTTON_ID = id("delete-entries");
    private static final String SELECT_ALL_CHECKBOX_CSS = "[title='Select all']";
    private static final String ENTRY_CHECKBOX_LOCATOR_CSS = "[ng-change='updateSelectionState()']";
    private static final String ENTRY_LOCATOR_CSS = ".entry";
    private static final String MANAGE_TAGS_LINK_TEXT = "Manage tags";
    private static final By SEARCH_INPUT_ID = id("appendedInputButton");
    private static final String SEARCH_BUTTON_CSS = "[title='Search']";
    private static final String NO_ENTRIES_FOUND_MESSAGE = "No entries found";
    private static final String ENTRY_BODY_TEXT_CSS = ".body ";
    private static final String ENTRY_TITLE_TEXT_CSS = ".title ";
    private static final By TAGS_SECTION_ID = id("tags");
    private static final String TAG_IN_ENTRY_CSS = "[ng-repeat='tag in entry.tags']";


    //CALENDAR LOCATORS
    private static final By CALENDAR_INPUT_ID = id("datepicker");
    private static final String CALENDAR_DAYS_PREV_CSS = ".datepicker-days .prev";
    private static final String CALENDAR_DAYS_NEXT_CSS = ".datepicker-days .next";
    private static final String CALENDAR_SWITCH_TO_MONTHS_CSS = ".datepicker-days .switch";
    private static final String CALENDAR_MONTHS_PREV_CSS = ".datepicker-months .prev";
    private static final String CALENDAR_MONTHS_NEXT_CSS = ".datepicker-months .next";
    private static final String CALENDAR_SWITCH_TO_YEARS_CSS = ".datepicker-months .switch";
    private static final String CALENDAR_YEARS_PREV_CSS = ".datepicker-years .prev";
    private static final String CALENDAR_YEARS_NEXT_CSS = ".datepicker-years .next";
    private static final By CALENDAR_ACTIVE_DAY_LOCATOR = xpath("//td[contains(@class='day') and contains(text(),'18')]");
    private static final By CALENDAR_MONTH_LOCATOR = xpath("//span[contains(@class,'month') and contains(text(),'2021')]");
    private static final By CALENDAR_YEAR_LOCATOR = xpath("//span[contains(@class,'year') and contains(text(),'2021')]");

    @Override
    public MainPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    public MainPage isPageOpened() {
        $(CREATE_ENTRY_BUTTON_ID).shouldBe(Condition.visible);
        return this;
    }

    public MainPage goInEntry(int elementNumber) {
        if ($$(ENTRY_LOCATOR_CSS).size() > 0) {
            List<SelenideElement> entries = $$(ENTRY_LOCATOR_CSS);
            entries.get(elementNumber - 1).click();
        } else {
            Assert.fail("Невозможно перейти в запись, т.к. её нет");
        }
        return this;
    }

    public void clickCreateEntryButton() {
        $(CREATE_ENTRY_BUTTON_ID, "Жмем на кнопку создания записи").click();
    }

    public void clickManageTagsLink() {
        $(byText(MANAGE_TAGS_LINK_TEXT), "Жмем на сссылку редактирования тегов").click();
    }

    public MainPage deleteAllEntries() {
        if ($$(ENTRY_LOCATOR_CSS).size() > 0) {
            $(SELECT_ALL_CHECKBOX_CSS, "Жмем на чекбокc выделения всех записей").click();
            deleteEntry();
            $$(ENTRY_LOCATOR_CSS).shouldHaveSize(0);
            $(byText(NO_ENTRIES_FOUND_MESSAGE)).shouldBe(Condition.visible);
        } else {
            Assert.fail("Невозможно удалить записи, т.к. их нет");
        }

        return this;
    }

    public MainPage deleteOneEntry(int elementNumber) {
        if ($$(ENTRY_LOCATOR_CSS).size() > 0) {
            int entryCountBeforeDeleting = $$(ENTRY_LOCATOR_CSS).size();
            List<SelenideElement> entryCheckboxes = $$(ENTRY_CHECKBOX_LOCATOR_CSS);
            entryCheckboxes.get(elementNumber - 1).click();
            deleteEntry();
            $$(ENTRY_LOCATOR_CSS).shouldHaveSize(entryCountBeforeDeleting - 1);
        } else {
            Assert.fail("Невозможно удалить записи, т.к. их нет");
        }
        return this;
    }

    public void deleteEntry() {
        $(DELETE_ENTRY_BUTTON_ID, "Жмем на кнопку удаления записей").click();
        switchTo().alert().accept();
    }

    public MainPage searchEntryByText(String text) {
        $(SEARCH_INPUT_ID).setValue(text);
        $(SEARCH_BUTTON_CSS).click();
        try {
            List<SelenideElement> entries = $$(ENTRY_LOCATOR_CSS);
            for (int i = 0; i < entries.size(); i++) {
                try {
                    entries.get(i).find(ENTRY_TITLE_TEXT_CSS).shouldHave(Condition.matchesText(text));
                } catch (ElementShould e) {
                    try {
                        entries.get(i).find(ENTRY_BODY_TEXT_CSS).shouldHave(Condition.matchesText(text));
                    } catch (ElementShould e1) {
                        Assert.fail("Нет записей с таким текстом");
                    }
                }
            }
        } catch (ElementNotFound e) {
            Assert.fail("Не найдено ни одной записи с таким текстом");
        }
        return this;
    }

    public MainPage searchEntryByTag(String tagName) {
        $(TAGS_SECTION_ID).find(withText(tagName)).click();
        try {
            List<SelenideElement> entries = $$(ENTRY_LOCATOR_CSS);
            for (int i = 0; i < entries.size(); i++) {
                try {
                    entries.get(i).find(TAG_IN_ENTRY_CSS).shouldHave(Condition.matchesText(tagName));
                } catch (ElementShould e) {
                    Assert.fail("У найденных записей не верный тег");
                }
            }
        } catch (ElementNotFound e) {
            Assert.fail("Не найдено ни одной записи с таким тегом");
        }
        return this;
    }

    public MainPage checkEntryCountWithTag(String tagName) {
        String tagText = $(TAGS_SECTION_ID).find(withText(tagName)).getText();
        String[] text = tagText.split(" ");
        int lastElement = text.length - 1;
        int entriesCountWithTag = Integer.parseInt(text[lastElement].replaceAll("[^0-9]", ""));
        try {
            $$(ENTRY_LOCATOR_CSS).shouldHaveSize(entriesCountWithTag);
        } catch (ElementShould e) {
            Assert.fail("Количество записей не соответсвует счетчику тега");
        }
        return this;
    }
}
