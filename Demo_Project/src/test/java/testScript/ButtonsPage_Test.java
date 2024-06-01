package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import pageHelper.ButtonsPageHelper;
import pageHelper.ElementsPageHelper;
import pageHelper.HomePageHelper;

public class ButtonsPage_Test extends BasePage {

	HomePageHelper homePage;
	ElementsPageHelper elementsPage;
	ButtonsPageHelper buttonsPage;

	@Test(description = "verify messsage 'You have done a double click' when clicked on double click button")
	public void test1() throws Exception {
		homePage = new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		buttonsPage = new ButtonsPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOnbuttonsOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Buttons Option under Elements section");
		
		buttonsPage.performDoubleClickBtn();
		ExtentListeners.test.log(Status.INFO, "Performed Double click on DoubleClick Button");
		
		Assert.assertTrue(buttonsPage.verifydoubleClickMessage());
		ExtentListeners.test.log(Status.INFO, "verify messsage 'You have done a double click' when clicked on double click button");
		ExtentListeners.capturescreenshot("verify messsage 'You have done a double click' when clicked on double click button");
	}
	
	@Test(description = "verify messsage 'You have done a right click' when clicked on right click button")
	public void test2() throws Exception {
		homePage = new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		buttonsPage = new ButtonsPageHelper();

		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOnbuttonsOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Buttons Option under Elements section");
		
		buttonsPage.performRightClickBtn();
		ExtentListeners.test.log(Status.INFO, "Performed Right click on RightClick Button");
		
		Assert.assertTrue(buttonsPage.verifyRightClickMessage());
		ExtentListeners.test.log(Status.INFO, "verify messsage 'You have done a right click' when clicked on right click button");
		ExtentListeners.capturescreenshot("verify messsage 'You have done a right click' when clicked on right click button");
	}
	
	@Test(description = "verify messsage 'You have done a dynamic click' when clicked on dynamic click button")
	public void test3() throws Exception {
		homePage = new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		buttonsPage = new ButtonsPageHelper();

		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOnbuttonsOption();
		ExtentListeners.test.log(Status.INFO, "clicked On Buttons Option under Elements section");
		
		buttonsPage.performDynamicClickBtn();
		ExtentListeners.test.log(Status.INFO, "Performed dynamic click on DynamicClick Button");
		
		Assert.assertTrue(buttonsPage.verifyDynamicClickMessage());
		ExtentListeners.test.log(Status.INFO, "verify messsage 'You have done a dynamic click' when clicked on dynamic click button");
		ExtentListeners.capturescreenshot("verify messsage 'You have done a dynamic click' when clicked on dynamic click button");
	}
}
