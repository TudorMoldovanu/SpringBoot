package com.ea.SpringBasic.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.URL;

@Lazy
@Configuration
@Profile("remote")
public class RemoteWebDriverLibrary {

    @Value("${grid.url}")
    private URL remoteUrl;


    @Value("${browser}")
    private String browser;

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public WebDriver getRemoteWebDriverForChrome() {
        return new RemoteWebDriver(remoteUrl, DesiredCapabilities.chrome());
    }

    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public WebDriver getRemoteWebDriverForFirefox() {
        return new RemoteWebDriver(remoteUrl, DesiredCapabilities.firefox());
    }

}
