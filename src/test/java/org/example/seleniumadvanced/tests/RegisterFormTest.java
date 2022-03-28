package org.example.seleniumadvanced.tests;

import org.example.seleniumadvanced.core.RegisterDemoPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;


public class RegisterFormTest {
    private static final String PATH_TO_CHROMEDRIVER = "C:\\Users\\miguel.vargas\\Downloads\\chromedriver_win32\\chromedriver.exe";

    private static RegisterDemoPage formPage;

    @BeforeTest
    public static void setUp() {

        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
        var options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver webDriver = new ChromeDriver();
        var test = new RegisterDemoPage(webDriver);
    }
}
