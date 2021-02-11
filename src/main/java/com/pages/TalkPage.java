package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalkPage {
    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@class='app-navigation-search__input']")
    public WebElement nameSearchBox;

    @FindBy(className = "acli__content__line-one__title")
    public WebElement searchName;
    @FindBy(xpath = "//div[@placeholder='Write message, @ to mention someone …']")
    public WebElement typeBox;
@FindBy(className=("new-message-form__advancedinput"))
public WebElement clickSendButton;








    public String getTalksTitle(){
        return Driver.getDriver().getTitle();
    }
    public void getNameSearchBox(){ nameSearchBox.sendKeys("Employee1"); }
    public void clickSearchName(){ searchName.click();}
    public void sendMessage(){
        typeBox.sendKeys("hello"+Keys.ENTER);



    }







    }



