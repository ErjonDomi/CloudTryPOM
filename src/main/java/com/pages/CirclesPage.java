package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class CirclesPage {


    public CirclesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getCirclesTitle(){
        return Driver.getDriver().getTitle();
    }
}
