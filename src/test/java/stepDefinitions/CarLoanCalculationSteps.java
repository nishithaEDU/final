package stepDefinitions;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CarLoanCalculator;
import pageObjects.NavigatingElements;

public class CarLoanCalculationSteps 
{
	WebDriver driver=BaseClass.getDriver();
	Properties p;
	
	
	
	@Given("the user navigates to Car Loan section")
	public void the_user_navigates_to_car_loan_section() 
	{

		
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Car Loan Calculation Scenario started -----");
	    NavigatingElements move=new NavigatingElements(driver);
	    move.navigateToCarLoan();
	    ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully navigated to CAR LOAN section -----");
	   
	}

	@When("user enters the Car Loan Amount")
	public void user_enters_the_car_loan_amount() throws IOException 
	{
	    CarLoanCalculator carLoan=new CarLoanCalculator(driver);
	    p=BaseClass.getProperties();
		String loanAmount = p.getProperty("carLoanAmount");
	    carLoan.setCarLoanAmount(loanAmount);
	    ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully entered the CAR LOAN AMOUNT -----");
	    
	}

	@When("user enters the Interest Rate")
	public void user_enters_the_interest_rate() throws IOException 
	{
		CarLoanCalculator carLoan=new CarLoanCalculator(driver);
		p=BaseClass.getProperties();
		String interestRate = p.getProperty("carInterestRate");
	    carLoan.setCarLoanInterest(interestRate);
	    ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully entered the CAR LOAN INTEREST -----");
	    
	}

	@When("user enters the Loan Tenure")
	public void user_enters_the_loan_tenure() throws IOException 
	{
		CarLoanCalculator carLoan=new CarLoanCalculator(driver);
		p=BaseClass.getProperties();
		String loanTenure = p.getProperty("carLoanTenure");
	    carLoan.setCarLoanTenure(loanTenure);
	    ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully entered the CAR LOAN TENURE -----");
	    
	}

	@Then("display interest and principal amount on console")
	public void display_interest_and_principal_amount_on_console() 
	{
		WebElement year=driver.findElement(By.xpath("((//table)[1]//following::tr/td)[1]"));
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", year);
		js.executeScript("arguments[0].click();", year);
		String principal=driver.findElement(By.xpath("((//table)[1]//following::tr/td[2])[2]")).getText();
	    String interest=driver.findElement(By.xpath("((//table)[1]//following::tr/td[3])[2]")).getText();
	    System.out.println("First month principal is: "+principal);
	    System.out.println("First month interest is: "+interest);
	    ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Successfully extracted the principal and interest of first month -----");
	    ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,"----- Car Loan Calculation Scenario completed -----");
	    
	}
	

}
