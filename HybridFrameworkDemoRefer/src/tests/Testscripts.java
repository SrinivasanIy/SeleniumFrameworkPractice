package tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import config.ConnectDB;
import config.ObjectRepo;
import config.ReadfromExcel;
import config.Utils;
import pages.BootstrapListBox;
import pages.SimpleFormDemo;

public class Testscripts 
{
	WebDriver driver;
	ObjectRepo objects=new ObjectRepo();
	Properties prop;
	ReadfromExcel excelreader=new ReadfromExcel();
	ConnectDB dbconnector=new ConnectDB();
	SimpleFormDemo simpleform;
	BootstrapListBox boostraplist;
	Utils util=new Utils();
	Logger logger;
	
	@BeforeTest
	public void useproperty()
	{
		File file= new File("C:\\Users\\sriniiye\\Documents\\AUTOMATION\\PERSONAL PC AUTOMATION SELENIUM\\Refer projects\\HybridFrameworkDemo\\src\\Properties.properties");
	    FileInputStream fileinput=null;
  	    Reporter.log("File successfully created.",true);
 	   try
	   {
		fileinput=new FileInputStream(file);
		Reporter.log("File InputStream successfully created.",true);
	   }
	   catch(Exception e)
	   {
		Reporter.log("Exception found while creating InputStream.",true);   
		System.out.println("Exception caught: "+e.toString());
	   }
	   
	   prop=new Properties();
	   
	   try
	   {
		 prop.load(fileinput);  
		 Reporter.log("FileInputStream successfully loaded.",true);   
	   }
	   catch(Exception e)
	   {
		   Reporter.log("Exception found while loading File Input Stream.",true);   
		   System.out.println("Exception Caught: "+e.toString());
	   }
	   
	}
	
	@BeforeMethod
	public void setup()
	{
		logger=Logger.getLogger("devpinoyLogger");
		driver=new FirefoxDriver();
		logger.debug("Going to load Firefox Browser");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logger.debug("Going to load Application in Firefox Browser");
		driver.get(prop.getProperty("url"));
		logger.debug("Application loaded in Firefox Browser");
		simpleform=new SimpleFormDemo(driver);
		boostraplist=new BootstrapListBox(driver);		
	}

    @AfterMethod
    public void teardown()
    {
    	logger.debug("Application about to be exited and all open windows will be closed");
    	driver.close();
    	driver.quit();    	
    }
	
    @DataProvider(name="dataprovider")
    public Object[][] providedata()
    {
    	Object obj[][]= {{1,"Srini",10.50},{2,"Iyer",20.50}};
    	return obj;    	
    }
    
    @Test(dataProvider="dataprovider",enabled=false)
    public void usedata(int a, String user, double percentg)
    {
    	System.out.println("Hello our testing has started....");
    	Reporter.log("Testing started",true);
    	System.out.println("Id: "+ a+ " User: "+user +" Percentage Obtained: "+percentg); 	
    	System.out.println("\n");    	
    }
    
    @Test(enabled=true)
    public void getfrmexcel()
    {
    	excelreader.readexcel("Application.xlsx", "C:\\Users\\sriniiye\\Documents\\AUTOMATION\\PERSONAL PC AUTOMATION SELENIUM\\Refer projects\\HybridFrameworkDemo\\src", "Sheet1");    	
    }
    
    		
	@Test(enabled=false)
	public void SimpleFormDemo()//click SimpleFormDemo and send values in its sample form
	{
		try
		{
		//Reporter.log("In SimpleFormDemo Form",true);
		logger.debug("Going to access InputForms");
		driver.findElement(By.xpath(objects.InputForms)).click();
		logger.debug("Going to access InputForms");
		driver.findElement(By.xpath(objects.SimpleFormDemo)).click();	
		logger.debug("InputForms page opened");
		simpleform.entermessage("Hello Testing started");
		simpleform.showmessage();
		simpleform.entera("25");
		simpleform.enterb("45");
		simpleform.getTotal();		
		logger.debug("Message displayed to user, testing done");
		}
		catch(Exception e)
		{
			Reporter.log("Exception caught in SimpleFormDemo Form",true);
			System.out.println("Exception caught: "+e.toString());
		}
	}

	 @Test(enabled=false)
	 public void getdatafromtable()
	 {
		driver.findElement(By.xpath(objects.Table)).click(); 
		driver.findElement(By.xpath(objects.TablePagination)).click();
		String result=util.getdatafromtable(driver,3,1,3);
	try
	{	
		if(result.equals("false"))
		{
			System.out.println("Such a page doesn't exists and hence the testcase is failed.");
			Assert.assertFalse(true);
		}
		else
		{
			System.out.println("Data from table for input parameters: " +result);		 
			Assert.assertTrue(true);
		}
	}
	catch(Exception e)
	{
		System.out.println("Exception caught: "+e.toString());
	}
  }
	 
	 @Test(enabled=false)
	 public void getallElementsBoostrapListBox()
	 {
  		 logger.debug("ListBox will be accessed now");
		 driver.findElement(By.xpath(objects.ListBox)).click();
		 driver.findElement(By.xpath(objects.BootstrapListBox)).click();
		 logger.debug("BoostrapListBox accessed now");
		 boostraplist.getallElementsLeftgrid();
		 logger.debug("BoostrapListBox Leftgrid accessed now");
		 boostraplist.getallElementsRightgrid();
		 logger.debug("BoostrapListBox Rightgrid accessed now");
		 boostraplist.selectAllleftgrid();
		 logger.debug("BoostrapListBox Leftgrid all elements selected now");
	 }
	
}
