package spctest.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import spctest.com.utils.GetFile;
import spctest.com.utils.Locator;
import spctest.com.utils.SPC;


public class DataImportPage {
	WebDriver driver;
	WebElement browse;
	WebElement selectProject;
	WebElement inputSearchProject;
	WebElement searchResult;
	WebElement startImport;
	WebElement inputAdd;
	WebElement add;
	WebElement viewImportFiles;
	WebElement chooseProject;
	private String content;
	SPC spc;
	Locator locator;
	public DataImportPage(WebDriver driver){
		this.driver=driver;
		locator =new Locator(driver);
		spc =new SPC(driver);
	    browse=driver.findElement(By.name("file"));
	    chooseProject=locator.byId("s2id_slt_spc_import_project");
		inputSearchProject=driver.findElement(By.id("s2id_autogen6_search"));
		startImport=driver.findElement(By.id("btn_spc_import_submit"));	
	}
	
	public void dataImport(String styleName,String fileAddress) throws InterruptedException{
	
		spc.clickbyJS("document.getElementsByClassName('btn-primary')[1]");
		spc.sleep(2000);
		browse.sendKeys(fileAddress);
		//从项目名的存取地址读取项目名称		
		spc.sleep(1000);
		 //selectProject.click();
	     chooseProject.click();
	     spc.sleep(1000);
	     content=GetFile.getFileContent(styleName);
		 inputSearchProject.sendKeys(content);
		 spc.sleep(2000);
		spc.click(By.xpath("html/body/div[9]/ul/li"));
		 spc.sleep(1000);
         startImport.click(); 
	}
/*	public void deleteImportData(String dataName,String project){
		viewImportFiles.click();	
		driver.findElement(By.id("search-input")).sendKeys(dataName);
		driver.findElement(By.id("btn-simple-search")).click();
		String projectName=GetFile.getFileContent(project);
		List<WebElement> trlist=driver.findElements(By.id("dt_testFiles"));
	    for(int r=0;r<trlist.size();r++){
	    	String trText=trlist.get(r).getText();
	    	if(trText.contains(dataName)&&trText.contains(projectName)){
	    		trlist.get(r).findElement(By.xpath("(.//a[contains(text(),'Delete')])")).click();
	    		
	    		break;
	    	}	
	    }
	    
	    spc.doJS("$(\"button:contains('Yes')\").click()");
	   
	}
	
*/	
}
