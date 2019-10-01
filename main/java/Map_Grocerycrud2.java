package Prova_sicredi.Automation;




import static org.junit.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Map_Grocerycrud2 {
	protected static WebDriver driver;
	protected WebDriverWait wait;
	
	public Map_Grocerycrud2(WebDriver driver) {
		Map_Grocerycrud2.driver = driver;
		wait = new WebDriverWait(driver, 10);
		PageFactory.initElements(driver, this);
	}
	
	// Mapping page
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"report-success\"]/p/a[2]")
	WebElement backToList;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]")
	WebElement btnSearch;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[1]/div[2]/a[3]/input")
	WebElement incluirnome;
	
	@FindBy(how = How.XPATH, using =  "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[1]")
	
	WebElement inputSelectAllCheckbox;

	@FindBy(how = How.XPATH, using = "//*[@id=\"gcrud-search-form\"]/div[2]/table/thead/tr[2]/td[2]/div[1]/a")
	WebElement btnDelete;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/div[2]/div[3]/div/div/div[3]/button[2]")
	WebElement btnDeleteModal;



	//Methods with actions
	
	public void clickBackToList() {
		wait.until(ExpectedConditions.elementToBeClickable(backToList)).click();
	}
	
	public void clickBtnSearch() {
	wait.until(ExpectedConditions.elementToBeClickable(btnSearch)).click();
	}
	
	public void setName(String valor) {
		wait.until(ExpectedConditions.visibilityOf(incluirnome)).sendKeys(valor);
		wait.until(ExpectedConditions.visibilityOf(incluirnome)).sendKeys(Keys.ENTER);
	}
	
	public  void clickCheck() throws InterruptedException {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(inputSelectAllCheckbox)).click();
	
		}
	
	public void clickBtnDelete() {
		wait.until(ExpectedConditions.elementToBeClickable(btnDelete)).click();
		}
	public void validaMsg() throws InterruptedException {
		
		Object validaMsg = driver.findElement(By.xpath("//div[@class='delete-multiple-confirmation modal fade in show']/div/div/div[@class='modal-body']/p[@class='alert-delete-multiple-one']")).getText();
		assertEquals("Are you sure that you want to delete this 1 item?", validaMsg);
		}
	
	public void clickBtnDeleteModal() {
		wait.until(ExpectedConditions.elementToBeClickable(btnDeleteModal)).click();
		}
	
public void validaMsgDelete() throws InterruptedException {
		Thread.sleep(5000);
		Object validaMsgDelete = driver.findElement(By.xpath("//div[@data-growl='container']/span[@data-growl='message']")).getText();
		assertEquals("Your data has been successfully deleted from the database.", validaMsgDelete);
		}
	
	
	}

