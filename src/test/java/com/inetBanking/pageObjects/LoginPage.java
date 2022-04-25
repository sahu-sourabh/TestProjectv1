package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

//	Instance Variables
	WebDriver ldriver;

	By txtUserName = By.name("uid");
	By txtPassword = By.name("password");
	By btnLogin = By.name("btnLogin");

//	Constructor
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
	}

//	Action Methods
	public void setUserName(String uname) {
		ldriver.findElement(txtUserName).sendKeys(uname);
	}

	public void setPassword(String pwd) {
		ldriver.findElement(txtPassword).sendKeys(pwd);
	}

	public HomePage clickSubmit() {
		ldriver.findElement(btnLogin).click();
		return new HomePage(ldriver);
	}

}
