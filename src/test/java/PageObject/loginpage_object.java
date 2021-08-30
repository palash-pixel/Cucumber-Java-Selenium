package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class loginpage_object {
	WebDriver driver;
	By txt_username = By.xpath("//*[@name ='user' and @size= '20']");

	By txt_password = By.xpath("//*[@name ='passwrd' and @size= '20']");

	By btn_login = By.xpath("//*[@id=\'frmLogin\']/div/div[3]/p/input");
	By btn_logout = By.xpath("//*[@id='button_logout']/a/span");

	public loginpage_object(WebDriver driver) {

		this.driver = driver;

	}

	public void enterUsername(String username) {

		driver.findElement(txt_username).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}

	public void click_on_loginButton() {
		driver.findElement(btn_login).click();
	}

	public void click_on_logOutButton() {
		driver.findElement(btn_logout).click();
	}

//public void login_valid_user(String username, String password) {
//		
//		driver.findElement(txt_username).sendKeys(username);
//		driver.findElement(txt_password).sendKeys(password);
//		driver.findElement(btn_login).click();
//		driver.findElement(btn_logout).click();

//}

}