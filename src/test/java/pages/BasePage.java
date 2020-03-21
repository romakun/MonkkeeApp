package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.ex.ElementNotFound;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.testng.Assert;


@Log4j2
public abstract class BasePage {

    abstract BasePage openPage();

    abstract BasePage isPageOpened();

    public SelenideElement $(By element){
        String script = "arguments[0].style.border='3px solid red'";
        try {
            Selenide.executeJavaScript(script, Selenide.$(element));
            return Selenide.$(element);
        } catch (ElementNotFound e) {
            Assert.fail("Не найден элемент " + element);
            return null;
        }
    }

    public SelenideElement $(By element, String logMessage){
        $(element);
        log.info(logMessage);
        return Selenide.$(element);
    }

    public SelenideElement $(String element){
        String script = "arguments[0].style.border='3px solid red'";
        try {
            Selenide.executeJavaScript(script, Selenide.$(element));
            return Selenide.$(element);
        } catch (ElementNotFound e) {
            Assert.fail("Не найден элемент " + element);
            return null;
        }
    }

    public SelenideElement $(String element, String logMessage){
        $(element);
        log.info(logMessage);
        return Selenide.$(element);

    }
}
