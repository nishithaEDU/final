package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutputStreamClass 
{
	public void extractTable(WebDriver driver) throws IOException
	{
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+ "/ExcelSheets/HomeLoanEMI.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		
		List<WebElement> headings=driver.findElements(By.xpath("//th[contains(@id,\'header\')]"));
		List<WebElement> enteries=driver.findElements(By.xpath("//tr[@class=\'row no-margin yearlypaymentdetails\']/td"));
		
		XSSFRow titleRow=sheet.createRow(0);
		int i=0;
		for(WebElement heading:headings)
		{
			titleRow.createCell(i).setCellValue(heading.getText());
			i++;
		}
		XSSFRow row;
		int k=1;
		int j=1;
		row=sheet.createRow(k);
		for(WebElement entry:enteries)
		{
			if(j%8==0)
			{
				k++;
				row=sheet.createRow(k);
				j=1;
				row.createCell(j-1).setCellValue(entry.getText());
				j++;
			}
			else
			{
				row.createCell(j-1).setCellValue(entry.getText());
				j++;
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
	}

}
