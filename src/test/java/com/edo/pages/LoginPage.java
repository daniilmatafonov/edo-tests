package com.edo.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    @Step("Заполнить логин")
    public void fillLogin(String login) {
        $("input[name='username']").setValue(login);
    }

    @Step("Заполнить пароль")
    public void fillPassword(String pwd) {
        $("input[name='password']").setValue(pwd);
    }

    @Step("Выполнить логин")
    public void login() {
        $("#submit_login_button").click();
    }


    @Step("Проверить корректность проведения операции")
    public void validateOperation() {
        $("success-operation-title.success-operation-title").shouldHave(text("Операция выполнена"));
    }
}
