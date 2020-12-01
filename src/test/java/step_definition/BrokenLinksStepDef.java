package step_definition;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.cucumber.utils.BrokenLinks;

import io.cucumber.java.en.Given;

public class BrokenLinksStepDef extends BrokenLinks{

	@Given("^user will enter url and validate the links$")
	public void readUrlAndCheckLinks() {
		System. setProperty("webdriver.chrome.driver", "D:\\Projects\\Drivers\\chromedriver.exe");
		// Initialize browser.
		WebDriver driver=new ChromeDriver();

		driver.get("https://blueconchtech.com/digital-next/");

		// ff.get("http://www.yahoo.com/");

		List<WebElement> allImages = findAllLinks(driver);

		System.out.println("Total number of elements found " + allImages.size());

		for (WebElement element : allImages) {

			try

			{

				System.out.println("URL: " + element.getAttribute("href") + " returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))));

				// System.out.println("URL: " +
				// element.getAttribute("outerhtml")+ " returned " +
				// isLinkBroken(new URL(element.getAttribute("href"))));

			}

			catch (Exception exp)

			{

				System.out.println(
						"At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());

			}

		}

	}

}
