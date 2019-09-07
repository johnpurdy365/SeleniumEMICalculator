package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	//This method returns a webdriver object
	public static WebDriver open(String browserType) {
		if(browserType.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\software\\chromedriver.exe");
			return new ChromeDriver();
		}else if(browserType.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", "C:\\software\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
		else {
			System.setProperty("webdriver.gecko.driver", "C:\\software\\geckodriver.exe");
			return new FirefoxDriver();
		}
	}

}
