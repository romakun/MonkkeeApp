package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.id;

public class MainPage extends BasePage {

    private static final By CREATE_ENTRY_BUTTON_ID = id("create-entry");

    @Override
    public MainPage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    void isPageOpened() {
        $(CREATE_ENTRY_BUTTON_ID).shouldBe(Condition.visible);
    }
}
