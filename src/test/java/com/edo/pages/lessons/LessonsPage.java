package com.edo.pages.lessons;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class LessonsPage {

    @Step("Выбрать урок")
    public void chooseLesson(String lessonName) {
        $x("//span[contains(text(), '" + lessonName + "')]").click();
    }
}
