package com.demoqa;

import org.junit.jupiter.api.BeforeAll;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DemoQaTest {

    @BeforeAll
    static void setUp(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {

        open("/automation-practice-form");

        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivan.ivanov@mail.ru");
        $("#genterWrapper").$((byText("Male"))).click();
        $("#userNumber").setValue("1234567890");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker").$(byText("15")).click();

        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("SPB");
        $("#state").click();
        $(byText("Uttar Pradesh")).click();
        $("#city").click();
        $(byText("Agra")).click();

        $("#submit").click();

        $(".table").shouldHave(text("Ivan"));
        $(".table").shouldHave(text("Ivanov"));
        $(".table").shouldHave(text("van.ivanov@mail.ru"));
        $(".table").shouldHave(text("Male"));
        $(".table").shouldHave(text("1234567890"));
        $(".table").shouldHave(text("August"));
        $(".table").shouldHave(text("15"));
        $(".table").shouldHave(text("English"));
        $(".table").shouldHave(text("Sports"));
        $(".table").shouldHave(text("SPB"));
        $(".table").shouldHave(text("Uttar Pradesh"));
        $(".table").shouldHave(text("Agra"));
        $(".table").shouldHave(text("Ivan"));
    }
}
