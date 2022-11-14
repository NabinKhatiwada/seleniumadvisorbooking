package com.example.selenium.steps;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.selenium.pages.ClientDashboardPage;
import com.example.selenium.pages.DashboardPage;
import com.example.selenium.runners.Hook;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ClientDashboardSteps {
	@Autowired
	private ClientDashboardPage clientDashboardPage;
	
	@Autowired
	private Hook hook;

	@Then("^client dashboard page is displayed$")
	public void client_dashboard_page_is_displayed() {
		clientDashboardPage.assertResultsArePresent();
	}

	@And("^client section is clicked$")
	public void clientSectionIsClicked() {
		clientDashboardPage.pressClientSectionBtn();
	}
	
	@And("^booking data are displayed")
	public void booking_data_are_displayed() {
		this.clientDashboardPage.assertBookingDataArePresent();
	}
	
	@And("^book first available date$")
	public void setDateText() {
		clientDashboardPage.book(0);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@And("^booking section is clicked$")
	public void booking_section_is_clicked() {
		clientDashboardPage.pressClientBoookingSectionBtn();
	}
	
	@And("^client booking informations are displayed$")
	public void client_booking_informations_are_displayed() {
		clientDashboardPage.assertBookingDataArePresent();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@And("^cancel first booked date$")
	public void cancel_first_booked_date(){
		clientDashboardPage.cancelBook(0);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("^client logout is clicked$")
	public void client_logout_is_clicked() {
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		clientDashboardPage.clickLogoutBtn();
		
		
	}
	
	 @And("^section \"([^\\\"]*)\" is clicked$")
	    public void sectionIsClicked(String cssClass) {
	        clientDashboardPage.sectionIsClicked(cssClass);
	    }
	 
	 @And("^open dropdown for \"([^\\\"]*)\" with msg \"([^\\\"]*)\"$")
	    public void open_dropdown_for_with_msg(String name,String message) {
	        clientDashboardPage.openDropDownFor(name,message);
	    }
	
	
}
