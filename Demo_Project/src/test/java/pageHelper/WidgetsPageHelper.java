package pageHelper;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionhelper.ActionHelper;
import baselibrary.BasePage;

public class WidgetsPageHelper extends  BasePage{
	
	public WidgetsPageHelper() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//span[text()='Select Menu']/parent::li")
	private WebElement selectMenuOption;
	
	public void clickOnselectMenuOption() {
		ActionHelper.jsClick(selectMenuOption);
	}
		
}
