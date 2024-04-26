package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EMICalculator;
import pageObjects.NavigatingElements;

public class EMICalculatorUICheckSteps 
{
	WebDriver driver=BaseClass.getDriver();
	Properties p;
	
	@Given("user navigates to EMI Calculator")
	public void user_navigates_to_emi_calculator() 
	{
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- EMI Calculation UI check started -----");
		NavigatingElements move=new NavigatingElements(driver);
		move.selectInCalculatorsDropDown("Loan Calculator");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully navigated to EMI Calculator -----");
	}

	@When("user enters loan amount in the loan amount input box")
	public void user_enters_loan_amount_in_the_loan_amount_input_box() throws IOException 
	{
		EMICalculator emi=new EMICalculator(driver);
		p=BaseClass.getProperties();
		String loanAmount = p.getProperty("EMICLoanAmount");
		emi.setEMICLoanAmount(loanAmount);
		driver.findElement(By.xpath("//a[@class='hidden-ts'][normalize-space()='EMI Calculator']")).click();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Amount entered Successfully -----");
		
	}

	@Then("loan amount slider should be moved to the same value")
	public void loan_amount_slider_should_be_moved_to_the_same_value() throws IOException 
	{
		p=BaseClass.getProperties();
		String loanAmount = p.getProperty("EMICLoanAmount");
		
		EMICalculator emi=new EMICalculator(driver);
		String location=emi.Slider_EMIC_LoanAmount.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double amt=(per*2500000)/12.5;
		if(amt== Double.parseDouble(loanAmount))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Amount slider Validated -----");
	}

	@When("user enters interest rate in the interest rate input box")
	public void user_enters_interest_rate_in_the_interest_rate_input_box() throws IOException 
	{
		EMICalculator emi=new EMICalculator(driver);
		p=BaseClass.getProperties();
		String interestRate = p.getProperty("EMICInterestRate");
		emi.setEMICLoanInterest(interestRate);
		driver.findElement(By.xpath("//a[@class='hidden-ts'][normalize-space()='EMI Calculator']")).click();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Interest Amount entered Successfully -----");
		
	}

	@Then("interest rate slider should be moved to the same value")
	public void interest_rate_slider_should_be_moved_to_the_same_value() throws IOException
	{
		p=BaseClass.getProperties();
		String interestRate = p.getProperty("EMICInterestRate");
		
		EMICalculator emi=new EMICalculator(driver);
		String location=emi.Slider_EMIC_LoanInterest.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double rate=(per*2.5)/12.5;
		if(rate==Double.parseDouble(interestRate))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Interest Rate slider Validated -----");
		
	}

	@When("user enters loan tenure in the loan tenure input box")
	public void user_enters_loan_tenure_in_the_loan_tenure_input_box() throws IOException 
	{
		EMICalculator emi=new EMICalculator(driver);
		p=BaseClass.getProperties();
		String tenure = p.getProperty("EMICLoanTenure");
		emi.setEMICLoanTenure(tenure);
		driver.findElement(By.xpath("//a[@class='hidden-ts'][normalize-space()='EMI Calculator']")).click();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Tenure entered Successfully -----");
		
	}

	@Then("loan tenure slider should be moved to the same value")
	public void loan_tenure_slider_should_be_moved_to_the_same_value() throws IOException 
	{
		p=BaseClass.getProperties();
		String tenure = p.getProperty("EMICLoanTenure");
		
		EMICalculator emi=new EMICalculator(driver);
		String location=emi.Slider_EMIC_LoanTenure.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double rate=(int)Math.ceil((per*5)/16.6667);
		if(rate==Double.parseDouble(tenure))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Tenure slider Validated -----");
		
	}
	
	@When("user clicks on month tenure")
	public void user_clicks_on_month_tenure() 
	{
		EMICalculator emi=new EMICalculator(driver);
		emi.clickOnMonths();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Switched to months in Tenure -----");
		
	}

	@Then("the slider should be moved to the same value")
	public void the_slider_should_be_moved_to_the_same_value() throws IOException 
	{
		p=BaseClass.getProperties();
		String tenure = p.getProperty("EMICLoanTenure");
		
		EMICalculator emi=new EMICalculator(driver);
		String location=emi.Slider_EMIC_LoanTenure.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double rate=(int)Math.ceil((per*60)/16.6667);
		if(rate==Double.parseDouble(tenure)*12)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Tenure slider Validated for months -----");

	}

	@When("user enters charges in the charges input box")
	public void user_enters_charges_in_the_charges_input_box() throws IOException 
	{
		EMICalculator emi=new EMICalculator(driver);
		p=BaseClass.getProperties();
		String charges = p.getProperty("EMICCharges");
		emi.setEMICLoanCharges(charges);
		driver.findElement(By.xpath("//a[@class='hidden-ts'][normalize-space()='EMI Calculator']")).click();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Charges entered Successfully -----");
		
	}

	@Then("charges slider should be moved to the same value")
	public void charges_slider_should_be_moved_to_the_same_value() throws IOException 
	{
		p=BaseClass.getProperties();
		String charges = p.getProperty("EMICCharges");
		
		EMICalculator emi=new EMICalculator(driver);
		String location=emi.Slider_EMIC_LoanCharges.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double rate=(per*25000)/25;
		if(rate==Double.parseDouble(charges))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Charges slider validated -----");
		
	}
	
}
