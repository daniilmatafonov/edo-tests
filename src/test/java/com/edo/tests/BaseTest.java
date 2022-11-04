package com.edo.tests;

import com.codeborne.selenide.Configuration;
import com.edo.config.IConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.edo.helpers.AttachmentHelper.attachPageSource;
import static com.edo.helpers.AttachmentHelper.attachScreenshot;

public class BaseTest {
    public static final IConfig CONFIG = ConfigFactory.create(IConfig.class, System.getProperties());
    private static final String ALLURE_SELENIDE_LISTENER_NAME = "AllureSelenide";
    private static final String URL = "https://эдо.образование33.рф/login/index.php";
    public static final String LOGIN = CONFIG.login();
    public static final String PASSWORD = CONFIG.pwd();

    @BeforeAll
    static void setup() {
        addListener(ALLURE_SELENIDE_LISTENER_NAME, new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.timeout = 10000;
        Configuration.pageLoadTimeout = 50000;
        Configuration.baseUrl = URL;
        Configuration.browser = CONFIG.browser();
        Configuration.browserVersion = CONFIG.browserVersion();
        if (CONFIG.remoteUrl() != null)
            Configuration.remote = CONFIG.remoteUrl();
    }

    @AfterEach
    public void afterEach() {
        attachScreenshot("Last screenshot");
        attachPageSource();
        closeWebDriver();
    }
}
