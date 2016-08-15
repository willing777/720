package spctest.com.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 封装对象操作
 * 
 * @author dmrj
 *
 */
public class SPC {
	
	public  WebDriver driver;
	public SPC(WebDriver driver){      
		this.driver=driver;
	    }
	public  void sendKeys(By by,String value) throws InterruptedException {
		String text;
		text=driver.findElement(by).getText();
		driver.findElement(by).clear();
		Thread.sleep(1500);
		driver.findElement(by).sendKeys(value);
		log("execute select element object"+text);
		log("Set: "+value);
	}
	
	
	public  void click(By by)throws InterruptedException  {
		String text;
		if(driver.findElement(by).getText()!=null && ! "".equals(driver.findElement(by).getText())){
			text=driver.findElement(by).getText();
			Thread.sleep(1000);
			log("execute click operation");
			log("click"+" "+text);
		}
		else{
			log("this Element is not found text");
		}
		driver.findElement(by).click();	
	}
	
	public  void doJS(String commands) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;;   
	            js.executeScript(commands);   
      }
	public  void clickbyJS(String commands) {
		 JavascriptExecutor js = (JavascriptExecutor) driver;;   
		 String sys=commands+".click()";
	            js.executeScript(sys);   
     }
	public void scroll(String x, String y){  
        if (x.equals("left")){  
            x = "0";  
        }else if (x.equals("right")){  
            x = "document.body.scrollWidth";  
        }else if (x.equals("middle")){  
            x = "document.body.scrollWidth/2";  
        }  
        if (y.equals("top")){  
            y = "0";  
        }else if (y.equals("bottom")){  
            y = "document.body.scrollHeight";  
        }else if (y.equals("middle")){  
            y = "document.body.scrollHeight/3";  
        }  
        doJS(String.format("scroll(%s,%s);", x, y));  
    }  
	//将滚动条滚到适合的位置
	 public  void setScroll(int height){
	  try {
	   String setscroll = "document.documentElement.scrollTop=" + height;
	   JavascriptExecutor jse=(JavascriptExecutor) driver;
	   jse.executeScript(setscroll);
	  } catch (Exception e) {
	   System.out.println("Fail to set the scroll.");
	  }   
	 } 
    public void sleep(int second){
	 try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
  }
    public  void snapshot(TakesScreenshot drivername, String filename)
	  {
	      // this method will take screen shot ,require two parameters ,one is driver name, another is file name
	      
	    String currentPath = System.getProperty("user.dir"); //get current work folder
	    System.out.println(currentPath);
	    File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	        // Now you can do whatever you need to do with it, for example copy somewhere
	        try {
	            System.out.println("save snapshot path is:"+currentPath+"\\"+filename);
	            FileUtils.copyFile(scrFile, new File(currentPath+"\\"+filename));
	        } catch (IOException e) {
	            // TODO Auto-generated catch block
	        	log("Can't save screenshot");
	            e.printStackTrace();
	        } 
	        finally
	        {
	        log("screen shot finished");
	        }
	  }
    public  String getRandomString(int length) { //length表示生成字符串的长度    
	       String base = "abcdefghijklmnpqrstuvwxyz123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";       
	       Random random = new Random();       
	       StringBuffer sb = new StringBuffer();       
	       for (int i = 0; i < length; i++) {       
	           int number = random.nextInt(base.length());       
	           sb.append(base.charAt(number));       
	       }       
	       return sb.toString();    
	}	
    public void filewriter(String fullfilename,String writecontent){
    try {
		File newTextFile = new File(fullfilename);
		FileWriter fw;
		fw = new FileWriter(newTextFile);
		fw.write(writecontent);
		fw.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    }
 // 方法 判断页面是否出现特定的内容
    public boolean isTextPresent(String what) {
		try {
			return driver.findElement(By.tagName("body")).getText().contains(what);
		} catch (Exception e) {
			System.out.println(what + " isn't appeard!");
			return false;
			// 没有该文本 则 返回 false
		}
	}
    public boolean isTextEqual(By by,String what) {
		try {
			log(driver.findElement(by).getText());
			return driver.findElement(by).getText().contains(what);		
		} 
		catch (Exception e) {
			System.out.println(what + " isn't equal!");
			return false;
			// 没有该文本 则 返回 false
		}
	}
    
	public  void scrollToElement(By by) {
        WebElement e = driver.findElement(by);
        log("scroll view element");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // roll down and keep the element to the center of browser
        js.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", e);
    }
	
	public String log(String info){
		System.out.println(info);
		return info;
	}
	public  void openbrowser(String url){
		driver.get(url);
		log("open browser and input testURL:"+url);
	}
	public  void maxwindow(){
		driver.manage().window().maximize();
		log("max windows");		
	}
	 public  boolean wait(int second){
   	  try{driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
   	  log("执行了等待操作，等待了"+second+"秒");
   	  return true;
   	  }
   	  catch(Exception e)
   	  {     
		  return false;    	  
   	  }        	  
     }
	 public void getTableContent(By by){
		 List<WebElement> rows = driver.findElements(by);   
         //验证表格的行数  
       // Assert.assertEquals(14,rows.size());
    	  for (WebElement row : rows) {   
              //得到当前tr里td的集合  
              List<WebElement> cols =  row.findElements(By.tagName("td"));   
              for (WebElement col : cols) {  
                  System.out.print(col.getText());//得到td里的文本  
              }  
              System.out.println();  
          }  
	 }
	 public List<WebElement> getRow(By by) {
		 WebElement e_table = driver.findElement(by);
		 List<WebElement> e_row = e_table.findElements(By.tagName("tr"));
		 int i = e_row.size();
		 System.out.println(i);
		 return e_row;
		 }
	 public int getRowNum(By by) {
		 WebElement e_table = driver.findElement(by);
		 List<WebElement> e_row = e_table.findElements(By.tagName("tr"));
		 int i = e_row.size();
		 System.out.println(i);
		 return i;
		 }
	 public WebElement getCell(List<WebElement> list,int rowN, int colN) {
		List<WebElement> e_col = list.get(rowN-1).findElements(By.tagName("td"));
		 return e_col.get(colN-1);
		 }
	 public String getTalbeValue(By by,int rowN, int colN) {
		 String s = getCell(getRow(by), rowN, colN).getText();
		 return s;
		 }		 
	 public void doubleClick(By by){
			new Actions(driver).doubleClick(driver.findElement(by)).doubleClick();
		}
	 // 判断某个元素是否存在
	 public boolean isElementExist(By by) {
     try{
     Boolean bool = driver.findElement(by).isDisplayed();
     log("execute"+by+"exist or not"+","+"result is ："+bool);
     return bool;
     }
     catch(NoSuchElementException e)  {
     return false; }
     } 	
	// 获得某元素的文本描述信息
    public String getWebText(By by)
			{
	        String text;
	        text=driver.findElement(by).getText();
			try {
	        log("get Element text "+":"+text);
			return text;
			//return driver.findElement(by).getText();
			}
			catch (NoSuchElementException e){
			return "not found the Element text!";
			}
			}
	    /*
         * 在一个元素集合中通过遍历文本内容定位到相应的元素
         */
    public void clickElementContainingText(By by,String text)
         {
         List<WebElement> elementList = driver.findElements(by);
    
	         for(WebElement e:elementList)
	         {
	         if(e.getText().contains(text))
	               {
	               e.click();
	                break;
	               }
	          }
          }
    public  boolean verifyFrom(By by,String text){
		String data;
		data=driver.findElement(by).getText();
		if(data.equals(text)){
			log("actual result: "+data+"expected result: "+text+"  equal");
			return true;
		}
		else{
			log("actual result: "+data+"expected result: "+text+" disaffinity");
		return false;
		}
	}
    
   
}

