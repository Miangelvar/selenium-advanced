package org.example.seleniumadvanced.myshop.pages;

import org.example.seleniumadvanced.core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    private static final String HOME_PAGE_URL = "http://automationpractice.com/index.php";
    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInBtn;

    public SignInPage clickSignInBtn() {
        signInBtn.click();
        return new SignInPage(driver);
    }

    public HomePage(WebDriver driver) {
        super(driver);
        driver.get(HOME_PAGE_URL);
    }
}
