package steps;

import io.qameta.allure.Step;
import pages.HeaderBlock;

public class HeaderSteps {

    HeaderBlock block;

    public HeaderSteps() {
        block = new HeaderBlock();
    }

    @Step("Click LogOut")
    public void logOut() {
        block
                .logOut()
                .checkModal();
    }
}
