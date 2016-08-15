package spctest.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import spctest.com.utils.SPC;

public class HomePage {
	WebDriver driver;
	WebElement SPC;	
	WebElement Project;
	WebElement System;
	WebElement Logout;
	WebElement Expend;
	JavascriptExecutor jse;
	SPC spc;
	public HomePage(WebDriver driver){	
		this.driver=driver;
		jse = (JavascriptExecutor) driver;	
		spc=new SPC(driver);
	}
	public boolean openSPCPage() throws InterruptedException {
		spc.click(By.id("nav_global_spc"));
		return spc.isTextPresent("Test ITem");
	}
	public void openExpend(){
		jse.executeScript("document.getElementsByClassName(\"minifyme\")[0].click()");
	}
	public void openAnalysis(){
		openExpend();
		jse.executeScript("$(\"span:contains('Analiysis')\").click()");	
		 Assert.assertTrue(driver.getTitle().contains("Analiysis"));
	}
	public void openProject(){
		openExpend();
		spc.doJS("$(\"span:contains('Project')\").click()");
	}
	public void openSystem(){
		//openExpend();
		jse.executeScript("$(\"span:contains('System')\").click()");
	}
	public void openDataImportPage(){
		//openExpend();
		jse.executeScript("$(\"span:contains('Data Import')\").click()");
	}
	
	public void logout(){
		jse.executeScript("$(\".fa-sign-out\")[1].click()");
		driver.findElement(By.id("bot2-Msg1")).click();
		Assert.assertTrue(driver.getTitle().contains("ISPC"));
	}
	
}
