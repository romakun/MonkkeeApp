package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.id;

public class RegistrationPage extends BasePage {

    private static final String URL = "https://my.monkkee.com/account/registration";
    private static final String COMPLETE_REGISTRATION_BUTTON = ".btn";
    private static final By REGISTRATION_EMAIL_ID = id("registration_email");
    private static final By REGISTRATION_PASSWORD_ID = id("registration_password");
    private static final By CONFIRM_PASSWORD_ID = id("registration_password_confirmation");
    private static final By TERMS_OF_USE_CHECKBOX_ID = id("registration_terms_of_use");
    private static final By LOST_PASSWORD_WARNING_CHECKBOX_ID = id("registration_lost_password_warning_registered");
    private static final String REGISTRATION_RESULT_MESSAGE = "User registered";

    @Override
    public RegistrationPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    public RegistrationPage isPageOpened() {
        $(COMPLETE_REGISTRATION_BUTTON).shouldBe(Condition.visible);
        return this;
    }

    public RegistrationPage fillInRegistrationData(String email, String password) {
        element($(REGISTRATION_EMAIL_ID), "Вводим Email нового пользователя " + email).setValue(email);
        element($(REGISTRATION_PASSWORD_ID), "Вводим пароль нового пользователя " + password).setValue(password);
        element($(CONFIRM_PASSWORD_ID), "Вводим пароль в поле подтверждения " + password).setValue(password);
        element($(TERMS_OF_USE_CHECKBOX_ID), "Активируем чекбокс c Условиями использования").click();
        element($(LOST_PASSWORD_WARNING_CHECKBOX_ID), "Активируем чекбокс с условиями по паролю").click();
        element($(COMPLETE_REGISTRATION_BUTTON), "Кликаем на кнопку ОК и завершаем регистрацию").click();
        return this;
    }

    public RegistrationPage checkRegistrationResult() {
        element($(byText(REGISTRATION_RESULT_MESSAGE)), "Проверяем сообщение о завершении регистрации").shouldBe(Condition.visible);
        return this;
    }
}
