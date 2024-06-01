package pageHelper;

import java.io.File;
import java.io.IOException;
import java.time.Instant;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionhelper.ActionHelper;
import baselibrary.BasePage;

public class UploadDownloadPageHelper extends BasePage {

	public static String downloadedFilename = "";
	public static String downloadedfileExtension = "";

	public UploadDownloadPageHelper() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "downloadButton")
	private WebElement downloadButton;

	@FindBy(id = "uploadedFilePath")
	private WebElement uploadedFilePath;

	public boolean verifyUsercanDownloadFile() {
		boolean downloadable = false;
		try {
			if (downloadButton.isEnabled()) {
				downloadable = true;
			}
		} catch (Exception e) {
			return downloadable;
		}
		return downloadable;
	}

	public void clickOnDownloadBtn() {
		ActionHelper.jsClick(downloadButton);
		downloadedFilename = downloadButton.getAttribute("download").substring(0, 10);
		downloadedfileExtension = downloadButton.getAttribute("download").substring(11);
	}

	public boolean verifyFileDownloaded() throws IOException {
		String folderName = System.getProperty("user.home") + File.separator + "Downloads";

		String fileName;

		boolean fileDownloaded = false;

		File[] listOfFiles = new File(folderName).listFiles();

		for (File file : listOfFiles) {
			fileName = file.getName().toLowerCase();

			if (fileName.contains(downloadedFilename.toLowerCase())
					&& fileName.contains(downloadedfileExtension.toLowerCase())) {
				fileDownloaded = true;
				break;
			}
		}

		return fileDownloaded;
	}

	public void uploadFile() {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator
				+ "resources" + File.separator + "Batman.jpg";
		ActionHelper.fileupload(path);
	}

	public boolean verifyFileUploadedSuccessfully() {
		boolean uploaded = false;
		try {
			if (uploadedFilePath.isDisplayed() && uploadedFilePath.getText().contains("Batman.jpg")) {
				uploaded = true;
			}
		} catch (Exception e) {
			return uploaded;
		}
		return uploaded;
	}

}
