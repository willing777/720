package spctest.com.pageObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import spctest.com.utils.SPC;

public class ProjectPage {
	WebDriver driver;
	WebElement code;
	WebElement name;
	WebElement search;
	JavascriptExecutor jse;
	SPC spc;
	
	public ProjectPage(WebDriver driver) {
		this.driver = driver;
		jse = (JavascriptExecutor) driver;
		code = driver.findElement(By.id("search-input"));
		name = driver.findElement(By.id("search-input1"));
		search = driver.findElement(By.id("btn-simple-search"));
		spc= new SPC(driver);
	}
	// 新建项目
	public void newProject(String groupNum) {
	   jse.executeScript("$(\"[href='#project/create']\")[0].click()");
	   spc.sleep(1000);
		// 新建项目名称为格式化的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd 'at' HH_mm_ss");
		Date date = new Date();
		String formatDate = sdf.format(date);
		// 把项目名称保存到本地文件
		String fullFilename = "E:/Data/projectname.txt";
		spc.filewriter(fullFilename,formatDate);
		// 开始新建项目
		driver.findElement(By.id("code")).sendKeys(formatDate);
		driver.findElement(By.id("name")).sendKeys(formatDate);
		driver.findElement(By.id("btn_saveAll")).click();	
		Assert.assertTrue(spc.isTextPresent("Poject Information"));
	}
	public void projectDetail(String name) {

	}

}
