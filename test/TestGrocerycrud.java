package Prova_sicredi.Automation;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;




public class TestGrocerycrud{

	
	 WebDriver driver;
	 WebElement element;
	 Map_Grocerycrud Map_Grocerycrud;

	@Before
	public void setUp() throws Exception {
		File browser = new File("src\\main\\Resource\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", browser.getAbsolutePath());
		
		driver = new ChromeDriver();
		Map_Grocerycrud = new Map_Grocerycrud(driver);
	}
	
	@After
	public void tearDownAfterClass() throws Exception {
		driver.close();
	}

	@Test
	public void test() throws Exception {
		driver.get("https://www.grocerycrud.com/demo/bootstrap_theme");

		// maximizar a tela

		driver.manage().window().maximize();
		
		Map_Grocerycrud.setSwitchVersionSelect("Bootstrap V4 Theme");
		Map_Grocerycrud.clickBtnAdd();
		Map_Grocerycrud.setCustomerName("Teste Sicredi");
		Map_Grocerycrud.setLastName("Teste");
		Map_Grocerycrud.setFirstName("seu nome");
		Map_Grocerycrud.setPhone("51 9999-9999");
		Map_Grocerycrud.setAddressLine1("Av Assis Brasil, 3970");
		Map_Grocerycrud.setAddressLine2("Torre D");
		Map_Grocerycrud.setCity("Porto Alegre");
		Map_Grocerycrud.setState("RS");
		Map_Grocerycrud.setPostalCode("91000-000");
		Map_Grocerycrud.setContry("Brasil");
		Map_Grocerycrud.setRepEmployeeNumber();
		Map_Grocerycrud.setCreditLimit("200");
		Map_Grocerycrud.clickBtnSave();
		Map_Grocerycrud.validarMensagem();
	}


}