package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.EMICalculator;
import pageObjects.LoanTenureCalculator;
import pageObjects.NavigatingElements;

public class LoanTenureCalculatorUICheckSteps 
{
	WebDriver driver=BaseClass.getDriver();
	Properties p;
	
	@Given("user navigates to Loan Tenure Calculator")
	public void user_navigates_to_loan_tenure_calculator() 
	{
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Tenure Calculator UI check Scenario started -----");
		NavigatingElements move=new NavigatingElements(driver);
		move.selectInCalculatorsDropDown("Loan Calculator");
		EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanTenureCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully navigated to Loan Tenure Calculator -----");
	}

	@When("user enters loan amount in the loan amount input box in LTC")
	public void user_enters_loan_amount_in_the_loan_amount_input_box_in_ltc() throws IOException 
	{
	    LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
	    p=BaseClass.getProperties();
		String amount = p.getProperty("LTCLoanAmount");
	    ltc.setLTCLoanAmount(amount);
	    EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanTenureCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Amount entered Successfully -----");
	}

	@Then("loan amount slider should be moved to the same value in LTC")
	public void loan_amount_slider_should_be_moved_to_the_same_value_in_ltc() throws IOException 
	{
		p=BaseClass.getProperties();
		String amount = p.getProperty("LTCLoanAmount");
		
		LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
		String location=ltc.Slider_LTC_LoanAmount.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double amt=(per*2500000)/12.5;
		if(amt==Double.parseDouble(amount))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Amount slider validated -----");
	}

	@When("user enters EMI amount in the EMI amount input box in LTC")
	public void user_enters_emi_amount_in_the_emi_amount_input_box_in_ltc() throws IOException 
	{
		LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
		p=BaseClass.getProperties();
		String emiAmount = p.getProperty("LTCEMI");
	    ltc.setLTC_EMI(emiAmount);
	    EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanTenureCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- EMI Amount entered Successfully -----");
	}

	@Then("EMI amount slider should be moved to the same value in LTC")
	public void emi_amount_slider_should_be_moved_to_the_same_value_in_ltc() throws IOException 
	{
		LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
		String location=ltc.Slider_LTC_EMI.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double emi=(per*34012.24)/34;
		if(emi>100000)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- EMI Amount slider validated -----");
	    
	}

	@When("user enters interest rate in the interest rate input box in LTC")
	public void user_enters_interest_rate_in_the_interest_rate_input_box_in_ltc() throws IOException 
	{
		LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
		p=BaseClass.getProperties();
		String interest = p.getProperty("LTCInterestRate");
	    ltc.setLTCInterestRate(interest);
	    EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanTenureCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Interest Rate entered Successfully -----");
	    
	}

	@Then("interest rate slider should be moved to the same value in LTC")
	public void interest_rate_slider_should_be_moved_to_the_same_value_in_ltc() throws IOException 
	{
		p=BaseClass.getProperties();
		String interest = p.getProperty("LTCInterestRate");
		
		LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
		String location=ltc.Slider_LTC_InterestRate.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double rate=(per*5)/25;
		if(rate==Double.parseDouble(interest))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Interest Rate slider validated -----");
	    
	}

	@When("user enters charges in the charges input box in LTC")
	public void user_enters_charges_in_the_charges_input_box_in_ltc() throws IOException 
	{
		LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
		p=BaseClass.getProperties();
		String charges = p.getProperty("LTCCharges");
	    ltc.setLTCLoanCharge(charges);
	    EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanTenureCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Charges entered Successfully -----");
		
	}

	@Then("charges slider should be moved to the same value in LTC")
	public void charges_slider_should_be_moved_to_the_same_value_in_ltc() throws IOException
	{
		p=BaseClass.getProperties();
		String charges = p.getProperty("LTCCharges");
		
		LoanTenureCalculator ltc=new LoanTenureCalculator(driver);
		String location=ltc.Slider_LTC_LoanCharges.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double charge=(per*25000)/25;
		if(charge==Double.parseDouble(charges))
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
