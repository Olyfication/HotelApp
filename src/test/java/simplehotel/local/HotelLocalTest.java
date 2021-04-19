package simplehotel.local;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.*;

import org.junit.After;

public class HotelLocalTest extends AbstractTest{
	
	public String expectedTitle = "Application Tutoriel pour la base de données des hotels"; 
	public String expectedHotels = "Hôtels disponibles à New York";
	
	@Before
	public void setup() {
		selectBrowser(browser);
	}
	
	@Test	
	public void test() {
	
	driver.get ("http://192.168.1.100:8090/HotelWebapp/");
	//  Vérifier le titre de la page
	String actualTitle = driver.findElement(By.tagName("h2")).getText();
	assertEquals("Page title is not the same that expected", expectedTitle, actualTitle);
	
	// Choisir une ville dans la liste déroulante
	WebElement menu = driver.findElement(By.xpath("//select[@name='ville']"));
	Select select = new Select(menu);
	select.selectByValue("New York");
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	String actualHotels = driver.findElement(By.xpath("//h3[2]")).getText();
	assertEquals(expectedHotels, actualHotels);
		
	}
	
	@After
	public void teardown() {
		driver.quit();
	}

}
