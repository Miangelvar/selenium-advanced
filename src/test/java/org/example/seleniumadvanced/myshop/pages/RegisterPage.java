package org.example.seleniumadvanced.myshop.pages;

import lombok.Getter;
import org.example.seleniumadvanced.core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class RegisterPage extends AbstractPage {

    @Getter
    @FindBy(id = "customer_firstname")
    private WebElement firstName;

    @FindBy(id = "customer_lastname")
    private WebElement lastName;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "address1")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "id_country")
    @Getter
    private WebElement country;
    private Select countrySelect;

    @FindBy(id = "id_state")
    private WebElement state;
    private Select stateSelect;



    @FindBy(id = "postcode")
    private WebElement postCode;

    @FindBy(id = "phone_mobile")
    private WebElement phoneNumber;

    @FindBy(id = "submitAccount")
    private WebElement submitBtn;


    public void setFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }


    public RegisterPage(WebDriver driver) {
        super(driver);
        this.countrySelect = new Select(country);
        this.stateSelect = new Select(state);
    }

    public String getEmail() {
        return this.email.getAttribute("value");
    }

    public void setCity(String city) {
        this.city.sendKeys(city);
    }

    public void setState(String state) {
        this.stateSelect.selectByVisibleText(state);
    }

    public void setRandomState() {
        var states = stateSelect.getOptions();
        var random = new Random();
        var randomIndex = random.nextInt(states.size());
        stateSelect.selectByIndex(randomIndex);
    }

    public void setPostCode(String postalCode) {
        this.postCode.sendKeys(postalCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.sendKeys(phoneNumber);
    }

    public MyAccountPage submit() {
        this.submitBtn.click();
        return new MyAccountPage(driver);
    }

    public void setAddress(String streetAddress) {
        address.sendKeys(streetAddress);
    }

}
