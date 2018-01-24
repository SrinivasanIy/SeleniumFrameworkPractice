package config;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;

public class Utils 
{
WebDriver driver;
Select select;
File srcFile;
File destFile;
ObjectRepo objects=new ObjectRepo();

//method utility to sendkeys in a textbox
public void senddata(String locator, WebDriver driver, String data)
{
	
  try
 {	
   this.driver=driver;
   driver.findElement(By.xpath(locator)).sendKeys(data);	
 }
 catch(NoSuchElementException e)
 {
	System.out.println("Exception caught while entering data in a textbox: "+e.toString());
 }
  
}

//method utility to click submit button in a form
public void clickSubmitbtn(String locator,WebDriver driver)
{
	try
	{
		this.driver=driver;
		driver.findElement(By.xpath(locator)).click();		
	}
	catch(NoSuchElementException e)
	{
		System.out.println("Exception caught while entering data in a textbox: "+e.toString());
	}
	
}


//method utility to getsreenshot
public void getScreenshot(String filename)
{
  try
  {
	  srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  destFile=new File("C:\\Screenshots\\"+System.currentTimeMillis()+filename);
	  
	  FileUtils.copyFile(srcFile, destFile);
  }
  catch(IOException e)
  {
	  System.out.println("Exception caught while trying to save screenshot: "+e.toString());
  }
	
	
}


//utility method to select dropdown value from a dropdown using its value attribute
public void selectdropdownvaluebyValue(WebElement element, WebDriver driver, String dropdownvalue)
{
   try	
   {
	   this.driver=driver;
	   select = new Select(element);
	   select.selectByValue(dropdownvalue);	   
   }
   catch(Exception e)
   {
	   System.out.println("Exception caught while selecting Dropdownvalue element from a dropdown: "+e.toString());
   }
	
}


//utility method to select dropdown value from a dropdown using its value attribute
public void selectdropdownvaluebyIndex(WebElement element, WebDriver driver, int index)
{
 try	
 {
	   this.driver=driver;
	   select = new Select(element);
	   select.selectByIndex(index);//.selectByValue(dropdownId);	   
 }
 catch(Exception e)
 {
	   System.out.println("Exception caught while selecting DropdownIndex element from a dropdown: "+e.toString());
 }
	
}


//utility method to select dropdown value from a dropdown using its value attribute
public void selectdropdownvaluebyVisibleText(WebElement element, WebDriver driver, String Visibletext)
{
 try	
 {
	   this.driver=driver;
	   select = new Select(element);
	   select.selectByVisibleText(Visibletext);	   
 }
 catch(Exception e)
 {
	   System.out.println("Exception caught while selecting DropdownVisibleText element from a dropdown: "+e.toString());
 }
	
}

public String getdatafromtable(WebDriver driver, int pagenum, int row, int col)
{
	int counter=1;
	String str=objects.Tabledata + "/tr["+row+"]/td["+col+"]";
	System.out.println("Xpath from data has to be retrieved from table is: "+str);
	
	
	if(pagenum==1)
	{	
	return(driver.findElement(By.xpath(str)).getText());
	}
	else if(pagenum > 1 && pagenum <=3)
	{
		driver.findElement(By.xpath("//*[@id='myPager']/li["+(pagenum+1)+"]/a")).click();
		return(driver.findElement(By.xpath(str)).getText());
	}
	else
	{
		System.out.println("This page: " + pagenum+ " doesn't exist");
		return "false";
	}
	
}



	
	

}
