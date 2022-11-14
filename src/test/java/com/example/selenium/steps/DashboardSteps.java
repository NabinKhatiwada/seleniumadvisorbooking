package com.example.selenium.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.selenium.pages.DashboardPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DashboardSteps {

	@Autowired
	private DashboardPage dashboardPage;

	@Then("^dashboard page is displayed$")
	public void resultsAreDisplayed() {
		dashboardPage.assertResultsArePresent();
	}

	@And("^advisor section is clicked$")
	public void advisorSectionIsClicked() {
		dashboardPage.pressAdvisorSectionBtn();
	}
	
	@And("^appointment date is set$")
	public void appointmentDateIsSet() {
		dashboardPage.inputAppointmentDT();
		
	}
	
	@And("^wait for datepicker$")
	public void waitForDatepicker() {
		dashboardPage.assertReactDatePickerPresent();
		
	}
	
	@And("^set date \"([^\\\"]*)\" text$")
	public void setDateText(String date) {
		dashboardPage.inputDateTxt(date);
		
	}
	
	@And("^set time \"([^\\\"]*)\" text$")
	public void setSetTimeText(String time) {
		dashboardPage.inputTimeTxt(time);
		
	}
	
	@And("^click submit button$")
	public void clickSubmitButton() {
		dashboardPage.clickSubmitBtn();
		
	}
	
	@Then("^logout is clicked$")
	public void logout_is_clicked() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dashboardPage.clickLogoutBtn();
	}
	
	
	
	
	
}
