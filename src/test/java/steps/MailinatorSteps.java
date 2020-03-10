package steps;

import io.qameta.allure.Step;
import pages.MailinatorPage;

public class MailinatorSteps {

    MailinatorPage page;

    public MailinatorSteps() {
        page = new MailinatorPage();
    }

    @Step("Open edit profile page")
    public MailinatorSteps openMailinatorPage() {
        page
                .openPage();
        return this;
    }

    @Step("Go to emailBox")
    public MailinatorSteps goToEmailBox(String email){
        page.goToEmailBox(email);
        return this;
    }

    @Step("Confirm registration")
    public MailinatorSteps confirmRegistration(){
        page.goToMailAndConfirm();
        return this;
    }
}
