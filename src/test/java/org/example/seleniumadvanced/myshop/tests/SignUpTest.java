package org.example.seleniumadvanced.myshop.tests;

import org.example.seleniumadvanced.hooks.Hook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpTest extends Hook {
    private static final String SIGN_IN_URL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @Test
    public void whenClickSignInButtonThenCorrect() {
        homePage.clickSignInBtn();
        Assert.assertTrue(homePage.getDriver().getCurrentUrl().contains(SIGN_IN_URL));
    }


    @Test
    public void givenClickedSignInButtonWhenFulfilledFieldsThenCorrect() {
        var signInPage = homePage.clickSignInBtn();
        var email = faker.internet().emailAddress();
        var registerPage = signInPage.signUpWithEmail(email);
        var registerEmail = registerPage.getEmail();
        var firstName = faker.name().firstName();
        var lastName = faker.name().lastName();
        var fullName = firstName + " " + lastName;
        registerPage.setFirstName(firstName);
        registerPage.setLastName(lastName);
        registerPage.setAddress(faker.address().streetAddress());
        registerPage.setPassword(faker.internet().password());
        registerPage.setCity(faker.address().city());
        wait.until(ExpectedConditions.visibilityOf(registerPage.getCountry()));
        registerPage.setState("Florida");
        registerPage.setPostCode(faker.address().zipCode());
        registerPage.setPhoneNumber(faker.phoneNumber().cellPhone());
        var myAccountPage = registerPage.submit();
        assertEquals(email, registerEmail);
        assertEquals(myAccountPage.getFullName(), fullName);
    }


}
