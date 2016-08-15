package spctest.com.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import spctest.com.utils.Locator;
import spctest.com.utils.SPC;

public class SPCPage {
	
  private WebElement dataImport;
  private WebDriver drive;
  private SPC spc;
  private Locator locator;
	public SPCPage(WebDriver driver){
	
	    spc=new SPC(driver);
	    locator=new Locator(driver);
	}
	
	public void searchProject(String projectName) throws InterruptedException{
		spc.click(By.id("s2id_slt_sb_project"));
		spc.sendKeys(By.id("s2id_autogen1_search"), projectName);
		spc.sleep(1000);
		spc.click(By.id("select2-results-1"));
		spc.click(By.id("btn_sb_searchBtn"));
		}
	public void chooseItem(){

		spc.clickbyJS("$(\"td:contains('I_Silence')\")");
	}
	
	public void ndcChartCount() throws InterruptedException{

	String fullFilename = "E:/Data/atuo_ndc_result.txt";
	spc.sleep(1000);
	spc.filewriter(fullFilename,locator.byId("div_NDChartLabel").getText());
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_samples"), "963"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_avg"), "6.660057"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_max"), "6.821000"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_min"), "6.493000"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_range"), "0.328000"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_stdev"), "0.072199"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_lcl"), "6.443459"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_ucl"), "6.876655"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_ku"), "2.862359"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_sk"), "-0.482817"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_group"), "32"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_usl"), "8.000000"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_lsl"), "5.600000"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_center"), "6.800000"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_ca"), "-11.6619%"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_cpk"), "4.894116"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_cp"), "5.540211"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_cpl"), "4.894116"));
	 Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_cpu"), "6.186305"));	
	}
	public void ndcColorCompare(){
		locator.byId("spn_ndc_cpk").getAttribute("style");
		spc.log(locator.byId("spn_ndc_cpk").getAttribute("style"));
	}
	
    public void secondLevelSearch() throws InterruptedException{
    	spc.click(By.id("s2id_slt_sed_filterType"));
    	spc.sendKeys(By.id("s2id_autogen4_search"), "Station");
    	spc.click(By.id("select2-results-4"));
    	spc.click(By.id("s2id_slt_sed_filterValue"));
        spc.sendKeys(By.id("s2id_autogen5_search"), "S2_001");
        spc.click(By.id("select2-results-5"));
    	spc.click(By.id("btn_refreshChart"));
    	spc.isTextEqual(By.id("spn_ndc_samples"), "23");	
    }
    public void fourLevelSearch(String searchdata,int datanumber) throws InterruptedException{
    	spc.sendKeys(By.id("txt_filterValue"), searchdata);
    	spc.click(By.id("btn_testDataFilter"));
//        spc.getTableContent(By.id("tbl_testData"));
//    	spc.getRow(By.id("tbl_testData"));   
//        Assert.assertEquals(spc.getRowNum(By.id("tbl_testData")),datanumber);
        spc.setScroll(500);
        spc.sleep(1500);
        locator.byXpath("html/body/div[1]/div/section/div[3]/article/div/div/div[2]/div[2]/table/tbody/tr[3]/td[1]/label").click();
        spc.sleep(1500);
        // spc.getCell(spc.getRow(By.id("tbl_testData")), 8, 0).click();
       // spc.getCell(spc.getRow(By.id("tbl_testData")), 9, 0).click();
        spc.setScroll(-500);
        spc.click(By.id("btn_refreshChart"));
        spc.sleep(1000);
        Assert.assertTrue(spc.isTextEqual(By.id("spn_ndc_samples"), "24"));
    }
    
    public void controlChart() throws InterruptedException{
    	spc.click(By.id("RunChart"));
    	spc.sleep(2000);
    	Assert.assertTrue(spc.isTextEqual(By.id("chart_RunC"),"6.870433"));
    	Assert.assertTrue(spc.isTextEqual(By.id("chart_RunC"),"6.727672"));
    	Assert.assertTrue(spc.isTextEqual(By.id("chart_RunC"),"6.656292"));
    	spc.click(By.id("SDChart"));
    	spc.sleep(2000);
    	Assert.assertTrue(spc.isTextEqual(By.id("chart_SDC"),"0.122427"));
    	spc.click(By.id("RChart"));
    	spc.sleep(2000);
    	Assert.assertTrue(spc.isTextEqual(By.id("chart_RC"),"0.312615"));
    	spc.click(By.id("MRChart"));
    	spc.sleep(1000);
    	Assert.assertTrue(spc.isTextEqual(By.id("chart_MRC"),"0.253519"));
    }
    
	public void checkboxSelect(){
		
	}

	public WebElement getDataImport() {
		return dataImport;
	}

	public void setDataImport(WebElement dataImport) {
		this.dataImport = dataImport;
	}

	public WebDriver getDrive() {
		return drive;
	}

	public void setDrive(WebDriver drive) {
		this.drive = drive;
	}
	

}
