package com.actitime.generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;

public class BaseClass {
	public static WebDriver driver;
	public FileLib f=new FileLib();
	@BeforeTest
public void openBrowser() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}	@BeforeMethod
public void login() throws IOException {

	String url = f.getPropertyData("url");
	driver.get(url);
	String un = f.getPropertyData("un");
	String pwd=f.getPropertyData("pwd");
	LoginPage l=new LoginPage(driver);
	l.login(un, pwd);
}	@AfterMethod
public void logout() {
	HomePage h=new HomePage(driver);
	h.logout();
}
	@AfterTest
public void closeBrowser() {
	driver.quit();
}
}