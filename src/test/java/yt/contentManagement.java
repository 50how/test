package yt;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import org.testng.annotations.Test;

public class contentManagement {
  
  @Test
  public void checkcontent() throws InterruptedException {
	  
	  System.out.println();
	  Reporter.log("内容查询失败");
	  Assert.assertTrue(false);
  }
 
  
}
