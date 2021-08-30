package Step_Definations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.loginpage_object;
import io.cucumber.java.en.*;


public class login_pom_steps {

	WebDriver driver = null;
	loginpage_object login ;
	
	@Given("User navigate to {string}")
	public void user_navigate_to(String url) {
	  
	   System.out.println("inside step - Browser is open");
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.navigate().to(url);
				
	}

	@When("Guest enters username and password")
	public void guest_enters_username_and_password() {
		
		login = new loginpage_object(driver);
		login.enterUsername("testuser2");
		login.enterPassword("abcd1234");
	}

	@When("Guest Click on log in button")
	public void guest_click_on_log_in_button() {
	    
		login.click_on_loginButton();	
	}

	@Then("Guest is navigate to the home page")
	public void guest_is_navigate_to_the_home_page() {
		login.click_on_logOutButton();
		driver.close();
		driver.quit();
	}
	
}
