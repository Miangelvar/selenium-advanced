package org.example.seleniumadvanced.myshop.pages;

import org.example.seleniumadvanced.core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends AbstractPage {

    @FindBy(id = "email_create")
    private WebElement signUpInput;

    @FindBy(id = "SubmitCreate")
    private WebElement signUpBtn;

    @FindBy(id = "email")
    private WebElement signIn;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginBtn;



    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage signInWithEmailAndPassword(String email, String password) {
        signIn.sendKeys(email);
        this.password.sendKeys(password);
        submitLoginBtn.click();
        return new MyAccountPage(driver);
    }

    public RegisterPage signUpWithEmail(String email) {
        signUpInput.sendKeys(email);
        signUpBtn.click();
        return new RegisterPage(driver);
    }

    public String getEmail() {
        return signUpBtn.getAttribute("value");
    }


}
