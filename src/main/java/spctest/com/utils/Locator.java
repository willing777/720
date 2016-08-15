package spctest.com.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * 封装元素定位
 * @author dmrj
 *
 */
public class Locator {
	public WebDriver driver;
    public Locator(WebDriver driver){
	this.driver=driver;
	}
     
	public  WebElement byName(String value) {
		return driver.findElement(By.name(value));	
	}
	
	public  WebElement byId(String value) {
		return driver.findElement(By.id(value));	
	}
	public  WebElement byXpath(String value) { 
		return driver.findElement(By.xpath(value));	
	}
	public WebElement  byCss(String value) {
		return driver.findElement(By.cssSelector(value));	
	}
	public WebElement  byClassName(String value) {
		return driver.findElement(By.className(value));	
	}
	
	

	
	
	
	
	
	
}
