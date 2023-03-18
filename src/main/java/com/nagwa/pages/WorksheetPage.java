package com.nagwa.pages;

import com.nagwa.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WorksheetPage extends Base {

    public WorksheetPage (){PageFactory.initElements(driver,this);}

    @FindBy(xpath = "//div[@class='one-part-question']")
            public List<WebElement> questions;

    public void getNumberOfQuestions(){
       int numberOfQuestions = questions.size();
        System.out.print("Number of Questions is "+numberOfQuestions);
    }
    }
