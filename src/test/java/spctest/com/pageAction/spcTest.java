package spctest.com.pageAction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import spctest.com.pageObject.HomePage;
import spctest.com.pageObject.LoginPage;
import spctest.com.pageObject.SPCPage;
import spctest.com.utils.GetFile;
import spctest.com.utils.SPC;

public class spcTest {
	
	private WebDriver driver;
    private SPCPage page3;
    private HomePage page2;
    private LoginPage page1;
    SPC spc;
	@Test(dataProvider="dp")
  public void ndcTest(String searchdata,int datanumber) throws InterruptedException {
		page3.searchProject(GetFile.getFileContent("project"));
		page3.chooseItem();
		page3.ndcChartCount();
		//page3.ndcColorCompare();
		page3.secondLevelSearch();
		page3.fourLevelSearch(searchdata,datanumber);
		page3.controlChart();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] {"6.6",14}
    
    };
  }
  @BeforeClass
  public void beforeClass() throws InterruptedException {
	  driver = new FirefoxDriver();    
	  driver.manage().window().maximize();
	  page1=new LoginPage(driver);
	  page1.login("admin", "admin123");
	  spc=new SPC(driver);
	  spc.sleep(1000);
	  page2=new HomePage(driver);
	  spc.sleep(1000);
	  page2.openSPCPage();
	  page3= new SPCPage(driver);
  }

  @AfterClass
  public void afterClass() {
//	  driver.quit();
  }
  
public SPCPage getPage3() {
	return page3;
}
public void setPage3(SPCPage page3) {
	this.page3 = page3;
}

}
