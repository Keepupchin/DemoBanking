package basicFunctionality;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testing {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void setup() throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.demo.guru99.com/V4/");
		//driver.get("http://www.demo.guru99.com/V4/manager/Managerhomepage.php");
		}
	
	
	
	@Test
	public void LoginFunTest() { // =================Valid======================
		
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys("mngr161216");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("AmUqebE");
		driver.findElement(By.name("btnLogin")).click();
		
		String actual_title = driver.getTitle();
		System.out.println("Actual title ="+actual_title);
		assertEquals(actual_title, "Guru99 Bank Manager HomePage");
		
		String Mid= driver.findElement(By.xpath("//tr[@class=\"heading3\"]//td")).getText();
		System.out.println(Mid);
		System.out.println(Mid.length());
		

		
		

		 }
		
		
		
  

	
	
	
	@AfterMethod
	
	public void teardown() {
		

		  driver.manage().deleteAllCookies();
		  driver.close();
	}
	
	
	  
	
}


/*
 * String[] parts = Mid.split(":");
		String dynamicText = parts[1];

		// Check that the dynamic text is of pattern mngrXXXX
		// First 4 characters must be "mngr"
		assertTrue(dynamicText.substring(1, 5).equals("mngr"));
		// remain stores the "XXXX" in pattern mngrXXXX
		String remain = dynamicText.substring(dynamicText.length() - 4);
		// Check remain string must be numbers;
		assertTrue(remain.matches("[0-9]+"));
		
		
 *  */
