package steps;

import com.nagwa.base.Base;
import com.nagwa.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class S02_LanguagesSteps extends Base {

    HomePage homePage= new HomePage();


    @When("user select {string}")
    public void userSelectALanguage(String lang){
        homePage.clickToChooseLanguage();
        homePage.selectLang(lang);

    }

    @Then("the {string} is selected")
    public void theIsSelected(String lang) {
        homePage.isLanguageSelected(lang);

    }
}
