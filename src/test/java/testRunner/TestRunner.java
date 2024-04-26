package testRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		
		features= {"src/test/resources/features"},
		//features= {"@target/rerun.txt"},
		glue="stepDefinitions",
		plugin= {"pretty", "html:reports/myreport.html", 
				 "rerun:target/rerun.txt",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				},
				
		dryRun=false,    // checks mapping between scenario steps and step definition methods
		monochrome=true,    // to avoid junk characters in output
		publish=true,   // to publish report in cucumber server
		tags="@functional"
		//tags="@regression"
		//tags="@smoke"
		
		
)

public class TestRunner extends AbstractTestNGCucumberTests
{	
}
