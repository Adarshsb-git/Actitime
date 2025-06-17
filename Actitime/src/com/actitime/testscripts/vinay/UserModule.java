package com.actitime.testscripts.vinay;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.UserListPage;
@Listeners(com.actitime.generics.ListenersImplementation.class)
public class UserModule extends BaseClass {
	@Test
	public void AddUser() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage h = new HomePage(driver);
		h.setUsers();
		UserListPage u = new UserListPage(driver);
		u.getAddUserBtn().click();
		boolean res = u.getAddUSerPage().isDisplayed();
		Assert.assertTrue(res);

		FileLib f = new FileLib();
		String firstName = f.getExcelData("UserDetails", 1, 0);
		String lastName = f.getExcelData("UserDetails", 1, 1);
		String email = f.getExcelData("UserDetails", 1, 2);
		String username = f.getExcelData("UserDetails", 1, 3);
		String password = f.getExcelData("UserDetails", 1, 4);
		String confirmPassword = f.getExcelData("UserDetails", 1, 4);

		u.getFirstnameTxtBox().sendKeys(firstName);
		u.getLastnameTxtBox().sendKeys(lastName);
		u.getEmailTxtBox().sendKeys(email);
		u.getUsernameTxtBox().sendKeys(username);
		u.getPwdTxtBox().sendKeys(password);
		u.getConPwdTxtBox().sendKeys(confirmPassword);
		u.getUserBtn().click();
		driver.navigate().refresh();

		u.getSearchTxtBox().sendKeys(firstName);
		Thread.sleep(3000);
		res = u.getCheck1().isDisplayed();
		Assert.assertTrue(res);

	}

	@Test
	public void deleteUser() throws EncryptedDocumentException, IOException, InterruptedException {

		HomePage h = new HomePage(driver);
		h.setUsers();

		FileLib f = new FileLib();
		String name = f.getExcelData("UserDetails", 1, 1);
		Thread.sleep(3000);
		UserListPage u = new UserListPage(driver);
		u.getSearchTxtBox().sendKeys(name);

		Thread.sleep(3000);

		u.getClickUser().click();
		Thread.sleep(3000);
		u.getDeleteBtn().click();
		driver.switchTo().alert().accept();
		driver.navigate().refresh();
Thread.sleep(3000);
		u.getSearchTxtBox().sendKeys(name);
		Thread.sleep(3000);
		boolean res = u.getReCheck().isDisplayed();
		Thread.sleep(3000);
		Assert.assertTrue(res);
	}
}
