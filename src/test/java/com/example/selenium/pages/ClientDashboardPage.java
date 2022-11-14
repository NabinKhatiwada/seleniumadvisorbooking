package com.example.selenium.pages;

import java.time.LocalTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.selenium.helpers.VisibilityHelper;
import com.example.selenium.runners.Hook;

@Component
public class ClientDashboardPage implements BasePage {
	private static final String DASHBOARD_ROOT_CLASS = ".makeStyles-root-2";

	@FindBy(how = How.CSS, using = "#client_section")
	private WebElement clientSectionBtn;
	
	@FindBy(how = How.CSS, using = "#client_booking")
	private WebElement clientBookingBtn;

	@FindBy(how = How.CSS, using = "#btn_logout")
	private WebElement logoutBtn;
	
	@FindBy(how = How.CSS, using = ".Dropdown-root")
	private WebElement dropDownMenuBtn;
	
	@FindBy(how = How.CSS, using = ".Dropdown-menu")
	private WebElement dropDownOptions;
	
	

	@Autowired
	private Hook hook;

	@Autowired
	private VisibilityHelper visibilityHelper;

	public void assertResultsArePresent() {
		visibilityHelper.waitForPresenceOf(By.cssSelector(DASHBOARD_ROOT_CLASS));
	}

	public void pressClientSectionBtn() {
		clientSectionBtn.click();
	}

	public void assertBookingDataArePresent() {
		visibilityHelper.waitForPresenceOf(By.cssSelector(".MuiDataGrid-virtualScrollerRenderZone"));
	}

	public void book(int index) {
		List<WebElement> links = hook.getDriver().findElements(By.cssSelector(".book"));
		if(links != null && links.size() > 0) {
			links.get(index).click();
		}
	
	}
	
	public void pressClientBoookingSectionBtn() {
		clientBookingBtn.click();
	}



	public void clickLogoutBtn() {
		logoutBtn.click();
	}

	public void cancelBook(int index) {
		List<WebElement> links = hook.getDriver().findElements(By.cssSelector(".cancel_book"));
		if(links != null && links.size() > 0) {
			links.get(index).click();
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			hook.getDriver().switchTo().alert().accept();
		}
	}

	public void sectionIsClicked(String cssId) {
		WebElement webElement = hook.getDriver().findElement(By.id(cssId));
		webElement.click();
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	public void openDropDownFor(String name,String message) {
		visibilityHelper.waitForVisibilityOf(dropDownMenuBtn);
		WebElement dropdown = hook.getDriver().findElement(By.cssSelector(".Dropdown-root"));
		dropdown.click();
		
		
		visibilityHelper.waitForVisibilityOf(dropDownOptions);
		
		List<WebElement> links = hook.getDriver().findElements(By.cssSelector(".Dropdown-option"));
		for(WebElement link : links) {
			if(link.getText().equalsIgnoreCase(name)) {
				link.click();
				
				WebElement element = hook.getDriver().findElement(By.name("message"));
				element.sendKeys(message);
				
				WebElement submitElement = hook.getDriver().findElement(By.className("chat_submit"));
				submitElement.click();
				
				break;
			}
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}