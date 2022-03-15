package common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
public static WebDriver driver;

	
	
  @Parameters("browser")
  @BeforeClass
  public void browser_config(String brow) {
	  if(brow.equals("firefox"))
	  { 
	  WebDriverManager.firefoxdriver().setup();
	  
	  driver= new FirefoxDriver();
	  }
	  else if(brow.equals("chrome")){
	  //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\Driver\\geckodriver.exe");
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  }
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
  }

  
  
  @Test
  public void login() throws IOException 
	{
		driver.get("http://demo.guru99.com/V4/");

		WebElement Email=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[1]/td[2]/input"));

		WebElement Password=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input"));

		WebElement LoginBtn=driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]"));

		Email.sendKeys("mngr292055");
		Password.sendKeys("yqYvyde");
		LoginBtn.click();

		String ExpectedsuccesMessage=" Manger Id : mngr292055";

		String ActualMes= driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")).getText();

		if(ExpectedsuccesMessage.contains(ActualMes))	
		{
		
			System.out.println("Test Case passed");
		}

		else {
			System.out.println("Test case failed.Bug found");
		}

		 driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[5]/a")).click();
      
	}

  
 
  //public void captureScreen(WebDriver driver, String name) throws IOException
	//{
		//TakesScreenshot ts=(TakesScreenshot)driver;
		//File source=ts.getScreenshotAs(OutputType.FILE);
		//File target=new File(System.getProperty("user.dir")+"/ScreenShots/"+ name + ".png");		
		//FileUtils.copyFile(source, target);
		//System.out.println("Screnshots");
				
	//}
}
