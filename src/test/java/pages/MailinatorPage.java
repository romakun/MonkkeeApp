package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MailinatorPage extends BasePage{

    private static final String URL = "https://www.mailinator.com/";
    private static final String EMAIL_INPUT_CSS = "#addOverlay";
    private static final String GO_BUTTON_CSS = "#go-to-public";
    private static final String REGISTRATION_MESSAGE_TITLE = "Welcome to monkkee";
    private static final String MESSAGE_FRAME_ID = "msg_body";
    private static final String CONFIRM_BUTTON_XPATH = "//a[contains(text(),'Confirm')]";

    @Override
    public MailinatorPage openPage() {
        open(URL);
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(EMAIL_INPUT_CSS).shouldBe(Condition.visible);
    }

    public MailinatorPage goToEmailBox(String email){
        $(EMAIL_INPUT_CSS).setValue(email);
        $(GO_BUTTON_CSS).click();
        $("#trash_but").shouldBe(Condition.visible);
        return this;
    }

    public MailinatorPage goToMailAndConfirm(){
        $(byText(REGISTRATION_MESSAGE_TITLE)).click();
        switchTo().frame(MESSAGE_FRAME_ID);
        $(By.xpath(CONFIRM_BUTTON_XPATH)).click();
        return this;
    }

}
