package pageHelper;


import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionhelper.ActionHelper;
import baselibrary.BasePage;

public class ElementsPageHelper extends  BasePage{
	
	public static String username="";
	public static String useremail="";
	public static String permanentaddress="";
	public static String currentaddress="";
	
	
	public ElementsPageHelper() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath ="//span[text()='Text Box']/parent::li")
	private WebElement textBoxOption;
	
	@FindBy(xpath ="//span[text()='Check Box']/parent::li")
	private WebElement checkBoxOption;
	
	@FindBy(xpath ="//span[text()='Buttons']/parent::li")
	private WebElement buttonsOption;	
	
	@FindBy(xpath ="//span[text()='Upload and Download']/parent::li")
	private WebElement uploadandDownloadOption;	
	
	public void clickOntextBoxOption() {
		ActionHelper.jsClick(textBoxOption);
	}
	
	public void clickOncheckBoxOption() {
		ActionHelper.jsClick(checkBoxOption);
	}
	
	public void clickOnbuttonsOption() {
		ActionHelper.jsClick(buttonsOption);
	}
	
	public void clickOnuploadandDownloadOption() {
		ActionHelper.jsClick(uploadandDownloadOption);
	}
	
	
	
}
