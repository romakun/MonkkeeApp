package pages;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

//    private static final String EMAIL_INPUT_CSS = "#login";
//    private static final String PASSWORD_INPUT_CSS = "#password";
//    private static final String LOGIN_BUTTON_CSS = ".btn";

    abstract BasePage openPage();
    abstract void isPageOpened();

//    public void logInMonkkee(String email, String password){
//        $(EMAIL_INPUT_CSS).setValue(email);
//        $(PASSWORD_INPUT_CSS).setValue(password);
//        $(LOGIN_BUTTON_CSS).click();
//    }
}
