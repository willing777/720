package spctest.com.pageAction;

import org.testng.annotations.Test;

import spctest.com.pageObject.LoginPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	private WebDriver driver;
    public LoginPage page;
    
    @DataProvider(name = "userInfo")  
    public Object[][] createData(){  
        return new Object[][] {{"admin","admin123"}};  
    }  
    
    @Test(dataProvider = "userInfo",enabled=true,invocationCount=1)
    public void login_1(String userName, String passWord) {  
    	Assert.assertTrue(page.login(userName, passWord));
      }
 
  @BeforeMethod
  public void beforeMethod() {
	  driver = new InternetExplorerDriver();  
	  driver.manage().window().maximize();
 	  page = new LoginPage(driver);
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
