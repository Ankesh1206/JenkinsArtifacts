package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UITest {

	@Parameters("Browser")
	@Test
	public void startBrowser(String browserName) {

		WebDriver driver = null;
		System.out.println("Parameter value is "+browserName);
		
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.contains("Edge")) {
			WebDriverManager.edgedriver().browserVersion("91.0.864.59").setup();
			driver = new EdgeDriver();
		}
		else if (browserName.contains("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.contains("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("No browser specified :(");
			}
		System.out.println("Parameter value is "+browserName);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		System.out.println("Parameter value is "+browserName);
		Assert.assertTrue(driver.getTitle().contains("Orange"), "Title does not match");
		System.out.println("Parameter value is "+browserName);
		driver.quit();
	}
}
