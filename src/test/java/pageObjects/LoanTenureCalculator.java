package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanTenureCalculator 
{
	WebDriver driver;
	
	//WebElements
	@FindBy(xpath="//input[@id='loanamount']") WebElement TextBox_LTC_LoanAmount ;
	@FindBy(xpath="//div[@id='loanamountslider']/div")
	public WebElement Slider_LTC_LoanAmount ;
	
    @FindBy(xpath="//input[@id='loanemi']") WebElement TextBox_LTC_EMI ;
	@FindBy(xpath="//div[@id='loanemislider']/div")
	public WebElement Slider_LTC_EMI ;
	
	@FindBy(xpath="//input[@id='loaninterest']") WebElement TextBox_LTC_InterestRate;
	@FindBy(xpath="//div[@id='loaninterestslider']/div")
	public WebElement Slider_LTC_InterestRate ;
	
	@FindBy(xpath="//input[@id='loanfees']") WebElement TextBox_LTC_LoanCharges ;
	@FindBy(xpath="//div[@id='loanfeesslider']/div")
	public WebElement Slider_LTC_LoanCharges ;
	

	
	
	
	//constructor
	public LoanTenureCalculator(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	public void setLTCLoanAmount(String amount)
	{
		for(int i=0;i<10;i++)
		{
			TextBox_LTC_LoanAmount.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LTC_LoanAmount.sendKeys(amount);
	}
	
	public void setLTC_EMI(String emi)
	{
		for(int i=0;i<10;i++)
		{
			TextBox_LTC_EMI.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LTC_EMI.sendKeys(emi);
	}
	
	public void setLTCInterestRate(String rate)
	{
		for(int i=0;i<7;i++)
		{
			TextBox_LTC_InterestRate.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LTC_InterestRate.sendKeys(rate);
	}
	
	public void setLTCLoanCharge(String charge)
	{
		for(int i=0;i<7;i++)
		{
			TextBox_LTC_LoanCharges.sendKeys(Keys.BACK_SPACE);
		}
		TextBox_LTC_LoanCharges.sendKeys(charge);
	}

}
