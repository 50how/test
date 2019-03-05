package yt;

import org.testng.Assert;
import org.testng.Reporter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;




public class Login {
	
	public static WebDriver driver;
	public static String url="http://admin.ecampus.test.dtedu.com/#/page/login";
	
	public static WebDriver Login() throws InterruptedException {
		  System.setProperty("phantomjs.binary.path", "./libs/phantomjs.exe");
		  
//		  WebDriver driver=new FirefoxDriver();
		  WebDriver driver=new PhantomJSDriver();	 		  
		  driver.manage().window().maximize();
		  driver.get(url);///
		  driver.findElement(By.id("username")).sendKeys("15986413434");
		  driver.findElement(By.id("password")).sendKeys("413434");
		  Thread.sleep(1000);
		  driver.findElement(By.className("submit")).click();
		  Thread.sleep(2000);
		  String a=driver.findElement(By.cssSelector("a[ng-click='changeTopMenu($index)']")).getText();
		  
		  
		 if (a.contains("学校管理")) {
			 
			
//			 Reporter.log("登录成功");
			 Assert.assertTrue(true);
		} else {
			Reporter.log("登录失败");
			 Assert.assertFalse(true);

		}
		 return driver;
	}
	

}
