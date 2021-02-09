package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.support.PageFactory;

public class PhotosPage {
    public PhotosPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public String getPhotosTitle(){
        return Driver.getDriver().getTitle();
    }


}
