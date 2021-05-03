package runner;


import cucumber.api.CucumberOptions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import utility.ReportHelper;
import java.io.IOException;


@CucumberOptions(strict = true, monochrome = true, features = "Features/UITest",
		glue = "StepFiles", plugin = {"pretty", "json:target/cucumber.json"}
		, tags = {"@TestNGScenarios"})

public class TestRunner extends AbstractTestNGCucumberParallelTests {

	@AfterSuite(alwaysRun = true)
	public void generateHTMLReports() throws IOException {
		ReportHelper.generateCucumberReport();
	}

	private static long duration;

	@BeforeClass
	public static void before() {
		duration = System.currentTimeMillis();
		System.out.println("Thread Id  | Scenario Num       | Step Count");
	}

	@AfterClass
	public static void after() {
		duration = System.currentTimeMillis() - duration;
		System.out.println("DURATION - "+ duration);
	}
	
}

