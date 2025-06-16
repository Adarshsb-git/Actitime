package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
@FindBy(xpath = "//div[text()='Add New']")
private WebElement addNewBtn;
@FindBy(className = "createNewCustomer")
private WebElement createNewCustomerBtn;
@FindBy(id="customerLightBox_content")
private WebElement popup; 
@FindBy(id="customerLightBox_nameField")
private WebElement custNameTbx;
@FindBy(id="customerLightBox_descriptionField")
private WebElement custDescTbx;
@FindBy(id="customerLightBox_customerSelectorPlaceholder")
private WebElement dropdown;
@FindBy(linkText = "Our Company")
private WebElement ourCompLink;
@FindBy(id = "customerLightBox_commitBtn")
private WebElement createCustBtn;
@FindBy(className = "innerHtml")
private WebElement confirmPopup;
public TaskListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}
public WebElement getAddNewBtn() {
	return addNewBtn;
}
public WebElement getCreateNewCustomerBtn() {
	return createNewCustomerBtn;
}
public WebElement getPopup() {
	return popup;
}
public WebElement getCustNameTbx() {
	return custNameTbx;
}
public WebElement getCustDescTbx() {
	return custDescTbx;
}
public WebElement getDropdown() {
	return dropdown;
}
public WebElement getOurCompLink() {
	return ourCompLink;
}
public WebElement getCreateCustBtn() {
	return createCustBtn;
}
public WebElement getConfirmPopup() {
	return confirmPopup;
}

}
