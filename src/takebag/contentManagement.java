package takebag;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class contentManagement {
  static WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	  driver =new Login().Login();
	  System.out.println();
	  Reporter.log("内容");
  }
  @AfterClass
  public void contentStop() {
	  driver.quit();
  }
  
}
