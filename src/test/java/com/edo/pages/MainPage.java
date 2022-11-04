package com.edo.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    @Step("Выбрать курсы")
    public void chooseCoursesModule() {
        $("#browse_link").click();
    }
}
