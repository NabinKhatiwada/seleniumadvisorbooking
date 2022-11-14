package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.selenium.helpers.VisibilityHelper;

@Component
public class ResultsPage implements BasePage {

    private static final String RESULTS_LOCATOR = "#links [data-testid='result']";
 

    @Autowired
    private VisibilityHelper visibilityHelper;


    public void assertResultsArePresent(){
        visibilityHelper.waitForPresenceOf(By.cssSelector(RESULTS_LOCATOR));
    }


	public void assertHomePagePresent() {
		visibilityHelper.waitForPresenceOf(By.cssSelector(".login-content"));
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
   
}