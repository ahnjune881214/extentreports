/**
 * Copyright (c) 2017 by QA Team of Wemakeprice. All Rights Reserved.
 * 
 * Permission to use, copy, modify, and distribute this software and its documentation for
 * educational, research, and not-for-profit purposes, without fee and without a signed licensing agreement,
 * is hereby granted, provided that the above copyright notice appears in all copies, modifications, and distributions.
 */

package Extentreports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * @author June, Ahn
 *
 */
public class ExtentManager {
	private static ExtentReports extent;
	private static ExtentTest test;
	private static ExtentHtmlReporter htmlReporter;
	private static String filePath = "./extentreport.html";
	
	
	public static ExtentReports GetExtent(){
		if (extent != null)
			return extent; 
			extent = new ExtentReports();		
			extent.attachReporter(getHtmlReporter());
			return extent;
	}
 
	private static ExtentHtmlReporter getHtmlReporter() {
        htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("QAV automation report");
		htmlReporter.config().setReportName("Regression cycle");
        return htmlReporter;
	}
	
	public static ExtentTest createTest(String name, String description){
		test = extent.createTest(name, description);
		return test;
	}
}
