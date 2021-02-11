package com.pages;

import com.github.javafaker.Faker;
import com.qa.factory.Driver;
import com.qa.util.Sleep;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {


    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "new-contact-button")
    public WebElement newContactButton;
    @FindBy(xpath = "//input[@id='contact-fullname']")
    public WebElement fullName;
    @FindBy(xpath = "//input[@inputmode='tel']")
    public WebElement phoneHomeInput;
    @FindBy(xpath = "//input[@inputmode='email']")
    public WebElement emailInput;
    @FindBy(xpath = "//div[@class='property-masonry']//div[3]//input[1]")
    public WebElement addressInput;
    @FindBy(xpath = "//div[@class='property-masonry']//div[5]//input[1]")
    public WebElement postalCode;
    @FindBy(xpath = "//div[@class='property-masonry']//div[6]//input[1]")
    public WebElement cityAddress;
    @FindBy(xpath = "//div[7]//input[1]")
    public WebElement stateInput;
    @FindBy(xpath = "//div[8]//input[1]")
    public WebElement country;
    @FindBy(xpath = "//div[@class='vue-recycle-scroller__item-view'][2]")
    public WebElement createdContact;

    public String getContactsTitle() {
        return Driver.getDriver().getTitle();
    }

    public void clickingCreatingNewContact() {
        newContactButton.click();
    }

    Faker faker = new Faker();

    public boolean CreateNewContact(String name) {
        newContactButton.click();
        newContactButton.click();

        fullName.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        fullName.sendKeys(Keys.BACK_SPACE);
        fullName.sendKeys(name);

        Sleep.sleep(10);
        phoneHomeInput.clear();
        phoneHomeInput.sendKeys(faker.phoneNumber().phoneNumber());
        emailInput.clear();
        emailInput.sendKeys(faker.address().firstName() + "@Gmail.com");
        addressInput.clear();
        addressInput.sendKeys(faker.address().streetAddress());
        postalCode.clear();
        postalCode.sendKeys(faker.address().zipCode());
        cityAddress.clear();
        cityAddress.sendKeys(faker.address().city());
        stateInput.clear();
        stateInput.sendKeys(faker.address().stateAbbr());
        country.clear();
        country.sendKeys(faker.address().country());

        newContactButton.click();

        return Driver.getDriver().findElement(By.xpath("//div[normalize-space()='" + name + "']")).isDisplayed();

    }


}
