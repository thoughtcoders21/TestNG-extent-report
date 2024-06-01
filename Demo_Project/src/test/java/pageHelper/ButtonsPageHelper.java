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

public class ButtonsPageHelper extends BasePage {

	public static String username = "";
	public static String useremail = "";
	public static String permanentaddress = "";
	public static String currentaddress = "";

	public ButtonsPageHelper() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "doubleClickBtn")
	private WebElement doubleClickBtn;

	@FindBy(id = "rightClickBtn")
	private WebElement rightClickBtn;

	@FindBy(xpath = "//button[text()='Click Me']")
	private WebElement dynamicClickBtn;

	@FindBy(id = "doubleClickMessage")
	private WebElement doubleClickMessage;

	@FindBy(id = "rightClickMessage")
	private WebElement rightClickMessage;

	@FindBy(id = "dynamicClickMessage")
	private WebElement dynamicClickMessage;

	public void performDoubleClickBtn() {
//		WaitUtility.impliciwait(10);
//		ActionHelper.mousehover(doubleClickBtn);
		try {
			Thread.sleep(3000);
			ActionHelper.doubleclick(doubleClickBtn);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public boolean verifydoubleClickMessage() {
		boolean visible = false;
		try {
			if (doubleClickMessage.getText().equals("You have done a double click")) {
				visible = true;
			}
		} catch (Exception e) {
			return visible;
		}
		return visible;
	}

	public void performRightClickBtn() {
		WaitUtility.impliciwait(10);
		ActionHelper.scrollIntoView(doubleClickBtn);
		ActionHelper.rightclick(rightClickBtn);
	}

	public boolean verifyRightClickMessage() {
		boolean visible = false;
		try {
			if (rightClickMessage.getText().equals("You have done a right click")) {
				visible = true;
			}
		} catch (Exception e) {
			return visible;
		}
		return visible;
	}

	public void performDynamicClickBtn() {
		WaitUtility.impliciwait(10);
		ActionHelper.scrollIntoView(doubleClickBtn);
		ActionHelper.click(dynamicClickBtn);
	}

	public boolean verifyDynamicClickMessage() {
		boolean visible = false;
		try {
			if (dynamicClickMessage.getText().equals("You have done a dynamic click")) {
				visible = true;
			}
		} catch (Exception e) {
			return visible;
		}
		return visible;
	}
}
