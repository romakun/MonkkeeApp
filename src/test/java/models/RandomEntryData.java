package models;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import java.util.Locale;

public class RandomEntryData {

    String headerText;
    String bodyText;
    String newTag;

    public String generateRandomHeader() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return headerText = fakeValuesService.bothify("HEADER ??????");
    }

    public String generateRandomBody() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return bodyText = fakeValuesService.bothify("?????? ????? ???????");
    }

    public String generateRandomTag() {
        FakeValuesService fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());

        return newTag = fakeValuesService.bothify("???##???");
    }

}

