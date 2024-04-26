Topic Name: Find the Interest Amount for current year
----------------------------------------------------------------------------------------------------------------------------------------------------

Problem Statement: Find the Interest Amount for current year

1. Buying a  car of 15 Lac
2. Interest rate of 9.5%
3. Tenure should be 1 year.
Display the interest amount & principal amount of first month.
(Suggested Site: emicalculator.net  / HDFCbank.com etc. however you are free to use any other legitimate site)
----------------------------------------------------------------------------------------------------------------------------------------------------

Detailed Description: Main Project

1. Find the EMI for Car with price of 15 Lac, Interest rate of 9.5% & Tenure 1 year; Display the interest amount & principal amount for one month
2. From Menu, pick Home Loan EMI Calculator, fill relevant details & extract all the data from  year on year table & store in excel;
3. From Menu, pick Loan Calculator and under EMI calculator, do all UI check for text box & scales; change the Loan tenure for year & month,check the 
   change in scale; Re-use the same validation for Loan Amount Calculator & Loan Tenure Calculator
(Suggested Site: emicalculator.net  however you are free to use any other legitimate site)
----------------------------------------------------------------------------------------------------------------------------------------------------

Automation concepts used:

-> Validation of transactions & do calculations;
-> Extract table values & store in excel
-> Filling data in screen & multiple UI validations
-> Navigation from Menus
-> Reusable methods
-> Extract multiple options items & store in collections.
-> logs and screenshot in Extent report
-> Data Driven approach.
-> Cross Browser Testing.
-> Cucumber framework.
-> TestNG framework.
-> Page object model with PageFactory.
-> Run on Grid
----------------------------------------------------------------------------------------------------------------------------------------------------

Output: [Chrome and Edge]
==================

Home Page Loaded
Opened emicalculator.net application
Navigated to Car Loan EMI Calculator
Entered all the required inputs from properties file
Displayed Interest and Principle on the console
Navigated to Home Loan EMI Calculator
Entered all the required inputs from properties file
Extracted year on year table to EXCEL
Validated all the UI Checks for EMI Calculator, Loan Amount Calculator and Loan Tenure Calculator
Closed the webpage
----------------------------------------------------------------------------------------------------------------------------------------------------

Dependencies and Plugins:

 <dependencies>
			<!--
			https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
			<dependency>
				<groupId>org.seleniumhq.selenium</groupId>
				<artifactId>selenium-java</artifactId>
				<version>4.18.1</version>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-grid -->
			<dependency>
			    <groupId>org.seleniumhq.selenium</groupId>
			    <artifactId>selenium-grid</artifactId>
			    <version>4.18.1</version>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
			<dependency>
				<groupId>org.apache.commons</groupId>
				<artifactId>commons-lang3</artifactId>
				<version>3.14.0</version>
			</dependency>

			
			<!-- https://mvnrepository.com/artifact/io.github.bonigarcia/webdrivermanager -->
			<dependency>
			    <groupId>io.github.bonigarcia</groupId>
			    <artifactId>webdrivermanager</artifactId>
			    <version>5.7.0</version>
			</dependency>
	
			<!-- https://mvnrepository.com/artifact/org.testng/testng -->
			<dependency>
				<groupId>org.testng</groupId>
				<artifactId>testng</artifactId>
				<version>7.9.0</version>
				<scope>test</scope>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
			<dependency>
				<groupId>commons-io</groupId>
				<artifactId>commons-io</artifactId>
				<version>2.15.1</version>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
			<dependency>
				<groupId>com.aventstack</groupId>
				<artifactId>extentreports</artifactId>
				<version>5.1.1</version>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
			<dependency>
				<groupId>org.apache.poi</groupId>
				<artifactId>poi-ooxml</artifactId>
				<version>5.2.5</version>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
			<dependency>
				<groupId>org.apache.poi</groupId>
				<artifactId>poi</artifactId>
				<version>5.2.5</version>
			</dependency>
			
			<dependency>
				<groupId>org.apache.logging.log4j</groupId>
				<artifactId>log4j-core</artifactId>
				<version>2.23.1</version>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.23.1</version>
</dependency>

			
			<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-java -->
			<dependency>
			    <groupId>io.cucumber</groupId>
			    <artifactId>cucumber-java</artifactId>
			    <version>7.15.0</version>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-testng -->
			<dependency>
			    <groupId>io.cucumber</groupId>
			    <artifactId>cucumber-testng</artifactId>
			    <version>7.15.0</version>
			      <scope>test</scope>
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/io.cucumber/cucumber-junit -->
			<dependency>
			    <groupId>io.cucumber</groupId>
			    <artifactId>cucumber-junit</artifactId>
			    <version>7.15.0</version>
			    
			</dependency>
			
			<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports-cucumber4-adapter -->
	<dependency>
	    <groupId>tech.grasshopper</groupId>
	    <artifactId>extentreports-cucumber7-adapter</artifactId>
	    <version>1.14.0</version>
	</dependency>
	
	</dependencies>

	<build>
		<plugins>
		
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>3.13.0</version>
				<configuration>					
                    <source>17</source>
                    <target>17</target>                
				</configuration>
			</plugin>
			
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>3.2.5</version>
				<configuration>
					<suiteXmlFiles>
						<suiteXmlFile>testng.xml</suiteXmlFile>
					</suiteXmlFiles>
				</configuration>
			</plugin>
			
		</plugins>
	</build>
----------------------------------------------------------------------------------------------------------------------------------------------------