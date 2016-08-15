package spctest.com.pageAction;

import org.testng.annotations.Test;

import spctest.com.pageObject.HomePage;
import spctest.com.pageObject.LoginPage;
import spctest.com.pageObject.NewRolePage;
import spctest.com.utils.SPC;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;

public class NewRoleTest {
    WebDriver driver;
	LoginPage page1;
	HomePage page2;
	NewRolePage page3;
	SPC spc;
	public NewRoleTest(){}
  @Test
  public void f() throws InterruptedException {
	 page3.newRole();  
	 spc.isTextPresent("Your info was successfully added! ") ;
  }  
  @BeforeMethod
  public void beforeMethod() {
	  spc.log("start newrole");
	  spc.sleep(1000);
	  page2.openSystem();
	  spc.sleep(1000);
	  spc.clickbyJS("$(\"a:contains('Role')\")");
  }

  @AfterMethod
  public void afterMethod() {
	  spc.log("stop newrole");
  }
  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  driver = new InternetExplorerDriver();  
	  spc=new SPC(driver);
	  spc.maxwindow();
	  page1=new LoginPage(driver);
	  page1.login("ky", "123456");
	  page2=new HomePage(driver);
	  page3=new NewRolePage(driver);
  }
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }

}
