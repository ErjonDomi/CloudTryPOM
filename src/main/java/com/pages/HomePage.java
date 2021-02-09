package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {


    @FindBy(xpath = "//ul[@id='appmenu']//a")
    List<WebElement> mainModules;
    @FindBy(xpath = "ul[id='appmenu'] a[aria-label='Files']")
    WebElement filesLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Photos']")
    WebElement photosLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Activity']")
    WebElement activityLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Talk']")
    WebElement talkLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Mail']")
    WebElement mailLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Contacts']")
    WebElement contactsLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Circles']")
    WebElement circlesLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Calendar']")
    WebElement calendarLink;

    @FindBy(xpath = "//ul[@id='appmenu']//a[@aria-label='Deck']")
    WebElement deckLink;




    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getHomePageTitle() {
        return Driver.getDriver().getTitle();
    }

    public List<WebElement> getAllModules() {
        List<WebElement> list = mainModules;

        return list;
    }

    public FilePage clickFileModule() {
        filesLink.click();
        return new FilePage();
    }

    public PhotosPage clickPhotosModule(){
       photosLink.click();
       return new PhotosPage();
    }

    public ActivityPage clickActivityLink(){
        activityLink.click();
        return new ActivityPage();
    }
    public TalkPage clickTalkLink(){
        talkLink.click();
        return new TalkPage();
    }
    public MailPage clickMailLink(){
        mailLink.click();
        return new MailPage();
    }
    public ContactsPage clickContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public CirclesPage clickCirclesLink(){
        circlesLink.click();
        return new CirclesPage();
    }

    public CalendarPage clickCalendarLink(){
        calendarLink.click();
        return new CalendarPage();
    }

    public DeckPage clickDeckLink(){
        deckLink.click();
        return new DeckPage();
    }
}
