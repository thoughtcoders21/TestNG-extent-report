package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import pageHelper.CheckBoxPageHelper;
import pageHelper.ElementsPageHelper;
import pageHelper.HomePageHelper;
import pageHelper.TextBoxPageHelper;

public class CheckBox_Test extends BasePage{
	
	HomePageHelper homePage;
	ElementsPageHelper elementsPage;
	CheckBoxPageHelper checkboxPage;
	
	@Test(description = "verify User Can able Select Checkbox")
	public void test1() throws Exception {
		homePage=new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		checkboxPage = new CheckBoxPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOncheckBoxOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Check box Option under Elements section");
		
		Assert.assertTrue(checkboxPage.verifyUserCanSelectCheckbox());
		ExtentListeners.test.log(Status.INFO, "verify User Can able Select Checkbox");
		ExtentListeners.capturescreenshot("verify User Can able Select Checkbox");
	}
	
	@Test(description = "verify Checkbox Result when check box selected")
	public void test2() throws Exception {
		homePage=new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		checkboxPage = new CheckBoxPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOncheckBoxOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Check box Option under Elements section");
		
		checkboxPage.selectCheckBox();
		ExtentListeners.test.log(Status.INFO, "Select Check box");
		
		Assert.assertTrue(checkboxPage.verifyCheckboxResult());
		ExtentListeners.test.log(Status.INFO, "verify Checkbox Result when check box selected");
		ExtentListeners.capturescreenshot("verify Checkbox Result when check box selected");
	}

}
