package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomeLoanEMICalculator;
import pageObjects.NavigatingElements;
import utilities.OutputStreamClass;

public class HomeLoanEMICalculationSteps 
{
	WebDriver driver=BaseClass.getDriver();
	Properties p;
	
	@Given("the user navigates to Home Loan EMI Calculator")
	public void the_user_navigates_to_home_loan_emi_calculator() 
	{
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Home Loan EMI Calculation Scenario started -----");
		NavigatingElements move=new NavigatingElements(driver);
		move.selectInCalculatorsDropDown("Home Loan EMI Calculator");
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully navigated to Home Loan EMI Calculator -----");
	}

	@When("the user fills the relevant details")
	public void the_user_fills_the_relevant_details() throws IOException 
	{
		HomeLoanEMICalculator home=new HomeLoanEMICalculator(driver);
		p=BaseClass.getProperties();
		String homeValue = p.getProperty("homeValue");
		String downPayment = p.getProperty("downPayment");
		String loanInsurance = p.getProperty("loanInsurance");
		String interestRate = p.getProperty("interestRate");
		String loanTenure = p.getProperty("loanTenure");
		String loanCharge = p.getProperty("loanCharges");
		String year = p.getProperty("calenderYear");
		String month = p.getProperty("calenderMonth");
		String oneTimeExpenses = p.getProperty("oneTimeExpenses");
		String propertyTax = p.getProperty("propertyTax");
		String homeInsurancePerYear = p.getProperty("homeInsurancePerYear");
		String maintenenceCharge = p.getProperty("maintenenceCharge");
		
		home.setHomeValue(homeValue);
		home.setDownPayment(downPayment);
		home.setLoanInsurance(loanInsurance);
		home.setInterestRate(interestRate);
		home.setLoanTenure(loanTenure);
		home.setLoanCharges(loanCharge);
		home.setCalender(year, month);
		home.setOneTimeExpenses(oneTimeExpenses);
		home.setPropertyTax(propertyTax );
		home.setHomeInsurancePerYear(homeInsurancePerYear);
		home.setMaintenenceCharge(maintenenceCharge);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Home Loan EMI Calculation data successfully entered -----");

	}

	@Then("extract the data from year on year table to excel")
	public void extract_the_data_from_year_on_year_table_to_excel() throws IOException 
	{
		OutputStreamClass out=new OutputStreamClass();
		out.extractTable(driver);	
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Home Loan EMI table exported to EXCEL -----");
	}

}
