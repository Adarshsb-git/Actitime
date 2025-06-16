package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("http://localhost/login.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		driver.findElement(By.linkText("TASKS")).click();
		driver.findElement(By.xpath("//div[text()='Add New']")).click();
		driver.findElement(By.className("createNewCustomer")).click();
		boolean res = driver.findElement(By.id("customerLightBox_content")).isDisplayed();
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys("TOM");
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys("DEVELOPER");
		driver.findElement(By.id("customerLightBox_customerSelectorPlaceholder")).click();
		driver.findElement(By.linkText("Our Company")).click();
		driver.findElement(By.id("customerLightBox_commitBtn")).click();
		String text = driver.findElement(By.className("innerHtml")).getText();
		System.out.println(text);
		driver.findElement(By.id("logoutLink")).click();
		driver.quit();
	}
}
