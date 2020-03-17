package steps;

import io.qameta.allure.Step;
import pages.MainPage;

public class MainSteps {

    MainPage page;

    public MainSteps(){page = new MainPage();}

    @Step("Check main page opened")
    public MainSteps checkOpened(){
        page.openPage();
        return this;
    }
}
