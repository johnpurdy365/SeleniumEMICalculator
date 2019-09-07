package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EMICalculator {

	WebDriver driver;

	@Test
	public void LoanEmiCalculator() throws InterruptedException {

		System.out.println("Running the test");
		//identify web elements
		WebElement amountSlider = driver.findElement(By.cssSelector("#loanamountslider >span"));
		WebElement rateSlider = driver.findElement(By.cssSelector("#loaninterestslider >span"));
		WebElement tenureSlider = driver.findElement(By.cssSelector("#loantermslider >span"));
		WebElement loanEmiAmount = driver.findElement(By.cssSelector("#emiamount > p > span"));

		//use actions class to enable drag and drop
		Actions actions = new Actions(driver);

		//get source and target to drag and drop
		actions.dragAndDropBy(amountSlider, 83, 0).build().perform();
		Thread.sleep(2000);

		actions.dragAndDropBy(rateSlider, 87, 0).build().perform();
		Thread.sleep(2000);

		actions.dragAndDropBy(tenureSlider, -111, 0).build().perform();
		Thread.sleep(2000);

		//Assert Loan Emi Amount is as expected
		String expectedText = loanEmiAmount.getText();
		Assert.assertEquals(expectedText, "92,439");

	}

	@BeforeMethod
	public void setup() {

		System.out.println("Setting up the test");
		String browserType = "chrome";
		driver = utilities.DriverFactory.open(browserType);
		driver.manage().window().maximize();
		String WebUrl = "https://emicalculator.net/";
		driver.get(WebUrl);
	}


	@AfterMethod
	public void teardown() {
		System.out.println("Closing test");
		driver.close();
	}

}
