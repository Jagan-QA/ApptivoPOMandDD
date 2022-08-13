package apptivoPOMandDD;

import java.io.FileInputStream;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ApptivoMain {

	WebDriver driver;
	String[] Logindata;

	@BeforeSuite
	public void start()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\\\\\\\\\\\\\\\chromedriver_win32\\\\\\\\\\\\\\\\chromedriver.exe");
		driver =  new ChromeDriver();
		driver.get("https://www.apptivo.com/app/login.jsp");
	}

	@DataProvider(name="Pro")
	public String[] dataprovider() throws BiffException, IOException 
	{
		Logindata =fileread();
		return Logindata;
		

	}

	public String [] fileread() throws BiffException, IOException {

		FileInputStream excel = new FileInputStream("C:\\Apptivo Excel\\loginexcel.xls");
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet("Login");
		int RowSize = sheet.getRows();
		int ColoumnSize = sheet.getColumns();
		System.out.println(RowSize);
		System.out.println(ColoumnSize);

		String [] testlogindata = new String [RowSize] ;


		for(int j=1; j<RowSize; j++)
		{
			for (int i=0; i<ColoumnSize; i++) 
			{

				testlogindata[i]=sheet.getCell(j, i).getContents();
			}
		}
		System.out.println(testlogindata);
		return testlogindata;

	}

	@Test(dataProvider = "Pro")
	public void login(String usrname, String Pswd) 
	{
		LoginPageAttributes.Username(driver).sendKeys(usrname);
		LoginPageAttributes.Password(driver).sendKeys(Pswd);
		LoginPageAttributes.Submit(driver).click();
	}

}
