package com.nagwa.pages;

import com.nagwa.base.Base;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends Base {

    public HomePage (){PageFactory.initElements(driver,this);}

    @FindBy (className = "arrow-head-down-icon")
    WebElement languageOptions;

    @FindBy (xpath = "//li[@class='dropdown open']//ul[contains(@class,'languages')]//li")
    public List<WebElement> dropDownLangList;

    @FindBy (xpath = "//button[@type='button']//i[contains(@class,'search-icon')]")
    WebElement beforeSearchButton;

    @FindBy (id="txt_search_query")
    WebElement searchField;

    @FindBy (xpath = "//button[@id='btn_global_search']//i[contains(@class,'search-icon')]" )
    WebElement afterSearchButton;

    public void clickToChooseLanguage(){
        languageOptions.click();
    }

    public SearchPage writeInSearchField(String search){
        beforeSearchButton.click();
        searchField.sendKeys(search);
        afterSearchButton.click();
        return new SearchPage();
    }

    public void selectLang (String lang){

        String selectedLang = lang;
        System.out.println("user select "+selectedLang);

        if (selectedLang.contains("english"))
        {
            dropDownLangList.get(0).click();

        }else if (selectedLang.contains("spanish"))
        {
            dropDownLangList.get(1).click();

        } else if (selectedLang.contains("french"))
        {
            dropDownLangList.get(2).click();
        } else if (selectedLang.contains("portuguese"))
        {
            dropDownLangList.get(3).click();
        }else if (selectedLang.contains("arabic"))
        {
            dropDownLangList.get(4).click();
        }else {
            throw new Error("there is no language selected");
        }

    }
    public void isLanguageSelected(String lang){

        String selectedLang = lang;

        if (selectedLang.contains("english"))
        {
            String langPath = "en";
            String languageUrl = driver.getCurrentUrl();
            System.out.println("Current page url is " + languageUrl);
            Assert.assertEquals(languageUrl,"https://www.nagwa.com/"+langPath+"/");

        }else if (selectedLang.contains("spanish"))
        {
            String langPath = "es";
            String languageUrl = driver.getCurrentUrl();
            System.out.println("Hi from DOM page" + languageUrl);
            Assert.assertEquals(languageUrl,"https://www.nagwa.com/"+langPath+"/");

        } else if (selectedLang.contains("french"))
        {
            String langPath = "fr";
            String languageUrl = driver.getCurrentUrl();
            System.out.println("Hi from DOM page" + languageUrl);
            Assert.assertEquals(languageUrl,"https://www.nagwa.com/"+langPath+"/");
        } else if (selectedLang.contains("portuguese"))
        {
            String langPath = "pt";
            String languageUrl = driver.getCurrentUrl();
            System.out.println("Hi from DOM page" + languageUrl);
            Assert.assertEquals(languageUrl,"https://www.nagwa.com/"+langPath+"/");
        }else if (selectedLang.contains("arabic"))
        {
            String langPath = "ar";
            String languageUrl = driver.getCurrentUrl();
            System.out.println("Hi from DOM page" + languageUrl);
            Assert.assertEquals(languageUrl,"https://www.nagwa.com/"+langPath+"/");
        }else {
            throw new Error("the page did not change language");
       }
    }

    public WebElement getSearchButton(){
        return beforeSearchButton;
    }
}
