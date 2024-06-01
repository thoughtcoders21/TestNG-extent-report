package pageHelper;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionhelper.ActionHelper;
import baselibrary.BasePage;

public class SelectMenuPageHelper extends  BasePage{
	
	public static String selectOption="Purple";
	
	public SelectMenuPageHelper() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id = "oldSelectMenu")
	private WebElement singleDrpdwn;
	
	@FindBy(xpath = "//*[text()='Multiselect drop down']/parent::p/parent::div//div[@class=' css-tlfecz-indicatorContainer']")
	private WebElement multiselectDrpdwnDownArrow;
	
	@FindBy(id="react-select-4-option-0")
	private WebElement multiselectDrpdwnOption1;
	
	@FindBy(id="react-select-4-option-1")
	private WebElement multiselectDrpdwnOption2;
	
	public void selectSingleselctOption() {
		ActionHelper.scrollIntoView(singleDrpdwn);
		ActionHelper.selectByVisibleText(singleDrpdwn,selectOption);
	}
	
	public boolean verifySelectedOption() {
		boolean same = false;
		try {
			String selectedOption = ActionHelper.getSelectedOption(singleDrpdwn); 
			if(selectedOption.equals(selectOption)) {
				same=true;
			}
		} catch (Exception e) {
			return same;
		}
		return same;
	}
	
	public void expandMultiselectDrpdwn() {
		ActionHelper.scrollIntoView(multiselectDrpdwnDownArrow);
		ActionHelper.click(multiselectDrpdwnDownArrow);
	}
	
	public void selectMultiselectValue() {
		ActionHelper.click(multiselectDrpdwnOption1);
		ActionHelper.click(multiselectDrpdwnOption2);		
	}
	
	public boolean verifyUserCanSelectMultipleValues() {
		boolean flag=false;
		try {
			Thread.sleep(3000);
			List<WebElement> MultiselectValues=driver.findElements(By.xpath("//div[@class='css-1rhbuit-multiValue']"));
			if(MultiselectValues.size()>1) {
				flag=true;
			}
		} catch (Exception e) {
			return flag;
		}
		return flag;
	}
		
}
