package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;

public class LoginPage extends BasePage {

    private static final String URL = "https://my.monkkee.com/#/";
    private static final By EMAIL_INPUT_ID = id("login");
    private static final By PASSWORD_INPUT_ID = id("passwor");
    private static final String LOGIN_BUTTON_CSS = ".btn";

    @Override
    public LoginPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public LoginPage isPageOpened() {
        $(LOGIN_BUTTON_CSS).shouldBe(Condition.visible);
        return this;
    }

    public LoginPage logIn(String email, String password) {
        $(EMAIL_INPUT_ID, "Вводим Email " + email + " В поле User").setValue(email);
        $(PASSWORD_INPUT_ID, "Вводим Пароль " + password + " В поле Password").setValue(password);
        $(LOGIN_BUTTON_CSS, "Нажимаем на кнопку Login").click();
        return this;
    }
}