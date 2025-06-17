package com.actitime.testscripts.vinay;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.generics.BaseClass;
import com.actitime.generics.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generics.ListenersImplementation.class)
public class CustomerModule extends BaseClass {
	public String custName;

	@Test
	public void createCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		HomePage h = new HomePage(driver);
		h.setTasks();

		TaskListPage t = new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getCreateCusBtn().click();
		Thread.sleep(3000);
		boolean res = t.getCreateCusPage().isDisplayed();
		Assert.assertTrue(res);
		custName = f.getExcelData("CreateCustomer", 1, 2);
		String desc = f.getExcelData("CreateCustomer", 1, 3);
		t.getCusName().sendKeys(custName);
		t.getCusDescriptions().sendKeys(desc);
		t.getProjectDropdown().click();
		t.getProjectName().click();
		t.getCusCreateBtn().click();
		Thread.sleep(3000);
		String text = t.getCreatedMsgText().getText();
		Assert.assertEquals(text, "Customer '" + custName + "' has been created");
		Reporter.log(text, true);

	}

	@Test
	public void deleteCustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage h = new HomePage(driver);
		h.setTasks();
		FileLib f = new FileLib();
		String custName = f.getExcelData("CreateCustomer", 1, 2);
		TaskListPage t = new TaskListPage(driver);
		t.getSearchBox().sendKeys(custName);
		t.getEditBtn().click();
		Thread.sleep(5000);
		t.getActionsBtn().click();
		t.getDeleteBtn().click();
		t.getDeleteConfirmBtn().click();
		String text = t.getDeletedMsgText().getText();
		Assert.assertEquals(text, "Customer '" + custName + "' has been deleted");
		Reporter.log(text, true);

	}

}
