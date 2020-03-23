package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ex.ElementShould;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.openqa.selenium.By.id;

public class LoginPage extends BasePage {

    private static final String URL = "https://my.monkkee.com/#/";
    private static final By EMAIL_INPUT_ID = id("login");
    private static final By PASSWORD_INPUT_ID = id("password");
    private static final String LOGIN_BUTTON_CSS = ".btn";
    private static final String MODAL_FEED_HEADER_CSS = ".modal-header";
    private static final String MODAL_CANCEL_BUTTON_TEXT = "Cancel";

    @Override
    public LoginPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        try {
            $(LOGIN_BUTTON_CSS, "Ждем, пока страница загрузится").shouldBe(Condition.visible);
            return this;
        } catch (ElementShould e) {
            Assert.fail("Страница почему-то не загрузилась");
            return null;
        }
    }

    public LoginPage logIn(String email, String password) {
        $(EMAIL_INPUT_ID, "Вводим Email " + email + " В поле User").setValue(email);
        $(PASSWORD_INPUT_ID, "Вводим Пароль " + password + " В поле Password").setValue(password);
        $(LOGIN_BUTTON_CSS, "Нажимаем на кнопку Login").click();
        return this;
    }

    public void checkModal() {
        try {
            $(MODAL_FEED_HEADER_CSS, "Ждем модалку если появится").waitUntil(Condition.visible, 1000);
//            sleep(6000);
            $(byText(MODAL_CANCEL_BUTTON_TEXT), "Закрываем модалку, раз появилась").waitUntil(Condition.visible, 7000).click();
        } catch (AssertionError e) {
        }
    }
}