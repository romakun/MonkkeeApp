package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;
import static org.openqa.selenium.By.xpath;

public class MainPage extends BasePage {

    private static final By CREATE_ENTRY_BUTTON_ID = id("create-entry");
    private static final By DELETE_ENTRY_BUTTON_ID = id("delete-entries");
    private static final String SELECT_ALL_CHECKBOX_CSS = "[title='Select all']";
    private static final String ENTRY_CHECKBOX_LOCATOR_CSS = "[ng-change='updateSelectionState()']";
    private static final String ENTRY_LOCATOR_CSS = ".entry";
    private static final String MANAGE_TAGS_LINK_TEXT = "Manage tags";
    private static final By SEARCH_INPUT_ID = id("appendedInputButton");
    private static final String SEARCH_BUTTON_CSS = "[title='Search']";

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

    public MainPage goInEntry(){
        return this;
    }

    public void clickCreateEntryButton(){
        $(CREATE_ENTRY_BUTTON_ID,"Жмем на кнопку создания записи").click();
    }

    public void clickManageTagsLink(){
        $(byText(MANAGE_TAGS_LINK_TEXT), "Жмем на сссылку редактирования тегов").click();
    }

    public MainPage deleteAllEntries(){
        $(SELECT_ALL_CHECKBOX_CSS, "Жмем на чекбокc выделения всех записей").click();
        $(DELETE_ENTRY_BUTTON_ID, "Жмем на кнопку удаления записей").click();
        switchTo().alert().accept();
        $$(ENTRY_LOCATOR_CSS).shouldHaveSize(0);
        return this;
    }

}
