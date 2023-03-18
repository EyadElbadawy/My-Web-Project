package com.nagwa.pages;

import com.nagwa.base.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends Base {

    public SearchPage (){PageFactory.initElements(driver,this);}


    @FindBy(xpath = "//li//div[@class='right']//a")
    public List<WebElement> searchResults;

    public void isSearchPageDisplayed(String search){
        String additionSearchUrl = driver.getCurrentUrl();
        System.out.println("current search page url " + additionSearchUrl);
      Assert.assertEquals(additionSearchUrl,"https://www.nagwa.com/en/search/?q="+search);

    }

    public void numberOfSearchResults(){
        int numberOfResults = searchResults.size();
        System.out.println("The Number Of Search Results is "+numberOfResults);
    }

    public LessonPage clickSecondResult(){
        searchResults.get(1).click();
        return new LessonPage();
    }


}
