package spctest.com.pageAction;

import org.testng.annotations.Test;

import spctest.com.pageObject.HomePage;
import spctest.com.pageObject.LoginPage;
import spctest.com.pageObject.PermissionPage;
import spctest.com.utils.SPC;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class PermissionTest {
	WebDriver driver;
	SPC spc;
	LoginPage page1;
	HomePage page2;
	PermissionPage page3;
	public PermissionTest(){}
  @Test
  public void f() {
	  page3.setPermission();
  }
  @BeforeMethod
  public void beforeMethod() {
	  page2.openSystem();
	  page3=new PermissionPage(driver);
	  spc.clickbyJS("$(\"a:contains('Permission')\")");
	  spc.sleep(2000);
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  driver = new InternetExplorerDriver();    
	  spc=new SPC(driver);	
	  spc.maxwindow();
	  page1=new LoginPage(driver);
	  page1.login("admin", "admin123"); 
	  page2=new HomePage(driver);
	 
  }

  @AfterClass
  public void afterClass() {
  }

}
