package com.inetBanking.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentSetup {

	public static ExtentReports setUpExtentReport() {

		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				"./Reports/ExecutionReport_" + getActualDate() + ".html");
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

		extentSparkReporter.config().setDocumentTitle("InetBankingV1");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setReportName("First Report");

		return extentReports;
	}

	public static String getActualDate() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = simpleDateFormat.format(date);
		return actualDate;
	}

}
