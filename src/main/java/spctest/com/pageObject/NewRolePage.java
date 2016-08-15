package spctest.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import spctest.com.utils.GetFile;
import spctest.com.utils.Locator;
import spctest.com.utils.SPC;

public class NewRolePage {
	public WebDriver driver;
	SPC spc;
	Locator locator;
	public NewRolePage(WebDriver driver){
		this.driver=driver;
		spc=new SPC(driver);
		locator=new Locator(driver);
	}
	public void searchRole(String roleName) throws InterruptedException{
		locator.byId("search-input");
		spc.sendKeys(By.id("search-input"), roleName);	
		roleName=GetFile.getFileContent("role");
	}
	
	public void newRole() throws InterruptedException {
		spc.clickbyJS("$(\"[href='#role/register']\")[0]");
		spc.sleep(1000);
		String fullFilename = "E:/Data/rolename.txt";
		spc.filewriter(fullFilename,spc.getRandomString(6));
		String roleName=GetFile.getFileContent("role");
		spc.sendKeys(By.id("txt_role_name"), roleName);
		spc.clickbyJS("$(\"button:contains('Save')\")");
	}
	

}
