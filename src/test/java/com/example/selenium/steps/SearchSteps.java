package com.example.selenium.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.selenium.pages.SearchPage;

public class SearchSteps {

    @Autowired
    private SearchPage searchPage;

    @Given("^a user presses the login button$")
    public void aUserPressesTheLoginButton() {
        searchPage.pressLoginBtn();
    }
    
    @When("^advisor name \"([^\\\"]*)\" in the input$")
    public void advisorNameInTheInput(String searchValue) {
        searchPage.inputUserName(searchValue);
    }
    
    @And("^click next button$")
    public void clickNextButton() {
        searchPage.pressNext();
    }
    
    @And("^an advisor password \"([^\\\"]*)\" in the input$")
    public void anAdvisorPasswordInTheInput(String password) {
        searchPage.inputPassword(password);
    }
    
    @And("^advisor click next button$")
    public void advisorClickNextButton() {
        searchPage.pressPasswordNext();
    }
    
    
}
