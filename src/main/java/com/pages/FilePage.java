package com.pages;

import com.qa.factory.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilePage {
    public FilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//label[@for='select_all_files']")
    WebElement selectAllCheckBox;
    @FindBy(xpath = "//tbody//input")
    List<WebElement> selectedCheckBox;


    public String FilePageTitle() {
        return Driver.getDriver().getTitle();
    }

    public List<WebElement> getSelectedCheckBox(){
        selectAllCheckBox.click();
      List<WebElement>  list=selectedCheckBox;
      return list;
    }


}
