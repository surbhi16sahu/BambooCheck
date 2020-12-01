package step_definition;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertTrue;

public class tepDef {

	public static WebDriver driver;

	@Given("^user browse Url$")
	public void userBrowseUrl() {
		System.setProperty("webdriver.chrome.driver", "D:\\Projects\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("^user will enter username \"([^\"]*)\"$")
	public void userProvideUsername(String username) {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		System.out.println("Entered username");
	}

	@When("^user will enter password \"([^\"]*)\"$")
	public void userProvidePassword(String password) {
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		System.out.println("Entered password");
	}

	@Then("^user validates login$")
	public void writeDataToExcel() throws InterruptedException {
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5);
		System.out.println("Clicked login");
		Boolean checkTitle = driver.findElement(By.xpath("//h1[text()='Dashboard']")).isDisplayed();
		assertTrue("Dashboard is visible", checkTitle);
		Thread.sleep(5);
	}

	@SuppressWarnings("deprecation")
	@After
	public void killBrowser(Scenario scenario) throws IOException {
		scenario.write("Current Page URL is " + driver.getCurrentUrl());

		try {
			if (scenario.isFailed()) {
	            
	        	scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES), "image/png");
			}
		} finally {
			driver.close();
		}
	}

}
