package yt;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import yt.schoolTime;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class schoolManagement {
	private WebDriver driver;
	ArrayList<String> texts=new ArrayList<>();

  @BeforeClass
	  public void beforeClass() {

		   
	  }
	
  @Test(priority=1 ) 
  public void Login() throws InterruptedException {
	  
	 driver =new Login().Login();
	  
	  
  }
  
  @Test(priority=2,dependsOnMethods="Login",enable=false) 
  public void CreateSchool() throws InterruptedException {
	  String schoolname="体育西路小学"+schoolTime.Gettime();
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("a[href='#/layout/schoolmanage/school_detail//1///']")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("input[ng-model='d.school_name']")).sendKeys(schoolname);
	  Thread.sleep(2000);
	  Select province =new Select(driver.findElement(By.id("province")));
	  province.selectByVisibleText("广东省");
	  Select city =new Select(driver.findElement(By.id("city")));
	  city.selectByVisibleText("广州市");
	  Select district =new Select(driver.findElement(By.id("district")));
	  district.selectByVisibleText("天河区");
	  driver.findElement(By.cssSelector("input[placeholder='请输入街道等详细地址']")).sendKeys("体育西横街187号");
	  driver.findElement(By.cssSelector("input[model='d.effective_time.start']")).sendKeys("2019/02/06");
	  driver.findElement(By.cssSelector("input[model='d.effective_time.start']")).click();
	  driver.findElement(By.cssSelector("input[model='d.effective_time.end']")).sendKeys("2019/12/30");
	  driver.findElement(By.cssSelector("input[model='d.effective_time.end']")).click();
	  Thread.sleep(1000);
	  String aa=driver.findElement(By.cssSelector("button[ng-click='f.saveSchool()']")).getText();
	  System.out.println(aa);
	  driver.findElement(By.cssSelector("button[ng-click='f.saveSchool()']")).click();//save
	  Thread.sleep(3000);
	  WebElement as=driver.findElement(By.cssSelector("div[ng-show='!d.calendar.term[0][0]']"));
	  System.out.println(as.getText());
	  as.findElement(By.cssSelector("button[ng-click='f.setStartEnd(0)']")).click();//设置学期日期
	  Thread.sleep(1000);
	  driver.findElement(By.cssSelector("input[model='d.dialog.start']")).sendKeys("2019/02/06");
	  driver.findElement(By.cssSelector("input[model='d.dialog.start']")).click();
	  driver.findElement(By.cssSelector("input[model='d.dialog.end']")).sendKeys("2019/07/31");
	  driver.findElement(By.cssSelector("input[model='d.dialog.end']")).click();
	  driver.findElement(By.cssSelector("a[ng-click='f.saveStartEnd()']")).click();
	  Thread.sleep(1000);
	  
	  WebElement sf=driver.findElement(By.className("calendar-container"));
	  sf.findElement(By.cssSelector("button[ng-click='f.setStartEnd(0)']")).click();//第一学期
	  WebElement sd=driver.findElement(By.className("set-date-dialog"));
	  sd.findElement(By.cssSelector("input[model='d.dialog.start']")).clear();
	  sd.findElement(By.cssSelector("input[model='d.dialog.start']")).sendKeys("2019/02/06");
	  sd.findElement(By.cssSelector("input[model='d.dialog.start']")).click();
	  sd.findElement(By.cssSelector("input[model='d.dialog.end']")).clear();
	  sd.findElement(By.cssSelector("input[model='d.dialog.end']")).sendKeys("2019/07/30");
	  sd.findElement(By.cssSelector("input[model='d.dialog.end']")).click();
	  sd.findElement(By.cssSelector("a[ng-click='f.saveStartEnd()']")).click();
	  Thread.sleep(1000);
	  
	  sf.findElement(By.cssSelector("button[ng-click='f.setStartEnd(1)']")).click();//第二学期
	  Thread.sleep(1000);
	  WebElement sk=driver.findElement(By.className("set-date-dialog"));
	  sk.findElement(By.cssSelector("input[model='d.dialog.start']")).clear();
	  sk.findElement(By.cssSelector("input[model='d.dialog.start']")).sendKeys("2019/09/01");
	  sk.findElement(By.cssSelector("input[model='d.dialog.start']")).click();
	  sk.findElement(By.cssSelector("input[model='d.dialog.end']")).clear();
	  sk.findElement(By.cssSelector("input[model='d.dialog.end']")).sendKeys("2019/12/30");
	  sk.findElement(By.cssSelector("input[model='d.dialog.end']")).click();
	  sk.findElement(By.cssSelector("a[ng-click='f.saveStartEnd()']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.cssSelector("a[ng-click='changeTopMenu($index)']")).click();//返回学校管理
	  Thread.sleep(1000);
	  driver.findElement(By.id("keywords")).sendKeys(schoolname);
	  driver.findElement(By.cssSelector("button[ng-click='search()']")).click();
	  

	  Thread.sleep(2000);
	  WebElement table=driver.findElement(By.className("middle"));
	  List<WebElement> tr=table.findElements(By.tagName("tr"));
	  for(WebElement trs:tr) {
		  List<WebElement>tds=trs.findElements(By.tagName("td"));
		  for(WebElement tdxs:tds) {
//			 System.out.println(tdxs.getText()); 
			 texts.add(tdxs.getText());


		  }
		  
	  }
	  
	  
	  if(texts.contains(schoolname)) {
	  Reporter.log("学校创建成功");
	  Assert.assertTrue(true);
	  }
	  
	  else {
	  Reporter.log("学校创建失败");
	  Assert.assertFalse(true);
	  }

	  

  }
  

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
