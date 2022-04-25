package com.inetBanking.testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetBanking.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTestClass {

	ReadConfig readConfig = new ReadConfig();

	protected String baseURL = readConfig.getURL();
	protected String username = readConfig.getUsername();
	protected String password = readConfig.getPassword();
	protected static WebDriver driver;
	protected static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUp(String br) {
		logger = LogManager.getLogger("inetBanking");
		logger.info("setUp");

		if (br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Incorrect browser value: " + br);
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseURL);
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//button[@id='details-button']")).click();
//		driver.findElement(By.linkText("Proceed to demo.guru99.com (unsafe)")).click();
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
