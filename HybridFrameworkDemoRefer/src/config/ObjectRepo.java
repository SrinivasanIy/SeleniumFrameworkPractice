package config;

public class ObjectRepo
{
//Home Page elements
  public String Seleniumlogo_Homepg="//a[@title='Home']/img";	//SeleniumEasyLogo
  public String Seleniumeasy_Sponsor_Homepg="//a[@href='https://crossbrowsertesting.com/?utm_source=seleniumeasy&utm_medium=da&utm_campaign=sedemo']/img";
  //SeleniumEasy Sponsored By
  
  //Middle section of Homepage to navigate left or right of images shown in center
  public String leftarrowimage_Symbol="//*[@id='carousel-example-generic']/a[1]/i";
  public String rightarrowimage_Symbol="//*[@id='carousel-example-generic']/a[2]/i";
  
  
  //Bottom of Homepage- Element locators
  public String Homesymbol_Homepg="//*[@id='home_bar']/span";//Home page icon for practicing
  public String Basicsymbol_Homepg="//*[@id='basic_example']/span";//Basic symbol icon 
  public String Intermediate_Homepg="//*[@id='inter_example']/span";//Intermediate symbol
  public String Advanced_Homepg="//*[@id='advanced_example']/span";//Advanced symbol
  public String Done_Homepg="//*[@id='done_example']/span";//Done symbol
  public String StartPracticingbtn_Homepg="//*[@id='btn_basic_example']";//Start Practicing Button
  
  //BottomLeft side of Homepage= Element Locators(MenuList)
  public String tree_menu_Dropdown_Arrow="//*[@id='treemenu']/li/i";
  public String tree_menu_AllExamples="//*[@id='treemenu']/li/a";
  public String tree_menu_InputForms="//*[@id='treemenu']/li/ul/li[1]/a";
  public String tree_menu_DatePickers="//*[@id='treemenu']/li/ul/li[2]/a";
  public String tree_menu_Table="//*[@id='treemenu']/li/ul/li[3]/a";
  public String tree_menu_ProgressBarsandSliders="//*[@id='treemenu']/li/ul/li[4]/a";
  public String tree_menu_AlertandModals="//*[@id='treemenu']/li/ul/li[5]/a";
  public String tree_menu_ListBox="//*[@id='treemenu']/li/ul/li[6]/a";
  public String tree_menu_Others="//*[@id='treemenu']/li/ul/li[7]/a";

  // TopLeft side of Homepage- Element Locators(InputForms)
  public String InputForms ="//*[@id='navbar-brand-centered']/ul[1]/li[1]/a";
  public String SimpleFormDemo="//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[1]/a";
  public String CheckboxDemo="//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[2]/a";
  public String RadioButtonsDemo="//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[3]/a";	
  public String SelectDropdownList="//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[4]/a";
  public String InputFormSubmit="//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[5]/a";	
  public String AjaxFormSubmit="//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[6]/a";
  public String JQuerySelectDropdown="//*[@id='navbar-brand-centered']/ul[1]/li[1]/ul/li[7]/a";	
  
  //SimpleFormDemo Elements
  public String SimpleFormDemo_entermesage="//*[@id='user-message']";
  public String SimpleFormDemo_Showmessage="//*[@id='get-input']/button";
  public String SimpleFormDemo_showmessageoutput="//*[@id='display']";

  public String SimpleFormDemo_Entera="//*[@id='sum1']";
  public String SimpleFormDemo_Enterb="//*[@id='sum2']";
  public String SimpleFormDemo_getTotalbtn="//*[@id='gettotal']/button";
  public String SimpleFormDemo_getTotalvalue="//*[@id='displayvalue']";

  //Table
  public String Table="//*[@id='navbar-brand-centered']/ul[1]/li[3]/a";
  public String TablePagination="//*[@id='navbar-brand-centered']/ul[1]/li[3]/ul/li[1]/a";
  public String Tabledata="//*[@id='myTable']";
  
  //List Box
  public String ListBox="//*[@id='navbar-brand-centered']/ul[2]/li[3]/a";
  public String BootstrapListBox="//*[@id='navbar-brand-centered']/ul[2]/li[3]/ul/li[1]/a";
  public String JQueryListBox="//*[@id='navbar-brand-centered']/ul[2]/li[3]/ul/li[2]/a";
  public String DataListFilter="//*[@id='navbar-brand-centered']/ul[2]/li[3]/ul/li[3]/a";
  
  public String BootstrapListBox_left_List="//*[@class='dual-list list-left col-md-5']/div/ul/li";
  public String BootstrapListBox_right_List="//*[@class='dual-list list-right col-md-5']/div/ul/li";
  public String BootstrapListBox_left_selectall="//*[@id='listhead']/div[2]/div/a";
  public String BootstrapListBox_right_selectall="//*[@id='listhead']/div[1]/div/a";
  public String BootstrapListBox_leftarrow="//*[@class='list-arrows col-md-1 text-center']/button[1]";
  public String BootstrapListBox_rightarrow="//*[@class='list-arrows col-md-1 text-center']/button[2]";
  
  
}
