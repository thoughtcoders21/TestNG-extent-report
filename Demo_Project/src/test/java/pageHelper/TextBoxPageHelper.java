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
import utilities.WaitUtility;

public class TextBoxPageHelper extends  BasePage{
	
	public static String username="";
	public static String useremail="";
	public static String permanentaddress="";
	public static String currentaddress="";
	
	
	public TextBoxPageHelper() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id ="userName")
	private WebElement userNameField;

	@FindBy(id ="userEmail")
	private WebElement userEmailField;
	
	@FindBy(id ="currentAddress")
	private WebElement currentAddressField;
	
	@FindBy(id ="permanentAddress")
	private WebElement permanentAddressField;
	
	@FindBy(id ="submit")
	private WebElement submitBtn;
	
	@FindBy(id ="output")
	private WebElement output;
	
	@FindBy(id ="name")
	private WebElement outputName;

	@FindBy(id ="email")
	private WebElement outputEmail;
	
	@FindBy(xpath="//p[@id='currentAddress']")
	private WebElement outputCurrentAddress;
	
	@FindBy(xpath="//p[@id='permanentAddress']")
	private WebElement outputPermanentAddress;

	public void fillUserName(String userNmae) {
		username = userNmae;
		userNameField.sendKeys(userNmae);
	}
	
	public void fillUserEmail(String userEmail) {
		useremail = userEmail;
		userEmailField.sendKeys(userEmail);
	}
	
	public void fillCurrentAddress(String currentAddress) {
		currentaddress = currentAddress;
		currentAddressField.sendKeys(currentAddress);
	}
	
	public void fillpermanentAddress(String permanentAddress) {
		permanentaddress = permanentAddress;
		permanentAddressField.sendKeys(permanentAddress);
	}
	
	public void clickOnSubmitBtn() {
		ActionHelper.jsClick(submitBtn);
	}
	
	public boolean verifyHighlightedEmailField() {
		boolean highlighted=false;
		try {
			Thread.sleep(5000);
			String color = Color.fromString(userEmailField.getCssValue("border").substring(10)).asHex();
			
			if (color.equals("#ff0000")) {
				highlighted=true;
			}
		} catch (Exception e) {
			return highlighted;
		}
		return highlighted;
	}
	
	public boolean verifyUserCanSubmitForm() {
		boolean submitted=false;
		try {
			ActionHelper.scrollIntoView(output);
			if (output.isDisplayed()) {
				submitted=true;
			}
		} catch (Exception e) {
			return submitted;
		}
		return submitted;
	}
	
	public boolean verifyFilledDataAfterSubmission() {
		boolean same=false;
		try {
			ActionHelper.scrollIntoView(output);
			if (outputName.getText().contains(username) && outputEmail.getText().contains(useremail) && outputCurrentAddress.getText().contains(currentaddress) && outputPermanentAddress.getText().contains(permanentaddress)) {
				same=true;
			}
		} catch (Exception e) {
			return same;
		}
		return same;
	}
	
}
