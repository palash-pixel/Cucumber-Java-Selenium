package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PNT_login_page {

	WebDriver ldriver;

	public PNT_login_page(WebDriver rdriver) {

		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath = "//input[@ name='user' and @size='20']")
	@CacheLookup
	WebElement txt_username;

	@FindBy(xpath = "//input[@ name='passwrd' and @size='20']")
	@CacheLookup
	WebElement txt_password;

	@FindBy(xpath = " //*[@id='frmLogin']/div/div[3]/p/input")
	@CacheLookup
	WebElement btn_Login;

	@FindBy(xpath = "//span[contains(text(),'Logout')]")
	@CacheLookup
	WebElement btn_Logout;

	public void enterUsername(String username) {
		txt_username.clear();
		txt_username.sendKeys(username);

	}

	public void enterPassword(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);

	}

	public void ClickLogin_button() {

		btn_Login.click();
	}

	public void ClickLogout_button() {

		btn_Logout.click();
	}

}
