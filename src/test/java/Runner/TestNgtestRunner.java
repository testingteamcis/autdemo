package Runner;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import junit.textui.TestRunner;
		
		@CucumberOptions(features="src/test/java/feature/placevalidations.feature",glue="StepDefinitions",tags="@Addplace",monochrome=true,plugin= {"html:target/cucumber.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

		

		public class TestNgtestRunner extends AbstractTestNGCucumberTests  {
			
			static {
				try(InputStream input = TestRunner.class.getClassLoader().getResourceAsStream("extent.properties")){
					
					if(input==null) {
						
						System.err.println("Error: extent.properties is not found !");
						
					}else {
						Properties prop = new Properties();
						prop.load(input);
						System.out.println("DEBUG: extent.properties loaded succeessfully!");
					}
					
				} catch (IOException e) {
					System.err.println("Error:Failed to load extent.properties -" +e.getMessage());
				}
			}

		//	public static void main(String[] args) {
			@Override
			@DataProvider(parallel=false) 
			
			public Object[][] scenarios()
			{
				return super.scenarios();
			}
			

		}	


