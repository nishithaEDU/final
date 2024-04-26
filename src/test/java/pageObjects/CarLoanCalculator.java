package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarLoanCalculator 
{
WebDriver driver;
	
	//WebElements
	@FindBy(xpath="//input[@id='loanamount']") WebElement TextBox_CarLoanAmount;
	@FindBy(xpath="//input[@id='loaninterest']") WebElement TextBox_CarLoanInterest;
	@FindBy(xpath="//input[@id='loanterm']") WebElement TextBox_CarLoanTenure;

	
	
	
	//constructor
	public CarLoanCalculator(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Action Methods
	public void setCarLoanAmount(String amount)
	{
		TextBox_CarLoanAmount.clear();
		TextBox_CarLoanAmount.sendKeys(amount);
	}
	
	public void setCarLoanInterest(String rate)
	{
		
		TextBox_CarLoanInterest.sendKeys(Keys.BACK_SPACE);
		TextBox_CarLoanInterest.sendKeys(Keys.BACK_SPACE);
		TextBox_CarLoanInterest.sendKeys(Keys.BACK_SPACE);
		TextBox_CarLoanInterest.sendKeys(rate);
	}
	
	public void setCarLoanTenure(String tenure)
	{
		TextBox_CarLoanTenure.sendKeys(Keys.BACK_SPACE);
		TextBox_CarLoanTenure.sendKeys(Keys.BACK_SPACE);
		TextBox_CarLoanTenure.sendKeys(tenure);
	}

}
