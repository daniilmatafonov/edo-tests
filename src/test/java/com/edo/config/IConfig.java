package com.edo.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface IConfig extends Config {

    @Key("browser")
    String browser();
    @Key("browser_version")
    String browserVersion();
    @Key("login")
    String login();
    @Key("pwd")
    String pwd();
    @Key("remote_url")
    String remoteUrl();

}
