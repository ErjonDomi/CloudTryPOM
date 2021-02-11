package com.pages;

import com.qa.factory.Driver;
import com.qa.util.TakeScreenShots;
import com.qa.util.UploadFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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


    @FindBy(xpath = "//input[@type='file']")
    private WebElement fileUpload;

    @FindBy(xpath = "//span[normalize-space()='Add to favorites']")
    private WebElement addToFavorites;

    @FindBy(css = "a[class='nav-icon-favorites svg']")
    WebElement favorites;

    @FindBy(css = "a[class='nav-icon-favorites svg']")
    List<WebElement> favoritesList;

    @FindBy(xpath = "//td[@class='filename']//span[@class='fileactions']//span[@class='hidden-visually'][normalize-space()='Actions']")
    WebElement actionButton;

    @FindBy(xpath = "//span[normalize-space()='Remove from favorites']")
    WebElement removeFromFavorites;

    @FindBy(xpath = "//span[normalize-space()='New folder']")
    WebElement newFolder;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    WebElement folderName;

    @FindBy(xpath = "//span[normalize-space()='Details']")
    WebElement details;

    @FindBy(xpath = "//a[normalize-space()='Comments']")
    WebElement comment;

    @FindBy(xpath = "//div[@class='message']")
    WebElement enterComment;


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
        return Driver.getDriver().findElement(By.xpath("//span[@class='innernametext'][normalize-space()='" + fileName + "']")).isDisplayed();

    }

    public boolean addToFavorites(String fileName) {
        Driver.getDriver().findElement(By.xpath(" //a[@href='/index.php/apps/files?dir=//" + fileName + "']//span[@class='fileactions']//a[@class='action action-menu permanent']")).click();
        addToFavorites.click();
        favorites.click();
        return Driver.getDriver().findElement(By.xpath("//td[@class='filename']//span[@class='innernametext'][normalize-space()='" + fileName + "']")).isDisplayed();

    }


    public boolean removeFromFavorites() {
        List<WebElement> list = favoritesList;

        if (favoritesList.isEmpty()) {
            return false;
        }
        favorites.click();
        actionButton.click();
        removeFromFavorites.click();
        List<WebElement> list1 = favoritesList;

        return list.size() != list1.size();
    }

    public boolean createFolder(String name) {
        addFile.click();
        newFolder.click();
        folderName.sendKeys(Keys.BACK_SPACE, name, Keys.ENTER);
        return Driver.getDriver().findElement(By.xpath("//span[@class='innernametext'][normalize-space()='" + name + "']")).isDisplayed();
    }

    public boolean writeComment(String fileName, String comments) {
        Driver.getDriver().findElement(By.xpath(" //a[@href='/index.php/apps/files?dir=//" + fileName + "']//span[@class='fileactions']//a[@class='action action-menu permanent']")).click();
        details.click();
        comment.click();
        enterComment.sendKeys(comments, Keys.ENTER);
        return Driver.getDriver().findElement(By.xpath("//div[normalize-space()='" + comments + "']")).isDisplayed();
    }


}
