package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLoanEMICalculator 
{
WebDriver driver;
	
	//WebElements
	@FindBy(xpath="//input[@id='homeprice']") WebElement TextBox_HV;
	@FindBy(xpath="//input[@id='downpayment']") WebElement TextBox_DP;
	@FindBy(xpath="//input[@id='homeloaninsuranceamount']") WebElement TextBox_LI;
	@FindBy(xpath="//input[@id='homeloaninterest']") WebElement TextBox_InterestRate;
	@FindBy(xpath="//input[@id='homeloanterm']") WebElement TextBox_LoanTenure;
	@FindBy(xpath="//input[@id='loanfees']") WebElement TextBox_LoanCharges;
	@FindBy(xpath="//input[@id='onetimeexpenses']") WebElement TextBox_OneTimeExpenses;
	@FindBy(xpath="//input[@id='propertytaxes']") WebElement TextBox_PropertyTax;
	@FindBy(xpath="//input[@id='homeinsurance']") WebElement TextBox_HomeInsurancePerYear;
	@FindBy(xpath="//input[@id='maintenanceexpenses']") WebElement TextBox_Maintenence;
	@FindBy(xpath="//input[@id='startmonthyear']") WebElement Calender;

	
	

	//constructor
	public HomeLoanEMICalculator(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//Action Methods
	public void setHomeValue(String homeValue)
	{
		TextBox_HV.clear();
		TextBox_HV.sendKeys(homeValue);
	}
	
	public void setDownPayment(String downPayment)
	{
		TextBox_DP.clear();
		TextBox_DP.sendKeys(downPayment);
	}
	
	public void setLoanInsurance(String loanInsurance)
	{
		TextBox_LI.clear();
		TextBox_LI.sendKeys(loanInsurance);
	}
	
	public void setInterestRate(String interestRate)
	{
		TextBox_InterestRate.sendKeys(Keys.BACK_SPACE);
		TextBox_InterestRate.sendKeys(Keys.BACK_SPACE);
		TextBox_InterestRate.sendKeys(interestRate);
	}
	
	public void setLoanTenure(String loanTenure)
	{
		TextBox_LoanTenure.sendKeys(Keys.BACK_SPACE);
		TextBox_LoanTenure.sendKeys(Keys.BACK_SPACE);
		TextBox_LoanTenure.sendKeys(loanTenure);
	}
	
	public void setLoanCharges(String loanCharges)
	{
		TextBox_LoanCharges.sendKeys(Keys.BACK_SPACE);
		TextBox_LoanCharges.sendKeys(Keys.BACK_SPACE);
		TextBox_LoanCharges.sendKeys(Keys.BACK_SPACE);
		TextBox_LoanCharges.sendKeys(Keys.BACK_SPACE);
		TextBox_LoanCharges.sendKeys(loanCharges);
	}
	
	public void setOneTimeExpenses(String expenses)
	{
		TextBox_OneTimeExpenses.clear();
		TextBox_OneTimeExpenses.sendKeys(expenses);
	}
	
	public void setPropertyTax(String propertyTax)
	{
		TextBox_PropertyTax.clear();
		TextBox_PropertyTax.sendKeys(propertyTax);
	}
	
	public void setHomeInsurancePerYear(String hipy)
	{
		TextBox_HomeInsurancePerYear.clear();
		TextBox_HomeInsurancePerYear.sendKeys(hipy);
	}
	
	public void setMaintenenceCharge(String charge)
	{
		TextBox_Maintenence.clear();
		TextBox_Maintenence.sendKeys(charge);
	}
	
	public void setCalender(String yearInputString,String monthString)
	{
		Calender.click();
		int yearInput=Integer.parseInt(yearInputString);
		
		String yearDisplayedString=driver.findElement(By.xpath("(//th[@class=\"datepicker-switch\"])[2]")).getText();
		int yearDisplayed=Integer.parseInt(yearDisplayedString);
		if(yearDisplayed<yearInput)
		{
			driver.findElement(By.xpath("(//th[@class=\"next\"])[2]")).click();
			yearDisplayedString=driver.findElement(By.xpath("(//th[@class=\"datepicker-switch\"])[2]")).getText();
			yearDisplayed=Integer.parseInt(yearDisplayedString);
			
		}
		if(yearDisplayed>yearInput)
		{
			driver.findElement(By.xpath("(//th[@class=\"prev\"])[2]")).click();
			yearDisplayedString=driver.findElement(By.xpath("(//th[@class=\"datepicker-switch\"])[2]")).getText();
			yearDisplayed=Integer.parseInt(yearDisplayedString);
		}
		
		List<WebElement> months=driver.findElements(By.xpath("//span[contains(@class,\'month\')]"));
		for(WebElement month:months)
		{
			if(month.getText().equalsIgnoreCase(monthString))
			{
				month.click();
				break;
			}
		}
		
	}
	
	
	
	

}
