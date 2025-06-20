package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
@FindBy(linkText = "TASKS")
private WebElement taskLink;
@FindBy(linkText = "USERS")
private WebElement usersLink;
@FindBy(id="logoutLink")
private WebElement logoutLink;

public HomePage(WebDriver driver){
	PageFactory.initElements(driver, this);
}
public void setTasks() {
	taskLink.click();
}
public void setUsers() {
	usersLink.click();
}
public void logout() {
	logoutLink.click();
}
}
