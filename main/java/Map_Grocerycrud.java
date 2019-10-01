package Prova_sicredi.Automation;



import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//https://www.grocerycrud.com/demo/bootstrap_theme

public class Map_Grocerycrud {
	
	protected static  WebDriver driver;
	protected  WebDriverWait wait;
	
	public Map_Grocerycrud(WebDriver driver) {
		Map_Grocerycrud.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	// Mapping page
	
	@FindBy(how = How.ID, using = "switch-version-select")
	WebElement switchversionselect;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a")
	WebElement btnAdd;
	
	@FindBy(how = How.ID, using = "field-customerName")
	WebElement customerName;
	
	@FindBy(how = How.ID, using = "field-contactLastName")
	WebElement lastName;
	
	@FindBy(how = How.ID, using = "field-contactFirstName")
	WebElement firstName;
	
	@FindBy(how = How.ID, using = "field-phone")
	WebElement phone;
	
	@FindBy(how = How.ID, using = "field-addressLine1")
	WebElement addressLine1;
	
	@FindBy(how = How.ID, using = "field-addressLine2")
	WebElement addressLine2;
	
	@FindBy(how = How.ID, using = "field-city")
	WebElement city;
	
	@FindBy(how = How.ID, using = "field-state")
	WebElement state;
	
	@FindBy(how = How.ID, using = "field-postalCode")
	WebElement postalCode;
	
	@FindBy(how = How.ID, using = "field-country")
	WebElement country;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\\\"field_salesRepEmployeeNumber_chosen\\\"]/a/span")
	WebElement repEmployeeNumber;
	
	@FindBy(how = How.ID, using = "field-creditLimit")
	WebElement creditLimit;
	
	@FindBy(how = How.ID, using = "form-button-save")
	WebElement clickBtnSave;
	

	
	//Methods with actions
	
	public void setSwitchVersionSelect(String valor) {
			Select sel = new Select(switchversionselect);
			sel.selectByVisibleText(valor);
	}
	
	public void clickBtnAdd() {
		wait.until(ExpectedConditions.elementToBeClickable(btnAdd)).click();
	}
	
	public void setCustomerName(String valor) {

		wait.until(ExpectedConditions.visibilityOf(customerName)).sendKeys(valor);
	}
	
	public void setLastName(String valor) {
		wait.until(ExpectedConditions.visibilityOf(lastName)).sendKeys(valor);
	}
	
	public void setFirstName(String valor) {
		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(valor);
	}
	
	public void setPhone(String valor) {
		wait.until(ExpectedConditions.visibilityOf(phone)).sendKeys(valor);
	}
	
	public void setAddressLine1(String valor) {
		wait.until(ExpectedConditions.visibilityOf(addressLine1)).sendKeys(valor);
	}
	
	public void setAddressLine2(String valor) {
		wait.until(ExpectedConditions.visibilityOf(addressLine2)).sendKeys(valor);
	}
	
	public void setCity(String valor) {
		wait.until(ExpectedConditions.visibilityOf(city)).sendKeys(valor);
	}
	
	public void setState(String valor) {
		wait.until(ExpectedConditions.visibilityOf(state)).sendKeys(valor);
	}

	public void setPostalCode(String valor) {
		wait.until(ExpectedConditions.visibilityOf(postalCode)).sendKeys(valor);
	}
	
	public void setContry(String valor) {
		wait.until(ExpectedConditions.visibilityOf(country)).sendKeys(valor);
	}
	

	public  void setRepEmployeeNumber() {
		
		//Page scroll
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scrollBy(0,250)", "");
		
		//Mouse movement
		Actions hover=new Actions(driver);
		hover.moveToElement(repEmployeeNumber);
		driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/span")).click();
		driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys("Fixter");
		driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input")).sendKeys(Keys.ENTER);	
	}
	
	public void setCreditLimit(String valor) {
		wait.until(ExpectedConditions.visibilityOf(creditLimit)).sendKeys(valor);
	}
	
	public void clickBtnSave() {
		wait.until(ExpectedConditions.elementToBeClickable(clickBtnSave)).click();
	}
	
	public void validarMensagem() {
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("report-success")));
		Object mensagemSucesso = driver.findElement(By.cssSelector("#report-success > p")).getText();
		assertEquals("Your data has been successfully stored into the database. Edit Customer or Go back to list", mensagemSucesso);
	}
}

