package com.edo.tests;

import com.edo.pages.LoginPage;
import com.edo.pages.MainPage;
import com.edo.pages.courses.CoursesPage;
import com.edo.pages.lessons.LessonsPage;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class CoursesTest extends BaseTest{

    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();
    private final CoursesPage coursesPage = new CoursesPage();
    private final LessonsPage lessonsPage = new LessonsPage();

    @Test
    public void checkLessonIsAvailable() {
        open("/");
        loginPage.fillLogin(LOGIN);
        loginPage.fillPassword(PASSWORD);
        loginPage.login();
        mainPage.chooseCoursesModule();
        coursesPage.chooseCreatedCourses();
        coursesPage.chooseCourse("Иностранный язык  1 курс Канаева Т.Н.  2022-2023");
        lessonsPage.chooseLesson("From the history of Vladimir avia-mechanical college");
        sleep(5000);
    }
}
