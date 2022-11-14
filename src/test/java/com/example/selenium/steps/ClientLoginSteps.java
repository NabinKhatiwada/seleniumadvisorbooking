package com.example.selenium.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.selenium.pages.ClientLoginPage;
import com.example.selenium.pages.SearchPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ClientLoginSteps {
	    @Autowired
	    private ClientLoginPage loginPage;

	    @Given("^a client presses the login button$")
	    public void aClientPressesTheLoginButton() {
	        loginPage.pressLoginBtn();
	    }
	    
	    @When("^client name \"([^\\\"]*)\" in the input$")
	    public void clientNameInTheInput(String searchValue) {
	        loginPage.inputUserName(searchValue);
	    }
	    
	    @And("^client click username next button$")
	    public void clientClickUsernameNextButton() {
	        loginPage.pressNext();
	    }
	    
	    @And("^a client password \"([^\\\"]*)\" in the input$")
	    public void aClientPasswordInTheInput(String password) {
	        loginPage.inputPassword(password);
	    }
	    
	    @And("^client click password next button$")
	    public void clientClickPasswordNextButton() {
	        loginPage.pressPasswordNext();
	    }
}
