package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.sleep;

public class HeaderBlock extends BasePage {

    private static final String LOGOUT_BUTTON_TEXT = "Logout";
    private static final String MODAL_FEED_HEADER_CSS = ".modal-header";
    private static final String MODAL_CANCEL_BUTTON_TEXT = "Log out";

    @Override
    BasePage openPage() {
        return null;
    }

    @Override
    BasePage isPageOpened() {
        return null;
    }

    public HeaderBlock logOut(){
        $(withText(LOGOUT_BUTTON_TEXT)).shouldBe(Condition.visible);
        $(withText(LOGOUT_BUTTON_TEXT), "Жмем на кнопку Logout").click();
//        sleep(2000);
        return this;
    }

    public void checkModal() {
        try {
            $(MODAL_FEED_HEADER_CSS, "Ждем модалку если появится").waitUntil(Condition.visible, 1000);
            $(byText(MODAL_CANCEL_BUTTON_TEXT), "Закрываем модалку, раз появилась").waitUntil(Condition.visible, 7000).click();
        } catch (AssertionError e) {
        }
    }

}
