package steps;

import io.qameta.allure.Step;
import pages.LoginPage;

public class LoginSteps {

    LoginPage page;

    public LoginSteps() {
        page = new LoginPage();
    }

    @Step("Login monkkee.com Email='{email}', Password='{password}'")
    public LoginSteps logIn(String email, String password){
        page
                .openPage()
                .logIn(email, password);
        return this;
    }
}
