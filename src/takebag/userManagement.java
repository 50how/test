package takebag;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class userManagement {
  static WebDriver driver;
  @Test
  public void user() throws InterruptedException {
	  driver=new Login().Login();
	  Reporter.log("用户");
  }
  
  @AfterClass
  public void userStop() {
	  driver.quit();
  }
}
