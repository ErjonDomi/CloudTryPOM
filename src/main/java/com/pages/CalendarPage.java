package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {

    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getCalendarTitle(){
        return Driver.getDriver().getTitle();
    }



}
