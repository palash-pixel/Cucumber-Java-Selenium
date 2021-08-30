package Step_Definations;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObject.PNT_login_page;
import PageObject.nopcommerceL_page;
import io.cucumber.java.en.*;

public class PNT_Login_pom_steps {

	public WebDriver driver;

	public PNT_login_page plp;
	public nopcommerceL_page lp;
	@Given("User launching Chrome browser")
	public void user_launching_chrome_browser() {
		String path = System.getProperty("user.dir") + ("/Driver/chromedriver.exe");

		System.setProperty("webdriver.chrome.driver", path );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		plp = new PNT_login_page(driver);
		lp = new nopcommerceL_page(driver);

	}

	@When("User navigate to url {string}")
	public void user_navigate_to_url(String url) {
		driver.navigate().to(url);
	}

	@When("user enters username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String username, String password) {
		plp.enterUsername(username);
		plp.enterPassword(password);

	}

	@When("user Click on login")
	public void user_click_on_login() throws InterruptedException {
		System.out.println(driver.getTitle());
		plp.ClickLogin_button();
		Thread.sleep(2000);
	}

	@Then("Validate Page title shold be {string}")
	public void validate_page_title_shold_be(String string) {
		String title = driver.getTitle();
		Assert.assertEquals(title, "Forum of PeopleNTech - Index");
		System.out.println("After login>>>>" + title);
	}

	@When("click on logout button")
	public void click_on_logout_button() throws InterruptedException {
		plp.ClickLogout_button();
		Thread.sleep(3000);
		String url = "https://admin-demo.nopcommerce.com/login";
		driver.get(url);
		lp.enterUsername("admin@yourstore.com");
		lp.enterPassword("admin");
		Thread.sleep(2000);
		String noptitle = driver.getTitle();
		System.out.println(noptitle);
		lp.click_on_loginButton();
		String noptitle2 = driver.getTitle();
		System.out.println(noptitle2);
		lp.click_on_logOutButton();
	}

	
	@Then("Close the browser")
	public void close_the_browser() throws InterruptedException {
		String title1 = driver.getTitle();
		System.out.println("After logout>>>>>" + title1);
		Thread.sleep(2000);
		driver.quit();
	}

}
