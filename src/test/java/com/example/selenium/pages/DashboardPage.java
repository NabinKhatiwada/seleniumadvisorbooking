package com.example.selenium.pages;

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
public class DashboardPage implements BasePage {
	private static final String DASHBOARD_ROOT_CLASS = ".makeStyles-root-2";
	private static final String REACT_DATEPICKER_CLASS = ".react-datepicker-popper";

	@FindBy(how = How.CSS, using = "#advisor_section")
	private WebElement advisorSectionBtn;
	
	@FindBy(how = How.CSS, using = "div.react-datepicker__input-container input[type = 'text']")
	private WebElement appointmentDateInput;
	
	@FindBy(how = How.CSS, using = ".react-datepicker__day--009")
	private WebElement dateInuput;
	
	@FindBy(how = How.CSS, using = "#advisor_submit_btn")
	private WebElement advisorSubmitBtn;
	
	@FindBy(how = How.CSS, using = "#btn_logout")
	private WebElement logoutBtn;
	
	
	
	@Autowired
	private Hook hook;


	@Autowired
	private VisibilityHelper visibilityHelper;

	public void assertResultsArePresent() {
		visibilityHelper.waitForPresenceOf(By.cssSelector(DASHBOARD_ROOT_CLASS));
	}
	
	public void pressAdvisorSectionBtn() {
		advisorSectionBtn.click();
	}
	
	public void inputAppointmentDT() {
		appointmentDateInput.click();
//		appointmentDateInput.sendKeys("05 Nov 2022 3:50 PM");
	}
	
	public void assertReactDatePickerPresent() {
		visibilityHelper.waitForPresenceOf(By.cssSelector(REACT_DATEPICKER_CLASS));
	}
	
	public void inputDateTxt(String date) {
		Integer intTime = Integer.parseInt(date);
		
		String cssDate = intTime < 10 ? "00"+date : "0" + date;
		WebElement element = hook.getDriver().findElement(By.cssSelector(".react-datepicker__day--"+cssDate));
		element.click();
	}
	
	public void inputTimeTxt(String time) {
		
		
		WebElement timeList = hook.getDriver().findElement(By.cssSelector("div.react-datepicker__time-box > ul"));
		List<WebElement> links = timeList.findElements(By.tagName("li"));
		for (int i = 1; i < links.size(); i++)
		{
			
		    String txt = links.get(i).getText();
		    if(txt.trim().equals(time)) {
		    	links.get(i).click();
		    	break;
		    }
		}
	}

	public void clickSubmitBtn() {
		advisorSubmitBtn.click();
	}
	
	public void clickLogoutBtn() {
		logoutBtn.click();
	}
	
	
}
