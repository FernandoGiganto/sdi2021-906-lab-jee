package com.uniovi.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;
import com.uniovi.tests.util.SeleniumUtils;

//Ordenamos las pruebas por el nombre del método 
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestComplementariosProfessor {

	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	static String Geckdriver024 = "C:\\Users\\ferna\\Desktop\\PL-SDI-Sesión5-material\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	// Antes de cada prueba se navega al URL home de la aplicación
	@Before
	public void setUp() throws Exception {
		driver.navigate().to(URL);
	}

	// Después de cada prueba se borran las cookies del navegador
	@After
	public void tearDown() throws Exception {
		driver.manage().deleteAllCookies();
	}

	// Antes de la primera prueba
	@BeforeClass
	static public void begin() {

	}

	// Al finalizar la última prueba
	@AfterClass
	static public void end() {
		// Cerramos el navegador al finalizar las pruebas
		driver.quit();
	}

	// Registro de profesores con datos válidos.
	@Test
	public void PRO1() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_LoginView.fillForm(driver, "99999977E", "123456");
		// Comprobamos que entramos en la sección privada
		PO_View.checkElement(driver, "text", "99999977E");

		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'teachers-menu')]/a");
		elementos.get(0).click();
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'professor/add')]");
		elementos.get(0).click();
		PO_RegisterView.fillFormTeacher(driver, "Fernando", "Giganto", "sdi");
		// Comprobamos que entramos en la sección privada
		PO_View.checkElement(driver, "text", "Fernando");
	}

	// Registro de profesores con datos inválidos(nombre y categoría inválidos).
	@Test
	public void PRO2() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_LoginView.fillForm(driver, "99999977E", "123456");
		// Comprobamos que entramos en la sección privada
		PO_View.checkElement(driver, "text", "99999977E");
		List<WebElement> elementos = PO_View.checkElement(driver, "free", "//li[contains(@id, 'teachers-menu')]/a");
		elementos.get(0).click();
		elementos = PO_View.checkElement(driver, "free", "//a[contains(@href, 'professor/add')]");
		elementos.get(0).click();
		PO_RegisterView.fillFormTeacher(driver, "a", "Giganto", "a");
		// Comprobamos que entramos en la sección privada
		PO_View.checkElement(driver, "text", "El nombre debe tener entre 5 y 24 caracteres");
	}
	
	// Verificar que solo los usuarios autorizados pueden dar de alta un profesor.
	@Test
	public void PRO3() {
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_LoginView.fillForm(driver, "99999988F", "123456");
		PO_View.checkElement(driver, "text", "99999988F");
		//PO_View.checkElement(driver, "free", "//li[contains(@id, 'teachers-menu')]/a");
		SeleniumUtils.EsperaCargaPaginaNoTexto(driver, "//li[contains(@id, 'teachers-menu')]/a",PO_View.getTimeout() );
	}

}
