package spctest.com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import spctest.com.utils.Locator;
import spctest.com.utils.SPC;


public class LoginPage {
	String url;
	WebElement username;
	WebElement password;
	WebElement staysign;	
	WebDriver driver;
	SPC spc;
	Locator locator;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		//this.url=url;
		//driver.get(this.url);
		url= "http://192.168.30.20";
		spc= new SPC(driver);
		spc.openbrowser(url);  
	    //username=driver.findElement(By.name("username"));
		locator=new Locator(driver);
		username=locator.byName("username");
		password=locator.byName("password");
		staysign=locator.byCss(".checkbox>i");
	
	}
	public  boolean login(String userName, String passWord) {
		
		username.sendKeys(userName);
	    password.sendKeys(passWord);
	    spc.sleep(1000);
		staysign.click();
		String sys = "$(\"button:contains(Sign in)\").click()";
		spc.doJS(sys);
		spc.sleep(2000);
		//spc.snapshot((TakesScreenshot)driver,"Homepage.png");
	
		return spc.isTextPresent("Welcome to iSPC system!");	 
	}
	
	public String getTitle() {  
	       return this.driver.getTitle();  
	   } 
	
	//截图方法
	
		
}
