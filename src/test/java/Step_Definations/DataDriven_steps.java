package Step_Definations;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.core.cli.Main;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class DataDriven_steps {

	WebDriver driver;
	
			
	@Before
	public void setup() {
		String browser = "chrome";					////?? set desire browser chrome, firefox, edge
		String chromepath = ".\\Driver\\chromedriver.exe";
		String firefoxpath = ".\\Driver\\geckodriver.exe";
		String iepath = ".\\Driver\\IEDriverServer.exe";
		String edgepath= ".\\Driver\\msedgedriver.exe";
		
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + chromepath);
			driver = new ChromeDriver();
		}
		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + firefoxpath);
			driver = new FirefoxDriver();
		}
		else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + iepath);
			driver = new InternetExplorerDriver();

		}
		else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + edgepath);
			driver = new EdgeDriver();

		}
	}
		
	@Given("User navigate to  log in page")
	public void user_navigate_to_log_in_page() {
		System.out.println("inside step - Browser is open");
//		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+chromepath);
//		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.navigate().to("https://admin-demo.nopcommerce.com/login");
	}


	@When("^Palash enter(.*) and (.*)$")
	public void palash_enter_username_and_password(String email, String password ) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys( email); 
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Password']")).clear();
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);  
		Thread.sleep(4000);
	}


	@When("log in button clicked")
	public void log_in_button_clicked(){
		driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

		String home_page = driver.getTitle();
		System.out.println("Home page title  >> "+ home_page);

	}

	@Then("Now user login to forum")
	public void now_user_login_to_forum() throws InterruptedException {
		String login_page = driver.getTitle();
		if  (driver.getPageSource().contains("Login was unsuccessful")) {
			Thread.sleep(4000);
			driver.close();
			driver.quit();

		} else {
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		}

		System.out.println("Logout Button displayed>>");


		System.out.println("login page title  >> "+ login_page);

		Thread.sleep(4000);
		driver.close();
		driver.quit();

	}


}

