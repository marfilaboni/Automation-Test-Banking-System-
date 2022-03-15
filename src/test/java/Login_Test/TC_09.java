package Login_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.Base;

public class TC_09 extends Base {
  @Test(description="Reset Button")
  public void login_invalid_7() throws IOException 
	{
	    WebElement cust_id=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input"));
	    Select s = new Select (driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td[2]/select")));
		WebElement deposit=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"));
		WebElement reset=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));

		cust_id.sendKeys("1982");
		s.selectByVisibleText("Current");
		deposit.sendKeys("50");
		reset.click();

		String ExpectedsuccesMessage="Intial deposite must be Rs. 500 or more";
		//String k=driver.switchTo().alert().getText();	
		
		String k= driver.findElement(By.id("message19")).getText();
     
		if(ExpectedsuccesMessage.contains(k))	
		{
		
			System.out.println("Test Case passed");
		}

		else {
	
			System.out.println("Test case failed.Bug found");
		}
}
}

