package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class BasePage {

    abstract BasePage openPage();

    abstract BasePage isPageOpened();

    public SelenideElement element(SelenideElement element, String logMessage){
        String script = "arguments[0].style.border='3px solid red'";
        Selenide.executeJavaScript(script, element);
        log.info(logMessage);
        return element;
    }
}
