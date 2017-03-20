/**
 * Copyright (c) 2017 by QA Team of Wemakeprice. All Rights Reserved.
 * 
 * Permission to use, copy, modify, and distribute this software and its documentation for
 * educational, research, and not-for-profit purposes, without fee and without a signed licensing agreement,
 * is hereby granted, provided that the above copyright notice appears in all copies, modifications, and distributions.
 */

package Extentreports;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.screenshot;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.close;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.google.gson.LongSerializationPolicy;

/**
 * @author June, Ahn
 *
 */
public class TestCase2 {
	ExtentReports extent;
	ExtentTest test;
//	WebDriver driver;

	@BeforeClass
	public void before() {
		extent = ExtentManager.GetExtent();
	}

	@Test
	public void testCase2() throws IOException {
		test = extent.createTest("TestCase2");

		System.setProperty("webdriver.chrome.driver", "/Users/we/git/SeleniumTest/Driver/chromedriver");
		System.setProperty("selenide.browser", "Chrome");
		test.pass("[Start]");

		open("http://www.wemakeprice.com/");
		test.pass("[PASS] 웹 브라우저 Open");

		$(By.linkText("다시 보지 않기")).click();

		// 로그인 버튼 선택
		$(By.id("loginBtn")).click();
		test.pass("[Pass] 로그인 버튼 선택 ");

		// ID 입력
		$(By.id("login_uid")).setValue("dkswnsanjun");
		test.pass("[Pass] ID 입력").addScreenCaptureFromPath(screenshot("my_file_name"));

	}

	@AfterMethod
	public void tearDown(ITestResult result)
	{
		extent.flush();
		close();
	}
}
