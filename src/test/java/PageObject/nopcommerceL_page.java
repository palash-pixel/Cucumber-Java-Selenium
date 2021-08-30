package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class nopcommerceL_page {

	WebDriver  ldriver;
	public nopcommerceL_page(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements( rdriver,this);
		
	}
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement  txt_email;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement  txt_password;

	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	@CacheLookup
	WebElement  btn_Login;	
	
	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement  btn_Logout;	

	
	public void enterUsername(String username) {

		txt_email.clear();
		txt_email.sendKeys(username);
	}

	public void enterPassword(String password) {
		txt_password.clear();
		txt_password.sendKeys(password);
	}

	public void click_on_loginButton() {
		btn_Login.click();
	}

	public void click_on_logOutButton() {
		btn_Logout.click();
	}

//public void login_valid_user(String username, String password) {
//		
//		driver.findElement(txt_username).sendKeys(username);
//		driver.findElement(txt_password).sendKeys(password);
//		driver.findElement(btn_login).click();
//		driver.findElement(btn_logout).click();

//}

}
	  
	

