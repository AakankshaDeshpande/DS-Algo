package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="\\C:\\Users\\Ashis\\DSAlgo\\NumpyAlgo\\src\\test\\java\\Features", 
		glue={"StepDefinitions"},
		monochrome=true,//display the console output in a proper readable format
		plugin= {"pretty","html:target/cucumber.html","json:json_output/cucumber.json","junit:junit_xml/cucumber.xml"},//different types of reporting
		dryRun=true)//it will mapping is proper between feature file and step definition file
public class TestRunner extends AbstractTestNGCucumberTests {

}
