package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actionhelper.ActionHelper;
import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import pageHelper.ElementsPageHelper;
import pageHelper.HomePageHelper;
import pageHelper.TextBoxPageHelper;

public class TextBoxPage_Test extends BasePage{
	
	HomePageHelper homePage;
	ElementsPageHelper elementsPage;
	TextBoxPageHelper textBoxPage;
	
	@Test(description = "verify user email field get highlighted when form submitted with invalid email id.")
	public void test1() throws Exception {
		homePage=new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		textBoxPage = new TextBoxPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOntextBoxOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Textbox option under elements tab");
		
		textBoxPage.fillUserName("abc xyz");
		ExtentListeners.test.log(Status.INFO, "user name filled in username field");
		
		textBoxPage.fillUserEmail("abc.xyz@gj@ghg.com");
		ExtentListeners.test.log(Status.INFO, "invalid user email filled in useremail field");
		
		textBoxPage.fillCurrentAddress("qazxcv,1234");
		ExtentListeners.test.log(Status.INFO, "current address filled in current address field");
		
		textBoxPage.fillpermanentAddress("asdfg,98745");
		ExtentListeners.test.log(Status.INFO, "permanent address filled in permanent address field");
		
		textBoxPage.clickOnSubmitBtn();
		ExtentListeners.test.log(Status.INFO, "Clicked on submit button");
		
		Assert.assertTrue(textBoxPage.verifyHighlightedEmailField());
		ExtentListeners.test.log(Status.INFO, "verify user email field get highlighted when form submitted with invalid email id.");
		ExtentListeners.capturescreenshot("verify user email field get highlighted when form submitted with invalid email id.");
	}
	
	
	@Test()
	public void test2() throws Exception {
		homePage=new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		textBoxPage = new TextBoxPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOntextBoxOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Textbox option under elements tab");
		
		textBoxPage.fillUserName("abc xyz");
		ExtentListeners.test.log(Status.INFO, "user name filled in username field");
		
		textBoxPage.fillUserEmail("abc.xyz@gj.com");
		ExtentListeners.test.log(Status.INFO, "user email filled in useremail field");
		
		textBoxPage.fillCurrentAddress("qazxcv,1234");
		ExtentListeners.test.log(Status.INFO, "current address filled in current address field");
		
		textBoxPage.fillpermanentAddress("asdfg,98745");
		ExtentListeners.test.log(Status.INFO, "permanent address filled in permanent address field");
		
		textBoxPage.clickOnSubmitBtn();
		ExtentListeners.test.log(Status.INFO, "Clicked on submit button");
		
		Assert.assertTrue(textBoxPage.verifyUserCanSubmitForm());
		ExtentListeners.test.log(Status.INFO, "verify clicking submit btn user can able to submit form");
		ExtentListeners.capturescreenshot("verify clicking submit btn user can able to submit form");
	}

	@Test(description = "verify Filled Data appears After form Submission")
	public void test3() throws Exception {
		homePage=new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		textBoxPage = new TextBoxPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOntextBoxOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Textbox option under elements tab");
		
		textBoxPage.fillUserName("abc xyz");
		ExtentListeners.test.log(Status.INFO, "user name filled in username field");
		
		textBoxPage.fillUserEmail("abc.xyz@gjg.com");
		ExtentListeners.test.log(Status.INFO, "user email filled in useremail field");
		
		textBoxPage.fillCurrentAddress("qazxcv,1234");
		ExtentListeners.test.log(Status.INFO, "current address filled in current address field");
		
		textBoxPage.fillpermanentAddress("asdfg,98745");
		ExtentListeners.test.log(Status.INFO, "permanent address filled in permanent address field");
		
		textBoxPage.clickOnSubmitBtn();
		ExtentListeners.test.log(Status.INFO, "Clicked on submit button");
		
		Assert.assertTrue(textBoxPage.verifyFilledDataAfterSubmission());
		ExtentListeners.test.log(Status.INFO, "verify Filled Data appears After form Submission");
		ExtentListeners.capturescreenshot("verify Filled Data appears After form Submission");
	}
	
}
