package com.nagwa.pages;

import com.nagwa.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LessonPage extends Base {

    public LessonPage (){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//a[normalize-space()='Lesson Worksheet']")
    WebElement workSheetSection;

    public WorksheetPage clickOnWorkSheetSection(){
        workSheetSection.click();
        return new WorksheetPage();
    }
    public WebElement getWorkSheetSection(){
        return workSheetSection;
    }


}
