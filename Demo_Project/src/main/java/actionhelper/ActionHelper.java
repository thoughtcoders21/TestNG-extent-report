package actionhelper;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.apache.commons.io.comparator.LastModifiedFileComparator;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import baselibrary.BasePage;
import extentlisteners.ExtentListeners;
import utilities.WaitUtility;

public class ActionHelper extends BasePage {

	public static void click(WebElement ele) {
		WaitUtility.waitForVisibility(ele);
		ele.click();
	}
	
	public static void jsClick(WebElement ele) {
		WaitUtility.waitForVisibility(ele);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public static void sendkeys(WebElement ele, String text) {
		WaitUtility.waitForVisibility(ele);
		ele.sendKeys(text);
	}

	public static void clear(WebElement ele) {
		WaitUtility.waitForVisibility(ele);
		ele.clear();
	}

	public static void doubleclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	public static void rightclick(WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	public static void getwindownchange(int tabno) {
		Set<String> set = driver.getWindowHandles();
		ArrayList<String> tabs = new ArrayList<String>(set);
		driver.switchTo().window(tabs.get(tabno));
	}

	public static void selectByVisibleText(WebElement ele, String value) {
		Select select = new Select(ele);
		select.selectByVisibleText(value);
	}
	
	public static String getSelectedOption(WebElement ele) {
		Select select = new Select(ele);
		return select.getFirstSelectedOption().getText();
	}

	public static void selectByValue(WebElement ele, String value) {

		Select select = new Select(ele);
		select.selectByValue(value);
	}

	public static void mousehover(WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();

	}

	public static void mousehover_click(WebElement ele, String target) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).build().perform();
		driver.findElement(By.linkText(target)).click();

	}

	public static void fileupload(String fileloc) {
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(fileloc);
	}
	
	public static void windowHandel(int tab) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(tab));
	}
	
	public static void scrollIntoView(WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
	}
	
	public static String getLatestDownLoadedFilePathAndName(String downloadedFileName) {
		String path = "";
		String recentDownloadedFileName = "";
		String filePath = System.getProperty("user.home") + File.separator + "Downloads" + File.separator + downloadedFileName
				+ "*";
		File file = new File(filePath);
		String parentdir = file.getParent();
		String fileName = file.getName();
		FileFilter fileFilter = new WildcardFileFilter(fileName);
		File dir = new File(parentdir);
		File[] files = dir.listFiles(fileFilter);
		if (files.length > 0) {
			Arrays.sort(files, LastModifiedFileComparator.LASTMODIFIED_REVERSE);
			path = files[0].getAbsolutePath();
			recentDownloadedFileName = files[0].getName();
		}
		String fileNameFilePath=path+recentDownloadedFileName;
		return fileNameFilePath;
	}
	
	public static boolean isFileDownloaded(String expectedFileName, String fileExtension, int timeOut) throws IOException 
	{
	    // Download Folder Path
	    String folderName = System.getProperty("user.dir") + File.separator + "downloads";
			
	    // Array to Store List of Files in Directory
	    File[] listOfFiles;
			
	    // Store File Name
	    String fileName;   
	        
	    //  Consider file is not downloaded
	    boolean fileDownloaded = false;      
	        
	    // capture time before looking for files in directory
	    // last modified time of previous files will always less than start time
	    // this is basically to ignore previous downloaded files
	    long startTime = Instant.now().toEpochMilli();
	        
	    // Time to wait for download to finish
	    long waitTime = startTime + timeOut;
	       
	    // while current time is less than wait time
	    while (Instant.now().toEpochMilli() < waitTime) 
	    {			
	        // get all the files of the folder
	        listOfFiles = new File(folderName).listFiles();
	            
	        // iterate through each file
	        for (File file : listOfFiles) 
	        {
	            // get the name of the current file
	            fileName = file.getName().toLowerCase();
	        		
	            // condition 1 - Last Modified Time > Start Time
	            // condition 2 - till the time file is completely downloaded extension will be crdownload
	            // Condition 3 - Current File name contains expected Text
	            // Condition 4 - Current File name contains expected extension
	            if (file.lastModified() > startTime && !fileName.contains("crdownload") &&   fileName.contains(expectedFileName.toLowerCase()) && fileName.contains(fileExtension.toLowerCase())) 
	           {
	               // File Found
	               fileDownloaded = true;
	               break;
	           }
	        }
	        // File Found Break While Loop
	         if (fileDownloaded) 
	             break;
	    }
	    // File Not Found
	    return fileDownloaded;
	}
}
