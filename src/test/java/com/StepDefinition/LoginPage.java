package com.StepDefinition;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Runner.TestRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginPage {
	@Given("^Open Application and Enter url$")
	public void open_Application_and_Enter_url() throws Throwable {
	  TestRunner.driver.get("https://demo.openmrs.org/openmrs/login.htm");
	  
	}
 
	@When("^enter username$")
	public void enter_username() throws Throwable {
		TestRunner.driver.findElement(By.id("username")).sendKeys("Admin");
	}
 
	@When("^enter password$")
	public void enter_password() throws Throwable {
		TestRunner.driver.findElement(By.id("password")).sendKeys("Admin123");
		TestRunner.driver.findElement(By.id("Inpatient Ward")).click();
		TestRunner.driver.findElement(By.id("loginButton")).click();
	}
 
	@Then("^verify Msg$")
	public void verify_Msg() throws Throwable {
	   boolean result =  TestRunner.driver.findElement(By.tagName("h4")).getText().contains("Logged");
	   Assert.assertTrue(result);
	}

}
