package forphant;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class phant {
	WebDriver driver;
	String url="http://www.baidu.com";
	@Test
	public void f() {
		  System.setProperty("phantomjs.binary.path", "d:\\phantomjs.exe");
		    //    WebDriver driver = new FirefoxDriver();
		         driver = new PhantomJSDriver();
		        driver.get("http://www.baidu.com");
		        System.out.println(driver.getTitle().toString());
		        ///

	}
	 
	@AfterTest
	public void b() {
		driver.quit();
	}
}
