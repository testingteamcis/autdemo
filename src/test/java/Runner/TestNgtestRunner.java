package Runner;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.AfterSuite;

	import org.testng.annotations.DataProvider;

	import io.cucumber.testng.AbstractTestNGCucumberTests;
		import io.cucumber.testng.CucumberOptions;
		
		@CucumberOptions(features="src/test/java/feature/placevalidations.feature",glue="StepDefinitions",tags="@Addplace",monochrome=true,plugin= {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

		

		public class TestNgtestRunner extends AbstractTestNGCucumberTests  {

		//	public static void main(String[] args) {
			@Override
			@DataProvider(parallel=false) 
			
			public Object[][] scenarios()
			{
				return super.scenarios();
			}
			

		}	


