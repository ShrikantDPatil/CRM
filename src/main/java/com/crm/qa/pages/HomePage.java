package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//*[@id=\"top-header-menu\"]/div[3]/span[1]")
	@CacheLookup
	WebElement userNameLabel;

	@FindBy(linkText = "Contacts")
	WebElement contactsLink;

	@FindBy(linkText = "Deals")
	WebElement dealsLink;

	@FindBy(linkText = "Tasks")
	WebElement tasksLink;

	@FindBy(linkText = "Calendar")
	WebElement calendarLink;

	@FindBy(linkText = "Companies")
	WebElement compaiesLink;

	@FindBy(linkText = "Cases")
	WebElement casesLink;

	@FindBy(linkText = "Calls")
	WebElement callsLink;

	@FindBy(linkText = "Documents")
	WebElement documentsLink;

	@FindBy(linkText = "Email")
	WebElement emailLink;

	@FindBy(linkText = "Campaigns")
	WebElement compaignsLink;

	@FindBy(linkText = "Forms")
	WebElement formsLink;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public String verifyCorrectUserName() {
		return userNameLabel.getText();
	}

	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public CalendarPage clickOnCalendarLink() {
		calendarLink.click();
		return new CalendarPage();
	}

	public CompaniesPage clickOnComapaniesLink() {
		calendarLink.click();
		return new CompaniesPage();
	}

	public CasesPage clickOnCasesLink() {
		casesLink.click();
		return new CasesPage();
	}

	public CallsPage clickOnCallsLink() {
		callsLink.click();
		return new CallsPage();
	}

	public DocumentsPage clickOnDocumentsLink() {
		documentsLink.click();
		return new DocumentsPage();
	}

	public EmailPage clickOnEmailLink() {
		emailLink.click();
		return new EmailPage();
	}

	public CompaignsPage clickOnCompaignsLink() {
		compaignsLink.click();
		return new CompaignsPage();
	}

	public FormsPage clickOnFormsLink() {
		formsLink.click();
		return new FormsPage();
	}

}
