package tests;

import org.testng.annotations.Test;

import java.io.IOException;



public class DeleteAllEntriesTest extends BaseTest {

    @Test
    public void deleteAllEntries() throws IOException {
        loginsteps.logIn("balabama@mailinator.com", "6699273Color");
        mainsteps
                .checkOpened()
                .deleteAllEntries();
        headersteps.logOut();
    }
}
