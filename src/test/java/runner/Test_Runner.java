package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber; 
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features/", 
							glue= {"Step_Definations"},
							dryRun =false,
							monochrome = true,
							plugin = {"pretty", "html:target/HtmlReports/report.html" }	//for html report
//						plugin = {"pretty","json:target/JsonReports/report.json" }			//for json report
						//plugin = {"pretty", "junit:target/Junit/report.xml" }						//for xml report
							
//							tags = "@smoketest"
						
											)
														

public class Test_Runner {

}

