package com.inetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.HomePage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.ReportingListener;

@Listeners(ReportingListener.class)
public class TC_LoginTest_001 extends BaseTestClass {

	String exp_title = " Guru99 Bank Manager HomePage ";

	LoginPage lp;
	HomePage hp;

	@Test
	public void loginTest() throws InterruptedException {
		logger.info("Inside loginTest");
		lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		hp = lp.clickSubmit();
		logger.info("Clicked Submit");
		String act_title = hp.getTitle();

		if (act_title.equals(exp_title.trim())) {
			System.out.println("Login Successful");
			logger.info("Login Successful");
			logger.info("------------");
			Assert.assertTrue(true);
		} else {
			System.out.println("Login Failed");
			logger.info("Login Failed");
			logger.info("------------");
			Assert.assertTrue(false);
		}
	}

}
