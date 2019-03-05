package yt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class NewTest {
  @Test
  public void f() {
	  System.out.println("++++++++++++_____我______++++++++++++++");
	  System.setProperty("phantomjs.binary.path", "./libs/phantomjs.exe");
	  
//	  WebDriver driver=new FirefoxDriver();
	  WebDriver driver=new PhantomJSDriver();
	  driver.get("http://www.baidu.com");
	  System.out.println(driver.getTitle().toString());
	  driver.quit();
  }
  
  
}
