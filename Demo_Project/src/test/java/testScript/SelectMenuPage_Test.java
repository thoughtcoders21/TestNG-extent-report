package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import pageHelper.ButtonsPageHelper;
import pageHelper.ElementsPageHelper;
import pageHelper.HomePageHelper;
import pageHelper.SelectMenuPageHelper;
import pageHelper.TextBoxPageHelper;
import pageHelper.WidgetsPageHelper;

public class SelectMenuPage_Test extends BasePage {

	HomePageHelper homePage;
	WidgetsPageHelper widgetsPage;
	SelectMenuPageHelper selectmenuPage;

	@Test(description = "Verify seleced option is visible on dropdown")
	public void test1() throws Exception {
		homePage = new HomePageHelper();
		widgetsPage = new WidgetsPageHelper();
		selectmenuPage = new SelectMenuPageHelper();
		
		homePage.clickOnWidgetsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Widgets Tab");
		
		widgetsPage.clickOnselectMenuOption();
		ExtentListeners.test.log(Status.INFO, "click On select Menu Option under widgets section");
		
		selectmenuPage.selectSingleselctOption();
		ExtentListeners.test.log(Status.INFO, "select option for Single select dropdown");
		
		Assert.assertTrue(selectmenuPage.verifySelectedOption());
		ExtentListeners.test.log(Status.INFO, "Verify seleced option is visible on dropdown");
		ExtentListeners.capturescreenshot("Verify seleced option is visible on dropdown");
	}
	
	@Test(description = "verify User Can Select Multiple Values for Multiselect dropdown")
	public void test2() throws Exception {
		homePage = new HomePageHelper();
		widgetsPage = new WidgetsPageHelper();
		selectmenuPage = new SelectMenuPageHelper();
		
		homePage.clickOnWidgetsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Widgets Tab");
		
		widgetsPage.clickOnselectMenuOption();
		ExtentListeners.test.log(Status.INFO, "click On select Menu Option under widgets section");
		
		selectmenuPage.expandMultiselectDrpdwn();
		ExtentListeners.test.log(Status.INFO, "Expand multiselect dropdown");
		
		selectmenuPage.selectMultiselectValue();
		ExtentListeners.test.log(Status.INFO, "Select multiple options for multiseect dropdown");
		
		Assert.assertTrue(selectmenuPage.verifyUserCanSelectMultipleValues());
		ExtentListeners.test.log(Status.INFO, "verify User Can Select Multiple Values for Multiselect dropdown");
		ExtentListeners.capturescreenshot("verify User Can Select Multiple Values for Multiselect dropdown");
	}
	
}
