package Prova_sicredi.Automation;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TestGrocerycrud2 {
	
	WebDriver driver;
	WebElement element;
	Map_Grocerycrud Map_Grocerycrud;
	Map_Grocerycrud2 Map_Grocerycrud2;
	
	@Before
	public void setUp() throws Exception {
		File browser = new File("src\\main\\Resource\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", browser.getAbsolutePath());
		
		driver = new ChromeDriver();
		Map_Grocerycrud = new Map_Grocerycrud(driver);
		Map_Grocerycrud2 = new Map_Grocerycrud2(driver);
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws Exception {
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme_v4/add");

		// maximize screen

		driver.manage().window().maximize();
		
		
		/*
		 * The steps of challenge 1, asks to close the browser, 
		 * for this reason i started the challenge 2 test on the addition screen 
		 * to click on the "Back To List" element. because it would give error validating
		 * the message "Are you sure you want to delete this 1 item?" when actually there
		 * would be two at the time of the test.
		 */
		
		//Screen One
		Map_Grocerycrud.clickBtnSave();
		
		//Screen Two
		Map_Grocerycrud2.clickBackToList();
		Map_Grocerycrud2.clickBtnSearch();
		Map_Grocerycrud2.setName("Teste Sicredi");
		Map_Grocerycrud2.clickCheck();
		Map_Grocerycrud2.clickBtnDelete();
		Map_Grocerycrud2.validaMsg();
		Map_Grocerycrud2.clickBtnDeleteModal();
		Map_Grocerycrud2.validaMsgDelete();
		
	}





	
}
