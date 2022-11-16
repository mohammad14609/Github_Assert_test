import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testSomeTask {

	public WebDriver driver;

	@BeforeTest

	public void login_page() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://github.com/login");
		driver.manage().window().maximize();


		driver.findElement(By.xpath("//*[@id=\"login_field\"]")).sendKeys("mohammadfortest");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Testing99@@");
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[11]")).click();
	}

	@Test()

	public void test_tile() {

		String actulName = driver.getTitle();

		String expTilte = "GitHub";

		Assert.assertEquals(actulName, expTilte);

	}

	@Test()

	public void test_user_name() throws InterruptedException {
		driver.findElement(By.xpath("//summary[@aria-label='View profile and more']")).click();
		Thread.sleep(1000);
		String actulUserName = driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/div[1]/a/strong")).getText();

		String expUserName = "mohammad";

		Assert.assertEquals(actulUserName, expUserName);
		

	}

}
