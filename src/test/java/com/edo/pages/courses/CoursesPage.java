package com.edo.pages.courses;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CoursesPage {

    @Step("Выбрать созданные курсы")
    public void chooseCreatedCourses() {
        $("#title_tab-created_span").click();
    }

    @Step("Выбрать курс")
    public void chooseCourse(String courseName) {
        $x("//a[contains(text(), '" + courseName + "')]").click();
    }
}
