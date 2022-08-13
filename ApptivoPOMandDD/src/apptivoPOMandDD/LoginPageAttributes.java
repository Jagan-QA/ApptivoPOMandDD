package apptivoPOMandDD;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageAttributes {


	public static WebElement Username(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Username=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='userName']")));
		return Username;
		//WebElement Username=driver.findElement(By.xpath("//input[@name='userName']"));

	}
	public static WebElement Password( WebDriver driver)
	{
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Password=wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
		//WebElement Password = driver.findElement(By.xpath("//input[@type='password']"));
		return Password;
	}

	public static WebElement Submit (WebDriver driver) {
		//WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement Submit=wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Sign In']")));
		WebElement Submit = driver.findElement(By.xpath("//button[@title='Sign In']"));
		return Submit;

	}

}
