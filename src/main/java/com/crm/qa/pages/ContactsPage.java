package com.crm.qa.pages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[1]")
	WebElement contactsLabel;

	@FindBy(name = "first_name")
	WebElement firstName;

	@FindBy(name = "last_name")
	WebElement lastName;
	
	@FindBy(xpath = "/html/body/div[3]/div/div[3]/button[2]")
	WebElement deletecontact;

	@FindBy(xpath = "//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")
	WebElement saveBtn;

	@FindBy(linkText = "New")
	WebElement NewBtnContLink;

	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}

	public void selectContactsByName(String name) throws InterruptedException{

		int rowscount = driver.findElements(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr")).size();
		int columncount = driver.findElements(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td")).size();
		System.out.println("rowcount"+rowscount);
		System.out.println("columncount"+columncount);
		selectcontact: for (int i = 1; i <= rowscount; i++) {
		for (int j = 1; j <= columncount; j++) {
		String actualString = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				
		if (actualString.contentEquals(name)) {
				System.out.println("Found Expected Name");
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[1]")).click();
				Thread.sleep(5000);
				break selectcontact;

				}
			}
		System.out.println("No Record Found");
		}
	}
	
	public void deleteContactsByName(String name) throws InterruptedException{
		
		int rowscount = driver.findElements(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr")).size();
		int columncount = driver.findElements(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[1]/td")).size();
		System.out.println("row count is " + rowscount);
		System.out.println("Column count is " + columncount);
		deletecontact: for (int i = 1; i <= rowscount; i++) {
			for (int j = 1; j <= columncount; j++) {
				String actualString = driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[" + j + "]")).getText();
				if (actualString.contentEquals(name)) {
					System.out.println("Found Expected Name");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div[2]/div[2]/div/div[2]/table/tbody/tr[" + i + "]/td[8]/div/button")).click();
					Thread.sleep(7000);	
					deletecontact.click();
					Thread.sleep(5000);
					break deletecontact;

				}
			}
			System.out.println("No Record Found");
			}
	}

	public void createNewContact(String ftName, String ltName) throws InterruptedException{

		NewBtnContLink.click();
		System.out.println("Clicked on New Button");
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		saveBtn.click();
		Thread.sleep(10000);
		
	}

}
