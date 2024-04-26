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
import pageObjects.LoanAmountCalculator;
import pageObjects.NavigatingElements;

public class LoanAmountCalculatorUICheckSteps 
{
	WebDriver driver=BaseClass.getDriver();
	Properties p;
	
	@Given("user navigates to Loan Amount Calculator")
	public void user_navigates_to_loan_amount_calculator() 
	{
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Amount Calculator UI Validation Scenario started -----");
		NavigatingElements move=new NavigatingElements(driver);
		move.selectInCalculatorsDropDown("Loan Calculator");
		EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanAmountCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully navigated to Loan Amount Calculator -----");
	}

	@When("user enters EMI amount in the EMI amount input box")
	public void user_enters_emi_amount_in_the_emi_amount_input_box() throws IOException 
	{
	   LoanAmountCalculator lac=new LoanAmountCalculator(driver);
	   p=BaseClass.getProperties();
	   String EMIAmount = p.getProperty("LACEMI");
	   lac.setEMI(EMIAmount);
	   EMICalculator emi=new EMICalculator(driver);
	   emi.selectLoanAmountCalculator();
	   ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- EMI Amount entered Successfully -----");
	   
	}

	@Then("EMI amount slider should be moved to the same value")
	public void emi_amount_slider_should_be_moved_to_the_same_value() throws IOException 
	{
		p=BaseClass.getProperties();
		String EMIAmount = p.getProperty("LACEMI");
		   
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		String location=lac.Slider_LAC_EMI.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double emi=(per*25000)/25;
		if(emi==Double.parseDouble(EMIAmount))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- EMI Amount slider Validated -----");
	}
	//we are here
	@When("user enters interest rate in the interest rate input box in LAC")
	public void user_enters_interest_rate_in_the_interest_rate_input_box_in_LAC() throws IOException 
	{
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		p=BaseClass.getProperties();
		String interest = p.getProperty("LACInterestRate");
		lac.setLACInterestRate(interest);
		EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanAmountCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- EMI Interest Rate entered Successfully -----");
		
	}

	@Then("interest rate slider should be moved to the same value in LAC")
	public void interest_rate_slider_should_be_moved_to_the_same_value_in_LAC() throws IOException
	{
		p=BaseClass.getProperties();
		String interest = p.getProperty("LACInterestRate");
		
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		String location=lac.Slider_LAC_LoanInterest.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double rate=(per*2.5)/12.5;
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

	@When("user enters loan tenure in the loan tenure input box in LAC")
	public void user_enters_loan_tenure_in_the_loan_tenure_input_box_in_LAC() throws IOException 
	{
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		p=BaseClass.getProperties();
		String tenure = p.getProperty("LACLoanTenure");
		lac.setLACInterestTenure(tenure);
		EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanAmountCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Tenure entered Successfully -----");
	}

	@Then("loan tenure slider should be moved to the same value in LAC")
	public void loan_tenure_slider_should_be_moved_to_the_same_value_in_LAC() throws IOException 
	{
		p=BaseClass.getProperties();
		String inputTenure = p.getProperty("LACLoanTenure");
		
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		String location=lac.Slider_LAC_LoanTenure.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double tenure=(int)Math.ceil((per*5)/16.6667);
		if(tenure==Double.parseDouble(inputTenure))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Tenure slider validated -----");
		
	}
	
	@When("user clicks on month tenure in LAC")
	public void user_clicks_on_month_tenure_in_LAC() 
	{
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		lac.clickOnMonths();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Switched to Months in Tenure -----");
		
	}

	@Then("the slider should be moved to the same value in LAC")
	public void the_slider_should_be_moved_to_the_same_value_in_LAC() throws IOException 
	{
		p=BaseClass.getProperties();
		String inputTenure = p.getProperty("LACLoanTenure");
		
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		String location=lac.Slider_LAC_LoanTenure.getAttribute("style");
		String width[]=location.split(" ");
		String percentage[]=width[1].split("%");
		double per=Double.parseDouble(percentage[0]);
		double tenure=(int)Math.ceil((per*60)/16.6667);
		if(tenure==Double.parseDouble(inputTenure)*12)
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Tenure slider with months validated -----");

	}

	@When("user enters charges in the charges input box in LAC")
	public void user_enters_charges_in_the_charges_input_box_in_LAC() throws IOException 
	{
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		p=BaseClass.getProperties();
		String charges = p.getProperty("LACCharges");
		lac.setLACLoanCharge(charges);
		EMICalculator emi=new EMICalculator(driver);
		emi.selectLoanAmountCalculator();
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Loan Charges entered Successfully -----");
	}

	@Then("charges slider should be moved to the same value in LAC")
	public void charges_slider_should_be_moved_to_the_same_value_in_LAC() throws IOException 
	{
		p=BaseClass.getProperties();
		String charges = p.getProperty("LACCharges");
		
		LoanAmountCalculator lac=new LoanAmountCalculator(driver);
		String location=lac.Slider_LAC_LoanCharges.getAttribute("style");
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
