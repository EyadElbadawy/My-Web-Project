package steps;

import com.nagwa.base.Base;
import com.nagwa.pages.HomePage;
import com.nagwa.pages.LessonPage;
import com.nagwa.pages.SearchPage;
import com.nagwa.pages.WorksheetPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.rules.Timeout;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class S01_SearchSteps extends Base {

    HomePage homePage;
    SearchPage searchPage;
    LessonPage lessonPage;
    WorksheetPage worksheetPage;


    @Given("user open the website")
    public void userOpenTheWebsite() {
        lunchBrowser();
        homePage = new HomePage();
    }

    @Given("user select {string} language")
    public void userSelectLanguage(String lang) {
        homePage. clickToChooseLanguage();
        homePage.selectLang(lang);
    }

    @When("user write {string} in search field")
    public void userSearch(String search) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(homePage.getSearchButton()));
        searchPage = homePage.writeInSearchField(search);
    }

    @When("user select second search result {string}")
    public void userSelectSecondSearchResult(String search) {
        searchPage.isSearchPageDisplayed(search);
        searchPage.numberOfSearchResults();
        lessonPage = searchPage.clickSecondResult();
    }

    @When("user go to worksheet section")
    public void userGoToWorksheetSection(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(lessonPage.getWorkSheetSection()));
        worksheetPage=lessonPage.clickOnWorkSheetSection();
    }

    @Then("questions displayed")
    public void questionsDisplayed() {
        worksheetPage.getNumberOfQuestions();
    }




}
