package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.testng.Assert;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.id;

public class MailinatorPage extends BasePage {

    private static final String URL = "https://www.mailinator.com/";
    private static final By EMAIL_INPUT_ID = id("addOverlay");
    private static final By GO_BUTTON_ID = id("go-to-public");
    private static final String REGISTRATION_MESSAGE_TITLE = "Welcome to monkkee";
    private static final String MESSAGE_FRAME_LOCATOR = "msg_body";
    private static final String CONFIRM_BUTTON_XPATH = "//a[contains(text(),'Confirm')]";
    private static final By TRASH_ICON_ID = id("trash_but");
    private static final String CONFIRMATION_MESSAGE = "h1";

    @Override
    public MailinatorPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public MailinatorPage isPageOpened() {
        $(EMAIL_INPUT_ID).shouldBe(Condition.visible);
        return this;
    }

    public MailinatorPage goToEmailBox(String email) {
        $(EMAIL_INPUT_ID, "Вводим Email " + email + " в поле поиска").setValue(email);
        $(GO_BUTTON_ID, "Жмем на кнопку GO").click();
        $(TRASH_ICON_ID).shouldBe(Condition.visible);
        return this;
    }

    public MailinatorPage goToMailAndConfirm() {
        $(byText(REGISTRATION_MESSAGE_TITLE), "Ищем письмо по заголовку" + REGISTRATION_MESSAGE_TITLE + "и кликаем по нему").click();
        switchTo().frame(MESSAGE_FRAME_LOCATOR);
        $(By.xpath(CONFIRM_BUTTON_XPATH), "Жмем на кнопку подтвержднеия регистрации").click();
        return this;
    }

    public MailinatorPage checkRegistrationConfirmResult() {
        switchTo().window(1);
        try {
            $(CONFIRMATION_MESSAGE, "Проверяем сообщение с результатом регистрации").shouldBe(Condition.text("Registration confirmed successfully"));
        } catch (ElementShould e) {
            $(CONFIRMATION_MESSAGE, "Проверяем сообщение с результатом регистрации").shouldBe(Condition.text("Confirmation failed"));
            Assert.fail("Скорее всего данный пользователь уже зарегистрирован");
        }
        return this;
    }
}
