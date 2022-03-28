package org.example.seleniumadvanced.myshop.pages;

import lombok.Getter;
import org.example.seleniumadvanced.core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends AbstractPage {
    public static final String MY_ACCOUNT = "My account";

    @FindBy(xpath = "//div/a[@class='account']/span")
    private WebElement myFullName;

    @FindBy(xpath = "//h1")
    @Getter
    private WebElement MyAccountH1;

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    public String getFullName() {
        return myFullName.getText();
    }
}
