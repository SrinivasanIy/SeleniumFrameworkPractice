package pages;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.ObjectRepo;

public class BootstrapListBox 
{
	WebDriver driver;
	ObjectRepo objects=new ObjectRepo();
	//List<WebElement> leftlist;
	//List<WebElement> rightlist;
	
	public BootstrapListBox(WebDriver driver)
	{
		this.driver=driver;		
	}
	
	public void selectAllleftgrid()
	{
		try
		{
		driver.findElement(By.xpath(objects.BootstrapListBox_left_selectall)).click();
		List<WebElement> leftlist=new ArrayList<WebElement>();
    	leftlist=driver.findElements(By.xpath(objects.BootstrapListBox_left_List));
    	Iterator<WebElement> itr=leftlist.iterator();
    	while(itr.hasNext())
    	{
    		WebElement element=itr.next();
    		System.out.println("Element of left list: "+element.getText());   
    		Assert.assertTrue(element.isEnabled());
    	}
		}
		catch(Exception e)
		{
			System.out.println("Exception caught: "+e.toString());
		}
	}
	
	public void selectAllrightGrid()
	{
		driver.findElement(By.xpath(objects.BootstrapListBox_right_selectall)).click();
	}
	
    public void getallElementsLeftgrid()
    {
    	List<WebElement> leftlist=new ArrayList<WebElement>();
    	leftlist=driver.findElements(By.xpath(objects.BootstrapListBox_left_List));
    	Iterator<WebElement> itr=leftlist.iterator();
    	System.out.println("Hello we are in getallElementsLeftgrid()");
    	while(itr.hasNext())
    	{
    		WebElement element=itr.next();
    		System.out.println("Element: "+element.getText());    		
    	}
    	
    }
    
    public void getallElementsRightgrid()
    {
    	List<WebElement> rightlist=new ArrayList<WebElement>();
    	rightlist=driver.findElements(By.xpath(objects.BootstrapListBox_right_List));
    	Iterator<WebElement> itr=rightlist.iterator();
    	System.out.println("Hello we are in getallElementsRightgrid()");
    	while(itr.hasNext())
    	{
    		WebElement element=itr.next();
    		System.out.println("Element: "+element.getText());    		
    	}
    	
    }
    	
   }
	

