package pageHelper;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionhelper.ActionHelper;
import baselibrary.BasePage;

public class HomePageHelper extends  BasePage{
	
	public HomePageHelper() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath ="//*[text()='Elements']/parent::div")
	private WebElement elementsTab;
	
	@FindBy(xpath ="//*[text()='Widgets']/parent::div")
	private WebElement widgetsTab;
	
	


	public void clickOnElementsTab() {
		ActionHelper.jsClick(elementsTab);	
	}
	
	public void clickOnWidgetsTab() {
		ActionHelper.jsClick(widgetsTab);	
	}
}
