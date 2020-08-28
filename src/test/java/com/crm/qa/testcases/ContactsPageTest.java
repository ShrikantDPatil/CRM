/*
 * @author Naveen Khunteta
 * 
 */

package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName = "contacts";

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(10000);
		contactsPage = homePage.clickOnContactsLink();
		Thread.sleep(10000);

	}

	@Test(priority = 1)
	public void verifyContactsPageLabel() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}

	@Test(priority = 2)
	public void selectSingleContactsTest() throws InterruptedException {
		contactsPage.selectContactsByName("Tom Peter");
	}

	@Test(priority = 3)
	public void selectMultipleContactsTest() throws InterruptedException {
		contactsPage.selectContactsByName("Tom Peter");
		contactsPage.selectContactsByName("shrikant patil");
	}

	@Test(priority = 4)
	public void deleteSingleContactsTest() throws InterruptedException {
		contactsPage.deleteContactsByName("Tom Peter");
	}

	@Test(priority = 5)
	public void deleteMultipleContactsTest() throws InterruptedException {
		contactsPage.deleteContactsByName("Tom Peter");
		contactsPage.deleteContactsByName("shrikant patil");

	}
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority = 6, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String firstName, String lastName) throws InterruptedException {
		// homePage.clickOnContactsLink();
		// contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		// Thread.sleep(10000);
		contactsPage.createNewContact(firstName, lastName);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
