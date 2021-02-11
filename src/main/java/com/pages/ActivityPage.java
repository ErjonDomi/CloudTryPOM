package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ActivityPage {
    public ActivityPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='app-navigation']//li//a")
    List<WebElement> allActivityModules;



    public String getActivityTitle(){
        return Driver.getDriver().getTitle();
    }

    public List<WebElement> getAllActivityModules(){
        return allActivityModules;
    }


}
