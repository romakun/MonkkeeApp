package pages;

import com.codeborne.selenide.Condition;

import com.codeborne.selenide.Selenide;
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
    private static final By RESET_SEARCH_LINK = id("reset-search");

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
        try {
            Selenide.$(CREATE_ENTRY_BUTTON_ID).waitUntil(Condition.visible, 5000);
            Selenide.$(TAGS_SECTION_ID).waitUntil(Condition.visible, 2000);
            Selenide.$(byText(MANAGE_TAGS_LINK_TEXT)).waitUntil(Condition.visible, 2000);
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public MainPage goInEntry(int elementNumber) {
        if ($$(ENTRY_LOCATOR_CSS, "Проверяем, что количество записей на странице больше 0").size() > 0) {
            List<SelenideElement> entries = $$(ENTRY_LOCATOR_CSS, "Добавляем все записи в лист");
            log.info("Переходим в выбранную запись - " + elementNumber);
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
        if ($$(ENTRY_LOCATOR_CSS, "Проверяем, что количество записей на странице больше 0").size() > 0) {
            $(SELECT_ALL_CHECKBOX_CSS, "Жмем на чекбокc выделения всех записей").click();
            deleteEntry();
//            sleep(2000);
            $$(ENTRY_LOCATOR_CSS, "Проверяем, что не осталось ни одной записи на странице").shouldHaveSize(0);
            $(byText(NO_ENTRIES_FOUND_MESSAGE), "Проверяем, что присутсвутет текст, говорящий о том, что записей нет - " + NO_ENTRIES_FOUND_MESSAGE).shouldBe(Condition.visible);
        } else {
            Assert.fail("Невозможно удалить записи, т.к. их нет");
        }
        return this;
    }

    public MainPage deleteOneEntry(int elementNumber) {
        if ($$(ENTRY_LOCATOR_CSS, "Проверяем, что количество записей на странице больше 0").size() > 0) {
            int entryCountBeforeDeleting = $$(ENTRY_LOCATOR_CSS, "Записываем количество записей").size();
            List<SelenideElement> entryCheckboxes = $$(ENTRY_CHECKBOX_LOCATOR_CSS, "Создаем лист чекбоксов записей");
            log.info("Выделяем запись активаровав чекбокс");
            entryCheckboxes.get(elementNumber - 1).click();
            deleteEntry();
            log.info("Удаляем выделенную запись");

//            sleep(2000);
            $$(ENTRY_LOCATOR_CSS, "Сравниваем количество записей до и после удаления").shouldHaveSize(entryCountBeforeDeleting - 1);
        } else {
            Assert.fail("Невозможно удалить записи, т.к. их нет");
        }
        return this;
    }

    public void deleteEntry() {
        $(DELETE_ENTRY_BUTTON_ID, "Жмем на кнопку удаления записей").click();
        switchTo().alert().accept();
        $(DELETE_ENTRY_BUTTON_ID).waitUntil(Condition.disabled, 6000);
    }

    public MainPage searchEntryByText(String text) {
        $(SEARCH_INPUT_ID, "Воодим текс в поле поиска").setValue(text);
        $(SEARCH_BUTTON_CSS, "Нажимаем кнопку поиска").click();
        $(RESET_SEARCH_LINK).waitUntil(Condition.visible, 5000);
        try {
            List<SelenideElement> entries = $$(ENTRY_LOCATOR_CSS, "Создаем лист записей");
            for (int i = 0; i < entries.size(); i++) {
                try {
                    $$(ENTRY_LOCATOR_CSS, i, "Пытаемся найти текст - '" + text + "' в заголовке записи").find(ENTRY_TITLE_TEXT_CSS).shouldHave(Condition.matchesText(text));
                } catch (ElementShould e) {
                    try {
                        $$(ENTRY_LOCATOR_CSS, i, "Пытаемся найти текст - '" + text + "' в теле записи").find(ENTRY_BODY_TEXT_CSS).shouldHave(Condition.matchesText(text));
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
        $(TAGS_SECTION_ID).shouldBe(Condition.visible);
        $(TAGS_SECTION_ID, "Нажимаем на тег, по которому хотим искать записи").find(withText(tagName)).click();
//            sleep(3000);
        $(RESET_SEARCH_LINK).shouldBe(Condition.visible);
        try {
            List<SelenideElement> entries = $$(ENTRY_LOCATOR_CSS, "Создаем лист записей");
            for (int i = 0; i < entries.size(); i++) {
                try {
                    $$(ENTRY_LOCATOR_CSS, i, "Пытаемся найти тег - '" + tagName + "' в записи").find(TAG_IN_ENTRY_CSS).shouldHave(Condition.matchesText(tagName));
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
        String tagText = $(TAGS_SECTION_ID, "Записываем тег из блока").find(withText(tagName)).getText();
        log.info("Сплитаем записанный тег, чтобы вытянуть его счетчик");
        String[] text = tagText.split(" ");
        int lastElement = text.length - 1;
        int entriesCountWithTag = Integer.parseInt(text[lastElement].replaceAll("[^0-9]", ""));
        try {
            $$(ENTRY_LOCATOR_CSS, "Проверяем, что количество записей равно счетчику тега - " + entriesCountWithTag).shouldHaveSize(entriesCountWithTag);
        } catch (ElementShould e) {
            Assert.fail("Количество записей не соответсвует счетчику тега");
        }
        return this;
    }

    public MainPage checkEntryAdded(String headerText, String bodyText, String tagName) {
        try {
            List<SelenideElement> entries = $$(ENTRY_LOCATOR_CSS, "Создаем список записей");
            for (int i = 0; i < entries.size(); i++) {
                if (i < entries.size()) {
                    try {
                        $$(ENTRY_LOCATOR_CSS, i, "Ищем совпадение заголовка записи с заголовком - " + headerText).find(ENTRY_TITLE_TEXT_CSS).shouldHave(Condition.matchesText(headerText));
                        $$(ENTRY_LOCATOR_CSS, i, "Ищем совпадение текста записи с текстом - " + bodyText).find(ENTRY_BODY_TEXT_CSS).shouldHave(Condition.matchesText(bodyText));
                        $$(ENTRY_LOCATOR_CSS, i, "Ищем совпадение тега записи с тегом - " + tagName).find(TAG_IN_ENTRY_CSS).shouldHave(Condition.matchesText(tagName));
                        return this;
                    } catch (ElementShould e) {
                    }
                } else {
                    Assert.fail("Нет записей с таким текстом");
                }
            }
        } catch (ElementNotFound e) {
            Assert.fail("Не найдено ни одной записи с таким текстом");
        }
        return this;
    }

    public int checkEntriesCount() {
        return $$(ENTRY_LOCATOR_CSS, "Проверяем количество записей на странице").size();
    }

    public MainPage checkEntriesCount(int entriesBeforeDeleting) {
        $$(ENTRY_LOCATOR_CSS, "Сравниваем количество запсей на странице").shouldHaveSize(entriesBeforeDeleting - 1);
        return this;
    }

    public MainPage checkLackOfEntries() {
        $$(ENTRY_LOCATOR_CSS, "Проверяем, что количество записей на странице == 0").shouldHaveSize(0);
        return this;
    }
}
