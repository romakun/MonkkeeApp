package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage extends BasePage{

    private static final String URL = "https://my.monkkee.com/account/registration";
    private static final String COMPLETE_REGISTRATION_BUTTON = ".btn";
    private static final String REGISTRATION_EMAIL_CSS = "#registration_email";
    private static final String REGISTRATION_PASSWORD_CSS = "#registration_password";
    private static final String CONFIRM_PASSWORD_CSS = "#registration_password_confirmation";
    private static final String TERMS_OF_USE_CHECKBOX_CSS = "#registration_password_confirmation";
    private static final String LOST_PASSWORD_WARNING_CHECKBOX_CSS = "#registration_lost_password_warning_registered";

    @Override
    RegistrationPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(COMPLETE_REGISTRATION_BUTTON).shouldBe(Condition.visible);
    }

    public void fillInRegistrationData(String email, String password){
        $(REGISTRATION_EMAIL_CSS).setValue(email);
        $(REGISTRATION_PASSWORD_CSS).setValue(password);
        $(CONFIRM_PASSWORD_CSS).setValue(password);
        $(TERMS_OF_USE_CHECKBOX_CSS).click();
        $(LOST_PASSWORD_WARNING_CHECKBOX_CSS).click();
        $(COMPLETE_REGISTRATION_BUTTON).click();
    }
}
