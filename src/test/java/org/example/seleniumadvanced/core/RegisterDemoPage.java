package org.example.seleniumadvanced.core;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


@Getter
@Slf4j
public class RegisterDemoPage {
    private static final String MIGUEL = "Miguel";
    private static final String PATH_TO_CHROMEDRIVER = "/home/miguelvargas/Downloads/chromedriver_linux64/chromedriver";
    private static final String PAGE_URL = "http://demo.automationtesting.in/Register.html";

    //            "C:\\Users\\miguel.vargas\\Downloads\\chromedriver_win32\\chromedriver.exe";
    private final WebDriver driver;
    private final Wait<WebDriver> wait;
    @FindBy(xpath = "//input[@ng-model='FirstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@ng-model='LastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@ng-model='EmailAdress']")
    private WebElement emailInput;

    @FindBy(xpath = "//textarea[@ng-model='Adress']")
    private WebElement addressTextArea;

    @FindBy(xpath = "//input[@ng-model='Phone']")
    private WebElement phoneInput;

    @FindBy(xpath = "//input[@value='Male']")
    private WebElement maleRadioBtn;

    @FindBy(xpath = "//input[@value='FeMale']")
    private WebElement femaleRadioBtn;

    @FindBy(id = "checkbox2")
    private WebElement moviesCheckBox;

    @FindBy(id = "checkbox1")
    private WebElement cricketCheckBox;

    @FindBy(id = "checkbox3")
    private WebElement hockeyCheckBox;

    @FindBy(id = "msdd")
    private WebElement languagesContainer;

    @FindBys(@FindBy(xpath = "//a[@class='ui-corner-all']/parent::li"))
    private List<WebElement> languages;

    @FindBy(id = "Skills")
    private WebElement skills;
    private Select skillSelect;

    @FindBy(id = "country")
    private WebElement countries;
    private Select countrySelect;

    @FindBy(id = "yearbox")
    private WebElement year;
    private Select yearSelect;

    @FindBy(xpath = "//select[@ng-model='monthbox']")
    private WebElement month;
    private Select monthSelect;

    @FindBy(id = "daybox")
    private WebElement day;
    private Select daySelect;

    @FindBy(id = "firstpassword")
    private WebElement password;

    @FindBy(id = "secondpassword")
    private WebElement passwordConfirm;

    @FindBy(id = "imagesrc")
    private WebElement uploadInput;


    public RegisterDemoPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        init();
    }

    private void init() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
        skillSelect = new Select(skills);
        countrySelect = new Select(countries);
        yearSelect = new Select(year);
        monthSelect = new Select(month);
        daySelect = new Select(day);
    }


    public void setFirstName(String username) {
        firstNameInput.sendKeys(username);
    }

    public void setLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void setAddress(String address) {
        addressTextArea.sendKeys(address);
    }

    public void setEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void setPhoneNumber(String phoneNumber) {
        phoneInput.sendKeys(phoneNumber);
    }

    public void clickMaleRadio() {
        maleRadioBtn.click();
    }

    public void clickMoviesCheck() {
        moviesCheckBox.click();
    }

    public void clickCricketCheck() {
        cricketCheckBox.click();
    }

    public void selectLanguage(String language) {
        try {
            var languageElement = driver
                    .findElement(By.
                            xpath("//a[text()[contains(.,'" + language + "')]]/parent::li"));
            languagesContainer.click();
            wait
                    .until(ExpectedConditions
                            .elementToBeClickable(languageElement))
                    .click();
        } catch (Exception e) {
            log.error("No language for value " + language);
        }
    }


//    public void run() {
//        driver.get(PAGE_URL);
//
////        this.firstName.sendKeys(MIGUEL);
//
////            Personal info
//        writeElement(By.xpath("//input[@ng-model='FirstName']"), MIGUEL);
//        writeElement(By.xpath("//input[@ng-model='LastName']"), "Vargas");
//        writeElement(By.xpath("//textarea[@ng-model='Adress']"), "Fake Street 123");
//        writeElement(By.xpath("//input[@ng-model='EmailAdress']"), "miguel@example.com");
//        writeElement((By.xpath("//input[@ng-model='Phone']")), "3103103110");
//        clickElement(By.xpath("//input[@value='Male']"));
//        clickElement(By.id("checkbox2"));
//
////            Languages
//        clickElement(By.id("msdd"));
//        clickElement(By.xpath("//a[text()[contains(.,'Arabic')]]/parent::li"));
//        clickElement(By.id("msdd"));
//        clickElement(By.xpath("//a[text()[contains(.,'Bulgarian')]]/parent::li"));
//
////            Skills
//        clickSelectByValue(By.id("Skills"), "Adobe Photoshop");
//
////            Country
//        clickSelectByValue(By.id("country"), "Australia");
//
////            Birthdate
//        clickSelectByValue(By.id("yearbox"), "1995");
//        clickSelectByValue(By.xpath("//select[@ng-model='monthbox']"), "November");
//        clickSelectByValue(By.id("daybox"), "11");
//
//
////            Password
//        writeElement(By.id("firstpassword"), "admin12345");
//        writeElement(By.id("secondpassword"), "admin12345");
//
////            Upload file from local
//        writeElement(By.id("imagesrc"), PATH_TO_CHROMEDRIVER);
//
//
//    }

    public void writeElement(By by, String keys) {
        driver.findElement(by).sendKeys(keys);
    }

    public void clickElement(By by) {
        driver.findElement(by).click();
    }

    public void clickSelectByValue(By by, String value) {
        new Select(driver.findElement(by)).selectByValue(value);
    }

    public void selectSkillByValue(String skill) {
        skillSelect.selectByValue(skill);
    }

    public void selectSkill(String skill) {
        skillSelect.selectByValue(skill);
    }

    public void selectSkillByVisibleText(String text) {
        skillSelect.selectByVisibleText(text);
    }

    public void clickSelectByVisibleText(By by, String text) {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }

    public void close() {
        driver.close();
        driver.quit();
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROMEDRIVER);
        var faker = new Faker();
        var webDriver = new ChromeDriver();
        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(2));
        var page = new RegisterDemoPage(webDriver);
        try {
            page.setFirstName(faker.name().firstName());
            page.setLastName(faker.name().lastName());
            page.setAddress(faker.address().streetAddress());
            page.setEmail(faker.internet().emailAddress());
            page.setPhoneNumber(faker.phoneNumber().cellPhone());
            page.clickMaleRadio();
            page.clickFemaleRadio();
            page.clickCricketCheck();
            page.clickMoviesCheck();
            page.clickHockeyCheck();
            page.selectLanguage("Bulgarian");
            page.selectLanguage("Spanish");
            page.selectLanguage("NotALanguage");
            page.selectSkill("Adobe Photoshop");
            PageUtils.select(page.getCountrySelect(), "Australia");
            PageUtils.select(page.getYearSelect(), "1995");
            PageUtils.select(page.getMonthSelect(), "November");
            PageUtils.select(page.getDaySelect(), "11");
            PageUtils.write(page.getPassword(), "admin12345");
            PageUtils.write(page.getPasswordConfirm(), "admin12345");

            Thread.sleep(Duration.ofSeconds(15).toMillis());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            page.close();
        }
    }

    public void clickFemaleRadio() {
        femaleRadioBtn.click();
    }

    public void clickHockeyCheck() {
        this.hockeyCheckBox.click();
    }


}
