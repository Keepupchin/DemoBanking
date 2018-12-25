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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginFunctionalityTest_ByDataprovider {
	
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
		
		String Mid= driver.findElement(By.xpath("//tr[@class=\"heading3\"]//td")).getText();
		System.out.println(Mid);
		
		
	
  }

	@DataProvider(name="dataprovider")
	public Object [][] testdata_provider(){
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="username";
		obj[0][1]="password";
		
		obj[1][0]="$$$123";
		obj[1][1]="nflasf;s,";
		
		obj[2][0]="kdkkdfk";
		obj[2][1]="12345";
		
		return  obj;
		


	}
	
	
	
	
	@Test(dataProvider="dataprovider")
	
	public void LoginFunTest_invalidData2(String username,String password) {
		//Enter invalid User ID and Invalid Password
		driver.findElement(By.name("uid")).clear();
		driver.findElement(By.name("uid")).sendKeys(username);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		
		Util.screenshot(driver);
		
		
		
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


