package Login_Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import common.Base;

public class TC_01 extends Base {
  @Test(description="Enter Customer_ID with valid data account type savings.")
  public void logValid() throws IOException 
	{
	    WebElement cust_id=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td[2]/input"));
	    Select s = new Select (driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[3]/td[2]/select")));
		WebElement deposit=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input"));
		WebElement submit=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));

		cust_id.sendKeys("1982");
		s.selectByVisibleText("Savings");
		deposit.sendKeys("500");
		submit.click();

		String ExpectedsuccesMessage="Account Generated Successfully!!!";

		String ActualMes= driver.findElement(By.xpath("//*[@id=\"account\"]/tbody/tr[1]/td/p")).getText();

		if(ExpectedsuccesMessage.contains(ActualMes))	
		{
			System.out.println("Test Case passed");
		}

		else {
	
			System.out.println("Test case failed.Bug found");
		}
}
}

