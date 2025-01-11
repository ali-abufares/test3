package outomation_test;

import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class demo_test {
	WebDriver driver = new ChromeDriver();
	String websaite = "https://codenboxautomationlab.com/practice/";
	Random rand = new Random();

	@BeforeTest
	public void go_websiet() {
		driver.get(websaite);
		driver.manage().window().maximize();

	}

	@Test(priority = 1, description = "thi is raido button", invocationCount = 4, enabled = false)
	public void raiduo_test() throws InterruptedException {
		List<WebElement> radio_set = driver.findElements(By.className("radioButton"));
		// radio_set.get(2).click();
		/*
		 * for(int i=0;i<radio_set.size();i+=1) { radio_set.get(i).click(); //}
		 */
		int random_number = rand.nextInt(radio_set.size());
		radio_set.get(random_number).click();
		Thread.sleep(1000);
	}

	@Test(priority = 1, description = "homaar", invocationCount = 1, enabled = false)
	public void Dynamic_Dropdown_Example() throws InterruptedException {
		String[] countryCodes = { "US", "CA", "OM", "BR", "AR", "FR", "DE", "IT", "AF" };
		int randnumber = rand.nextInt(countryCodes.length);
		WebElement dropdown = driver.findElement(By.id("autocomplete"));
		dropdown.sendKeys(countryCodes[randnumber]);
		Thread.sleep(2000);

		dropdown.sendKeys(Keys.chord(Keys.ARROW_DOWN, Keys.ENTER));

	}

	@Test(priority = 1, description = "new", invocationCount = 4, enabled = false)
	public void Static_Dropdown_Example() throws InterruptedException {
		WebElement item_select = driver.findElement(By.id("dropdown-class-example"));
		Select sel = new Select(item_select);
		int[] numbers = { 1, 2, 3 };

		int q = rand.nextInt(numbers.length);
		sel.selectByIndex(q);
		Thread.sleep(1900);
		// sel.selectByValue("option3");

	}

	// xpath =//tagname [@attributename'value of attribute']
	// xpath =//input[@taype = 'checkbox;]
	@Test(priority = 1, description = "esy", invocationCount = 3, enabled = false)
	public void cheekbox() {
		List<WebElement> list_cheekboox1 = driver.findElements(By.xpath("//input[@type='checkbox']"));

		int random_number = rand.nextInt(list_cheekboox1.size());
		list_cheekboox1.get(random_number).click();

	}

	@Test(priority = 2, description = "alert", invocationCount = 1, enabled = true)
	public void alert() {
		WebElement name_box = driver.findElement(By.id("name"));
		name_box.sendKeys("aliabufares");
		WebElement alert = driver.findElement(By.id("alertbtn"));
		alert.click();
		driver.switchTo().alert().accept();
		// System.out.println(driver.switchTo().alert().getText());
		// driver.switchTo().alert().dismiss();

		// WebElement confairmbooks=driver.findElement(By.id("confirmbtn"));
		// confairmbooks.click();
		// driver.switchTo().alert().accept();
		// driver.switchTo().alert().dismiss();

	}

	@Test(priority = 1, description = "", enabled = true, invocationCount = 1)
	public void new_windo() throws InterruptedException {
		WebElement windo_1 = driver.findElement(By.id("openwindow"));
		windo_1.click();
		Thread.sleep(2000);
		List<String> handel_window = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(handel_window.get(1));
		WebElement details = driver.findElement(By.id("menu-item-9680"));

		details.click();
		System.out.println(driver.getTitle() + "hello baby ");
		driver.switchTo().window(handel_window.get(0));
		
		

	}

	@AfterTest()
	public void then_test() {
	}

}
