package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanAmountCalculator 
{
    WebDriver driver;
	
	//WebElements
    @FindBy(xpath="//input[@id='loanemi']") WebElement TextBox_LAC_EMI ;
	@FindBy(xpath="//div[@id='loanemislider']/div")
	public WebElement Slider_LAC_EMI ;
	
    @FindBy(xpath="//input[@id='loaninterest']") WebElement TextBox_LAC_LoanInterest ;
	@FindBy(xpath="//div[@id='loaninterestslider']/div")
	public WebElement Slider_LAC_LoanInterest ;
	
	@FindBy(xpath="//input[@id='loanterm']") WebElement TextBox_LAC_LoanTenure ;
	@FindBy(xpath="//div[@id='loantermslider']/div")
	public WebElement Slider_LAC_LoanTenure ;
	
	@FindBy(xpath="//input[@id='loanfees']") WebElement TextBox_LAC_LoanCharges ;
	@FindBy(xpath="//div[@id='loanfeesslider']/div")
	public WebElement Slider_LAC_LoanCharges ;
	
	@FindBy(xpath="//label[normalize-space()='Mo']") WebElement Button_LAC_Months;

	
	
	
	//constructor
	public LoanAmountCalculator(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	
	public void setEMI(String emi)
	{
		for(int i=0;i<10;i++)
		{
			TextBox_LAC_EMI.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LAC_EMI.sendKeys(emi);
	}
	
	public void setLACInterestRate(String interest)
	{
		for(int i=0;i<6;i++)
		{
			TextBox_LAC_LoanInterest.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LAC_LoanInterest.sendKeys(interest);
	}
	
	public void setLACInterestTenure(String tenure)
	{
		for(int i=0;i<3;i++)
		{
			TextBox_LAC_LoanTenure.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LAC_LoanTenure.sendKeys(tenure);
		
	}
	
	public void setLACLoanCharge(String charge)
	{
		for(int i=0;i<7;i++)
		{
			TextBox_LAC_LoanCharges.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LAC_LoanCharges.sendKeys(charge);
		
	}

	public void clickOnMonths() 
	{
		Button_LAC_Months.click();
	}
	
	

}
