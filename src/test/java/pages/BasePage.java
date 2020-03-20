package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Log4j2
public abstract class BasePage {

    abstract BasePage openPage();

    abstract BasePage isPageOpened();

    public SelenideElement $(By element, String logMessage){
        String script = "arguments[0].style.border='3px solid red'";
        Selenide.executeJavaScript(script, Selenide.$(element));
        log.info(logMessage);
        return Selenide.$(element);
    }

    public SelenideElement $(By element){
        String script = "arguments[0].style.border='3px solid red'";
        Selenide.executeJavaScript(script, Selenide.$(element));
        return Selenide.$(element);
    }

    public SelenideElement $(String element){
        String script = "arguments[0].style.border='3px solid red'";
        Selenide.executeJavaScript(script, Selenide.$(element));
        return Selenide.$(element);
    }

    public SelenideElement $(String element, String logMessage){
        String script = "arguments[0].style.border='3px solid red'";
        Selenide.executeJavaScript(script, Selenide.$(element));
        log.info(logMessage);
        return Selenide.$(element);
    }
}
