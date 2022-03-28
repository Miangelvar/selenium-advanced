package org.example.seleniumadvanced.hooks;

import com.github.javafaker.Faker;
import org.example.seleniumadvanced.myshop.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Hook {
    private static final String PATH_TO_CHROMEDRIVER = "/home/miguelvargas/Downloads/chromedriver_linux64/chromedriver";
    protected WebDriver webDriver;
    protected Wait<WebDriver> wait;
    protected HomePage homePage;
    protected Faker faker;
    protected static final Duration MAX_DURATION = Duration.ofSeconds(5);

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        faker = new Faker();
        this.homePage = new HomePage(webDriver);
    }

    @AfterTest
    public void tearDown() {
        webDriver.close();
    }
}
