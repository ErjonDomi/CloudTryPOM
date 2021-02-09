package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class DeckPage {



    public DeckPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getDeckTitle(){
        return Driver.getDriver().getTitle();
    }
}
