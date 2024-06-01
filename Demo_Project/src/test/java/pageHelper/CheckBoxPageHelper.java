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

public class CheckBoxPageHelper extends  BasePage{
	
	public static String username="";
	public static String useremail="";
	public static String permanentaddress="";
	public static String currentaddress="";
	
	
	public CheckBoxPageHelper() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "rct-checkbox")
	private WebElement checkBox;
	
	@FindBy(id = "result")
	private WebElement checkBoxResult;

	public void selectCheckBox(){
		ActionHelper.jsClick(checkBox);
	}
	
	public boolean verifyUserCanSelectCheckbox() {
		boolean selectable=false;
		try {
			if (checkBox.isEnabled()) {
				selectable=true;
			}
		} catch (Exception e) {
			return selectable;	
		}
		return selectable;
	}
	
	public boolean verifyCheckboxResult() {
		return checkBoxResult.isDisplayed();
	}
	
}
