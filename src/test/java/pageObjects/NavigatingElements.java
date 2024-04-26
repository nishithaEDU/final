package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigatingElements 
{
	WebDriver driver;
	
	//WebElements
	@FindBy(xpath="//a[@title='EMI Calculator']") WebElement Button_Icon;
	@FindBy(xpath="//a[normalize-space()='Home Loan']") WebElement Button_HomeLoan;
	@FindBy(xpath="//a[normalize-space()='Personal Loan']") WebElement Button_PersonalLoan;
	@FindBy(xpath="//a[normalize-space()='Car Loan']") WebElement Button_CarLoan;
	@FindBy(xpath="//a[@id='menu-item-dropdown-2696']") WebElement DropDown_Calculators;
	
	
	
	//constructor
	public NavigatingElements(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//Action Methods
	public void navigateToHome()
	{
		Button_Icon.click();
	}
	
	public void navigateToHomeLoan()
	{
		Button_HomeLoan.click();
	}
	
	public void navigateToPersonalLoan()
	{
		Button_PersonalLoan.click();
	}
	
	public void navigateToCarLoan()
	{
		Button_CarLoan.click();
	}
	
	public void selectInCalculatorsDropDown(String calculator)
	{
		DropDown_Calculators.click();
		List<WebElement> elements=driver.findElements(By.xpath("//ul[@class=\'dropdown-menu show\']//following::a"));
		for(int i=0;i<elements.size();i++)
		{
			if(elements.get(i).getAttribute("title").equalsIgnoreCase(calculator))
			{
				elements.get(i).click();
				break;
			}
		}
	}
	


}
