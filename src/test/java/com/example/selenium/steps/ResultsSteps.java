package com.example.selenium.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.selenium.pages.ResultsPage;
import com.example.selenium.runners.Hook;

public class ResultsSteps {

    @Autowired
    private ResultsPage resultsPage;
    
    @Autowired
    private Hook hook;
    
    @Then("^login page reached$")
    public void login_page_reached() {
        resultsPage.assertHomePagePresent();
    }
    
    @And("^close browser")
    public void close_browser() {
//    	 this.hook.getDriver().close();
//    	this.hook.restartDriver();
    	this.hook.getDriver().manage().deleteAllCookies();    
    }
    
//    @And("open browser")
//    public void open_browser() {
////    	this.hook.initialize();
////    	this.hook.initialiseDriver();
//    	
//    	try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
////    	this.hook.initialiseDriver();
//    }
    
    @Then("^client login page reached$")
    public void client_login_page_reached() {
        resultsPage.assertHomePagePresent();
    }
}
