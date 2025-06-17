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
public class ProjectModule extends BaseClass {
	@Test
	public void createProject() throws EncryptedDocumentException, IOException {
		HomePage h = new HomePage(driver);
		h.setTasks();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getCreateProjectBtn().click();
		boolean res = t.getCreateProjectPage().isDisplayed();
		Assert.assertTrue(res);
		FileLib f = new FileLib();
		String projectName = f.getExcelData("ProjectDetails", 1, 0);
		t.getProjectNameTxBtx().sendKeys(projectName);
		t.getProjectNameDropdown().click();
		t.getProjectNameSelect().click();
		String desc = f.getExcelData("ProjectDetails", 1, 1);
		t.getProjectDetails().sendKeys(desc);
		t.getProjectCreateBtn().click();
		String text = t.getCreateProjectMsg().getText();
		Assert.assertEquals(text, "Project '" + projectName + "' has been created");
		Reporter.log(text, true);
	}

	@Test
	public void deleteProject() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage h = new HomePage(driver);
		h.setTasks();
		FileLib f = new FileLib();
		String projectName = f.getExcelData("ProjectDetails", 1, 0);
		TaskListPage t = new TaskListPage(driver);
		t.getSearchBox().sendKeys(projectName);

		t.getEditProjectBtn().click();
		Thread.sleep(3000);
		t.getProjectActionsBtn().click();
		;
		t.getProjectDeleteBtn().click();

		t.getProjectDeleteConfirm().click();
		String text = t.getDeleteProjectMsg().getText();
		Assert.assertEquals(text, "Project '" + projectName + "' has been deleted");
		Reporter.log(text, true);
	}

}
