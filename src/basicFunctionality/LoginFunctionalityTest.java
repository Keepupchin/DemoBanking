package basicFunctionality;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFunctionalityTest {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void setup() throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.demo.guru99.com/V4/");
		Thread.sleep(5000);
		}
	
	
	
	@Test
	@Parameters({"userid","password"})

	
	public void LoginFunTest( String userid,String password) { // =================Valid======================
		
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(userid);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		String actual_title = driver.getTitle();
		System.out.println("Actual title ="+actual_title);
		assertEquals(actual_title, "Guru99 Bank Manager HomePage");
		
		
	
  }
	
	
	@Test
	
	public void LoginFunTest_invalidData() { // =================InValid======================
		//Enter valid User ID and invalid Password
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys("mngr161216");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("sdDNADNA");
		driver.findElement(By.name("btnLogin")).click();
		

			Alert alert = driver.switchTo().alert();
			String popMsg = alert.getText();
			
			System.out.println("Popup message ="+popMsg);
			alert.accept();
			
		}
		

		
		
		
	
  
	
	@Test
	
	public void LoginFunTest_invalidData1() {
		//Enter invalid User ID and valid Password
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys("$$$$$123");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("AmUqebE");
		driver.findElement(By.name("btnLogin")).click();
		
		
		
		Alert alert = driver.switchTo().alert();
		String popMsg = alert.getText();
		
		System.out.println("Popup message ="+popMsg);
		alert.accept();
		
		
	
  }
	
@Test
	
	public void LoginFunTest_invalidData2() {
		//Enter invalid User ID and Invalid Password
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys("$$$$$123");
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("dcZc");
		driver.findElement(By.name("btnLogin")).click();
		
		
		
		Alert alert = driver.switchTo().alert();
		String popMsg = alert.getText();
		
		System.out.println("Popup message ="+popMsg);
		alert.accept();
		
		
	
  }
	
	@AfterMethod
	
	public void teardown() {
		

		  driver.manage().deleteAllCookies();
		  driver.close();
	}
	
	
	  
	
}


