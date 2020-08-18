package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CallsPage;
import com.crm.qa.pages.CasesPage;
import com.crm.qa.pages.CompaignsPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.DocumentsPage;
import com.crm.qa.pages.EmailPage;
import com.crm.qa.pages.FormsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	CalendarPage calendarPage;
	CompaniesPage companiesPage;
	CasesPage casesPage;
	CallsPage callsPage;
	DocumentsPage documentsPage;
	EmailPage emailPage;
	CompaignsPage compaignsPage;
	FormsPage formsPage;

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(5000);
	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "Cogmento CRM", "Home page title not matched");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		String UserName = homePage.verifyCorrectUserName();
		Assert.assertEquals(UserName, "shrikant patil", "User Name not matched");
	}

	@Test(priority = 3)
	public void verifyContactsLinkTest() {
		contactsPage = homePage.clickOnContactsLink();
	}

	@Test(priority = 4)
	public void verifyDealsLinkTest() {
		dealsPage = homePage.clickOnDealsLink();
	}

	@Test(priority = 5)
	public void verifyTasksLinkTest() {
		tasksPage = homePage.clickOnTasksLink();
	}

	@Test(priority = 6)
	public void verifyCalendarLinkTest() {
		calendarPage = homePage.clickOnCalendarLink();
	}

	@Test(priority = 7)
	public void verifyCompaniesLinkTest() {
		companiesPage = homePage.clickOnComapaniesLink();
	}

	@Test(priority = 8)
	public void verifyCasesLinkTest() {
		casesPage = homePage.clickOnCasesLink();
	}

	@Test(priority = 9)
	public void verifyCallsLinkTest() {
		callsPage = homePage.clickOnCallsLink();
	}

	@Test(priority = 10)
	public void verifyDocumentsLinkTest() {
		documentsPage = homePage.clickOnDocumentsLink();
	}

	@Test(priority = 11)
	public void verifyEmailLinkTest() {
		emailPage = homePage.clickOnEmailLink();
	}

	@Test(priority = 12)
	public void verifyCompaignsLinkTest() {
		compaignsPage = homePage.clickOnCompaignsLink();
	}

	@Test(priority = 13)
	public void verifyFormsLinkTest() {
		formsPage = homePage.clickOnFormsLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}