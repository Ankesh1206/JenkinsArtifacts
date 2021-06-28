package mavenforjenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class UITest {

	@Parameters("Browser")
	@Test
	public void startBrowser(String browserName) {
		System.out.println("Parameter value is "+browserName);
		WebDriver driver = null;
		if(browserName.contains("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.contains("Edge")) {
			WebDriverManager.edgedriver().browserVersion("91.0.864.59").setup();
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com");
		Assert.assertTrue(driver.getTitle().contains("Orange"), "Title doesnot match");
		driver.quit();
	}
}
