package com.ea.SpringBasic.pages;


import com.ea.SpringBasic.annotation.PageScope;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@PageScope
public class MainPage {

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private HomePage homePage;

    @Autowired
    private WebDriver webDriver;

    public void PerformLogin() {

        webDriver.navigate().to("http://eaapp.somee.com");
        homePage.ClickLogin();
        loginPage.Login("admin", "password");
        loginPage.ClickLogin();
    }

    public void PerformLogoff() {
        homePage.ClickLogout();
    }
}
