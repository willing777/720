package spctest.com.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import spctest.com.utils.SPC;



public class PermissionPage {
	WebDriver driver;
	WebElement analysisRole;
	WebElement projectRole;
	WebElement dataImportRole;
	WebElement systemRole;
	SPC spc;
	public PermissionPage(WebDriver driver){	
		spc=new SPC(driver);
}
	public void setPermission(){
		spc.sleep(1000);
		spc.clickbyJS("$(\"a:contains('Role')\")[1]");
		spc.sleep(1000);
		spc.clickbyJS("$(\"button:contains('test')\")");
		spc.sleep(1000);
		spc.clickbyJS("document.getElementsByClassName(\"fa-plus\")[0]");
		spc.scroll("0","middle");
		spc.sleep(1000);
		spc.clickbyJS("$(\"a:contains('Role')\")[7]");
		spc.sleep(1000);
		spc.clickbyJS("$(\"button:contains('test')\")");
		spc.sleep(1000);
		spc.clickbyJS("document.getElementsByClassName(\"fa-plus\")[0]");
	}
	
	
}
