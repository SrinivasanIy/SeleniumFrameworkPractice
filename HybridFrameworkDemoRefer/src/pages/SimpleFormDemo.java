package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import config.ObjectRepo;

/* POM: Class that has methods to work on web elements of the SimpleFormDemo form. 
 */ 

public class SimpleFormDemo 
{
	public WebDriver driver;
	ObjectRepo objectrep=new ObjectRepo();
	public WebElement a;
	public WebElement b;
	
	String aval="";
	String bval="";
	
		
	public SimpleFormDemo(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void entermessage(String text)//method to enter message in textfield of form
	{
		driver.findElement(By.xpath(objectrep.SimpleFormDemo_entermesage)).sendKeys(text);		
	}
	
	public void showmessage()//method to click show message button
	{
		driver.findElement(By.xpath(objectrep.SimpleFormDemo_Showmessage)).click();
	}
	
	public void displaymessage()//method to show message entered by the user
	{
		System.out.println("Message entered by the user is: "+driver.findElement(By.xpath(objectrep.SimpleFormDemo_showmessageoutput)).getText());
	}
	
	public void entera(String num)
	{
      a=driver.findElement(By.xpath(objectrep.SimpleFormDemo_Entera));
      a.sendKeys(num);
      aval=a.getAttribute("value");
      System.out.println("a is: "+aval);
	}
	
	public void enterb(String num1)
	{
	  b=driver.findElement(By.xpath(objectrep.SimpleFormDemo_Enterb));
      b.sendKeys(num1);		
      bval=b.getAttribute("value");
      System.out.println("b is: "+bval);
	}
	
	public void getTotal()
	{
		driver.findElement(By.xpath(objectrep.SimpleFormDemo_getTotalbtn)).click();
		System.out.println("sum of a: "+ aval + " and b:" + bval +" is: "+ driver.findElement(By.xpath(objectrep.SimpleFormDemo_getTotalvalue)).getText());		
	}
	
	

}
