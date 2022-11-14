package com.example.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.selenium.helpers.VisibilityHelper;

@Component
public class SearchPage implements BasePage {

	@FindBy(how = How.CSS, using = "#login_btn")
	private WebElement searchButton;

	@FindBy(how = How.NAME, using = "identifier")
	private WebElement userNameInput;
	
	@FindBy(how = How.CSS, using = ".nCP5yc")
	private WebElement nextButton;
	
	@FindBy(how = How.NAME, using = "password")
	private WebElement passwordInput;
	
	@FindBy(how = How.ID, using = "passwordNext")
	private WebElement passwordNextButton;
	
	@Autowired
    private VisibilityHelper visibilityHelper;

	public void pressLoginBtn() {
		searchButton.click();
	}
	
	public void inputUserName(String userName) {
		userNameInput.sendKeys(userName);
	}
	
	public void pressNext() {
		nextButton.click();
		
	}
	
	public void inputPassword(String pwd) {
		By by = By.name("password");
		visibilityHelper.waitForPresenceOf(by);
		passwordInput.sendKeys(pwd);
	}

	public void pressPasswordNext() {
		passwordNextButton.click();
	}
}