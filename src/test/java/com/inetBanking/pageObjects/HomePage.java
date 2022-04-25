package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver ldriver;

	By linkLogout = By.linkText("Log out");

	public HomePage(WebDriver rdriver) {
		ldriver = rdriver;
	}

//	Action Methods
	public String getTitle() {
		return ldriver.getTitle();
	}

	public void clickLogout() {
		ldriver.findElement(linkLogout).click();
	}

}
