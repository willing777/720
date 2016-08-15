package spctest.com.pageAction;

import org.testng.annotations.Test;
import spctest.com.pageObject.HomePage;
import spctest.com.pageObject.LoginPage;
import spctest.com.pageObject.ProjectPage;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class NewProjectTest {
	private WebDriver driver;
	private ProjectPage page3;
    private HomePage page2;
    private LoginPage page1;

  @Test
  public void f() {
	  page1 = new LoginPage(driver);
	  page1.login("lily","123456");
	  page2=new HomePage(driver);
	  page2.openProject();
	  page3=new ProjectPage(driver);
      page3.newProject("22");  	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new FirefoxDriver();  
	  driver.manage().window().maximize();  
  }

  @AfterMethod
  public void afterMethod() {
  }

}
