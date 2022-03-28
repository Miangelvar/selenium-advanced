package org.example.seleniumadvanced.myshop.tests;


import org.example.seleniumadvanced.hooks.Hook;
import org.example.seleniumadvanced.myshop.pages.MyAccountPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignInTest extends Hook {

    @Test
    public void givenValidEmailAndPasswordWhenLoginThenCorrect(){
        var email = "Grous1954@cuvox.de";
        var password = "12345";
        var signInPage = homePage.clickSignInBtn();
        var myAccountPage = signInPage.signInWithEmailAndPassword(email, password);
        assertEquals(myAccountPage.getMyAccountH1().getText(), MyAccountPage.MY_ACCOUNT);
    }

}
