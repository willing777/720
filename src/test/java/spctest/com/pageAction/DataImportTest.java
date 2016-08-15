package spctest.com.pageAction;

import org.testng.annotations.Test;

import spctest.com.pageObject.DataImportPage;
import spctest.com.pageObject.HomePage;
import spctest.com.pageObject.LoginPage;
import spctest.com.utils.SPC;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class DataImportTest {
	private WebDriver driver;
    private DataImportPage page3;
    private HomePage page2;
    private LoginPage page1;
    SPC spc;
  @Test
  public void dataImport() throws InterruptedException {  
	  page3.dataImport("project","C:\\Users\\dmrj\\Desktop\\NDC data.csv");    
	  Assert.assertTrue(spc.isTextPresent("Import completed. 100%"));
  }
  
  @Test
  public void deleteData() { 
  //page3.deleteImportData("NDC","project");
  }
  @BeforeMethod	
  public void beforeMethod(){
	  System.out.println("setup");
  }
  @AfterMethod	
  public void afterMethod() { 
	  System.out.println("teardown");
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  driver = new FirefoxDriver();    
	  driver.manage().window().maximize();
	  page1=new LoginPage(driver);
	  page1.login("lily", "123456");
	  spc=new SPC(driver);
	  spc.sleep(1000);
	  page2=new HomePage(driver);
	  spc.sleep(1000);
	  page2.openSPCPage();
	  page3=new DataImportPage(driver);
  }

  @AfterClass
  public void afterClass() {
  }
  

}
