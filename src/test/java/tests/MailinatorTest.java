package tests;

import org.testng.annotations.Test;

public class MailinatorTest extends BaseTest{
    @Test
    public void addNewHugInMood() {
        mailinator.openMailinatorPage()
                .goToEmailBox("balabama@mailinator.com")
                .confirmRegistration();
    }

}
