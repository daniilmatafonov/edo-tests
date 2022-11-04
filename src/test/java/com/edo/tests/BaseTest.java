package com.edo.tests;

import com.codeborne.selenide.Configuration;
import com.edo.config.IConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static com.edo.helpers.AttachmentHelper.*;

public class BaseTest {

    public static final IConfig CONFIG = ConfigFactory.create(IConfig.class, System.getProperties());
    private static final String ALLURE_SELENIDE_LISTENER_NAME = "AllureSelenide";
    private static final String URL = "https://эдо.образование33.рф/login/index.php";

    @BeforeAll
    static void setup() {
        addListener(ALLURE_SELENIDE_LISTENER_NAME, new AllureSelenide().screenshots(true).savePageSource(true));
        Configuration.timeout = 10000;
        Configuration.baseUrl = URL;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "87.0";
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
