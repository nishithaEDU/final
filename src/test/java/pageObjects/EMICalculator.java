package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EMICalculator 
{
	WebDriver driver;
	
	    //WebElements
	
		@FindBy(xpath="//input[@id='loanamount']") WebElement TextBox_EMIC_LoanAmount ;
		@FindBy(xpath="//div[@id='loanamountslider']/div")
		public WebElement Slider_EMIC_LoanAmount ;
		
		@FindBy(xpath="//input[@id='loaninterest']") WebElement TextBox_EMIC_LoanInterest ;
		@FindBy(xpath="//div[@id='loaninterestslider']/div")
		public WebElement Slider_EMIC_LoanInterest ;
		
		@FindBy(xpath="//input[@id='loanterm']") WebElement TextBox_EMIC_LoanTenure ;
		@FindBy(xpath="//div[@id='loantermslider']/div")
		public WebElement Slider_EMIC_LoanTenure ;
		
		@FindBy(xpath="//input[@id='loanfees']") WebElement TextBox_EMIC_LoanCharges ;
		@FindBy(xpath="//div[@id='loanfeesslider']/div")
		public WebElement Slider_EMIC_LoanCharges ;
		
		@FindBy(xpath="//label[normalize-space()='Mo']") WebElement Button_EMIC_Months ;
		
		@FindBy(xpath="//a[normalize-space()='Loan Amount Calculator']") WebElement Button_LoanAmountCalculator ;
		
		@FindBy(xpath="//a[normalize-space()='Loan Tenure Calculator']") WebElement Button_LoanTenureCalculator ;
		
	

		
		
		//constructor
		public EMICalculator(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
		
		
		//Action Methods
		
		public void setEMICLoanAmount(String amount)
		{
			for(int i=0;i<10;i++)
			{
				TextBox_EMIC_LoanAmount.sendKeys(Keys.BACK_SPACE);
			}
			TextBox_EMIC_LoanAmount.sendKeys(amount);
		}
		
		public void setEMICLoanInterest(String interest)
		{
			for(int i=0;i<5;i++)
			{
				TextBox_EMIC_LoanInterest.sendKeys(Keys.BACK_SPACE);
			}
			TextBox_EMIC_LoanInterest.sendKeys(interest);
		}
		
		public void setEMICLoanTenure(String tenure)
		{
			for(int i=0;i<2;i++)
			{
				TextBox_EMIC_LoanTenure.sendKeys(Keys.BACK_SPACE);
			}
			TextBox_EMIC_LoanTenure.sendKeys(tenure);
		}
		
		public void setEMICLoanCharges(String charge)
		{
			for(int i=0;i<7;i++)
			{
				TextBox_EMIC_LoanCharges.sendKeys(Keys.BACK_SPACE);
			}
			TextBox_EMIC_LoanCharges.sendKeys(charge);
		}
		
		public void clickOnMonths()
		{
			Button_EMIC_Months.click();
		}
		
		public void selectLoanAmountCalculator()
		{
			Button_LoanAmountCalculator.click();
		}
		
		public void selectLoanTenureCalculator()
		{
			Button_LoanTenureCalculator.click();
		}



}
