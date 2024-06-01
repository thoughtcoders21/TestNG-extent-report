package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import pageHelper.CheckBoxPageHelper;
import pageHelper.ElementsPageHelper;
import pageHelper.HomePageHelper;
import pageHelper.TextBoxPageHelper;
import pageHelper.UploadDownloadPageHelper;

public class UploadDownloadPage_Test extends BasePage{
	
	HomePageHelper homePage;
	ElementsPageHelper elementsPage;
	UploadDownloadPageHelper uploadDownloadPage;
	
	@Test(description = "verify user can download file")
	public void test1() throws Exception {
		homePage=new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		uploadDownloadPage = new UploadDownloadPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOnuploadandDownloadOption();
		ExtentListeners.test.log(Status.INFO, "clicked On upload and download option under elements Tab");
		
		Assert.assertTrue(uploadDownloadPage.verifyUsercanDownloadFile());
		ExtentListeners.test.log(Status.INFO, "verify download btn is clickable, user can download file");
		ExtentListeners.capturescreenshot("verify download btn is clickable, user can download file");
		
		uploadDownloadPage.clickOnDownloadBtn();
		ExtentListeners.test.log(Status.INFO, "clicked On download btn");
		
		Assert.assertTrue(uploadDownloadPage.verifyFileDownloaded());
		ExtentListeners.test.log(Status.INFO, "Verify file downloaded when clicked on download Btn");
		ExtentListeners.capturescreenshot("Verify file downloaded when clicked on download Btn");
	}
	
	@Test(description = "Verify file uploaded successfully, and  uploaded File Path visible")
	public void test2() throws Exception {
		homePage=new HomePageHelper();
		elementsPage = new ElementsPageHelper();
		uploadDownloadPage = new UploadDownloadPageHelper();
		
		homePage.clickOnElementsTab();
		ExtentListeners.test.log(Status.INFO, "clicked On Elements Tab");
		
		elementsPage.clickOnuploadandDownloadOption();
		ExtentListeners.test.log(Status.INFO, "clicked On upload and download option under elements Tab");
		
		uploadDownloadPage.uploadFile();
		ExtentListeners.test.log(Status.INFO, "File uploaded");
		
		Assert.assertTrue(uploadDownloadPage.verifyFileUploadedSuccessfully());	
		ExtentListeners.test.log(Status.INFO, "Verify file uploaded successfully, and  uploaded File Path visible");
		ExtentListeners.capturescreenshot("Verify file uploaded successfully, and  uploaded File Path visible");
	}
	
}
