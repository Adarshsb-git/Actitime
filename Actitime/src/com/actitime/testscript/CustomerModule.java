package com.actitime.testscript;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generic.BaseClass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CustomerModule extends BaseClass{
	@Test
public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage h=new HomePage(driver);
		h.setTasks();//It will perform the action directly
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();//It will return the address where we can perform any action
		t.getCreateNewCustomerBtn().click();
		boolean res =t.getPopup().isDisplayed();
		Assert.assertTrue(res);
		String custName = f.getExcelData("CreateCustomer", 1, 2);
		String desc = f.getExcelData("CreateCustomer", 1, 3);
		t.getCustNameTbx().sendKeys(custName);
		t.getCustDescTbx().sendKeys(desc);
		t.getDropdown().click();
		t.getOurCompLink().click();
		t.getCreateCustBtn().click();
		Thread.sleep(2000);
		String text =t.getConfirmPopup().getText();
		Assert.assertEquals(text, "Customer '"+custName+"' has been created");
		boolean result = text.contains(custName);
		Assert.assertTrue(result);
		Reporter.log(text,true);
}	@Test
	public void addUser() {
		
	}
}
