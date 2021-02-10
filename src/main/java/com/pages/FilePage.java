package com.pages;

import com.qa.factory.Driver;
import com.qa.util.TakeScreenShots;
import com.qa.util.UploadFile;
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

    @FindBy(xpath = "//a[@class='button new']")
    WebElement addFile;

    @FindBy(xpath = "//label[@for='file_upload_start']")
    WebElement uploadFile;

    @FindBy(xpath = "//a[contains(text(),'All files')]")
    private WebElement allFiles;
    @FindBy(xpath = "//a[contains(text(),'Recent')]")
    private WebElement recent;
    @FindBy(xpath = "//ul[@class='with-icon']/li[3]")
    private WebElement favorites;
    @FindBy(xpath = "//a[contains(text(),'Shares')]")
    private WebElement shares;
    @FindBy(xpath = "//a[contains(text(),'Tags')]")
    private WebElement tags;
    @FindBy(xpath = "//a[contains(text(),'Deleted Files')]")
    private WebElement deletedFiles;
    @FindBy(xpath = "//button[contains(text(),'Settings')]")
    private WebElement settings;
    @FindBy(css = "a[class='button new']")
    private WebElement addNewFileButton;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileUpload;

    @FindBy(xpath = "(//span[@class='icon icon-more'])[2]")
    private WebElement actionIcon;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    private WebElement addnRemoveFavorites;

    @FindBy(xpath = "//span[@class='innernametext']")
    private WebElement folderInFavorites;
    @FindBy(css = "a[data-templatename='New folder']")
    private WebElement newFolder;
    @FindBy(css = "input[value='New folder']")
    private WebElement newFolderName;
    @FindBy(xpath = "(//input[@type='submit'])[2]")
    private WebElement newFolderSubmit;


    public String FilePageTitle() {
        return Driver.getDriver().getTitle();
    }

    public List<WebElement> getSelectedCheckBox() {
        selectAllCheckBox.click();
        List<WebElement> list = selectedCheckBox;
        return list;
    }


    public boolean uploadFiles(String path, String fileName) {
        addFile.click();
        uploadFile.click();
        UploadFile.fileAttachmentUsingRobot(path);
        return Driver.getDriver().findElement(By.xpath("//span[@class='innernametext'][normalize-space()='"+fileName+"']")).isDisplayed();

    }


}
