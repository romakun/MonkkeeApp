package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public abstract class BasePage {

    abstract BasePage openPage();

    abstract void isPageOpened();

    public SelenideElement element(SelenideElement element){
        String script = "arguments[0].style.border='3px solid red'";
        Selenide.executeJavaScript(script, element);
        return element;
    }
}
