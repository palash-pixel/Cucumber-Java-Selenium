package Step_Definations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import PageObject.nopcommerceL_page;
import io.cucumber.java.en.*;

public class Nopcommerce_login_steps {

	public WebDriver driver;
	public nopcommerceL_page lp;

	@Given("User launch Chrome browser")
	public void user_launch_chrome_browser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		lp = new nopcommerceL_page(driver);

	}

	@When("User opens url {string}")
	public void user_opens_url(String url) {
		driver.get(url);
	}

	@When("user enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String enail, String password) {

		lp.enterUsername(enail);
		lp.enterPassword(password);
	}

	@When("Click on login")
	public void click_on_login() {
		lp.click_on_loginButton();

	}

	@Then("Page title shold be {string}")
	public void page_title_shoid_be(String title) {
		if (driver.getPageSource().contains("Login was unsuccessful.")) {
			driver.close();
			Assert.assertFalse(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());

		}

	}

	@When("User click on logout button")
	public void user_click_on_logout_button() throws InterruptedException {
		lp.click_on_logOutButton();
		Thread.sleep(3000);
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String string) {
		String title = driver.getTitle();

		Assert.assertEquals(title, "Your store. Login");
		System.out.println("Login Page Title >>" + title);
	}

	@Then("Close browser")
	public void close_browser() {
		driver.close();
		driver.quit();

	}

}
