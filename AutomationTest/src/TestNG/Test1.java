package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test1 {

@Test
public void testStanding() {
	
	WebDriver driver = new FirefoxDriver();
	
	// launch the firefox browser and open the application url
    driver.get("http://localhost:8081");
   
//maximize the browser window
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    Select countrydropdown = new Select (driver.findElement(By.id("countrydropdown")));
    countrydropdown.selectByVisibleText("England");
    
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    Select leaguedropdown = new Select (driver.findElement(By.id("leaguedropdown")));
    leaguedropdown.selectByVisibleText("Championship");

    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

    Select teamdropdown = new Select (driver.findElement(By.id("teamdropdown")));
    teamdropdown.selectByVisibleText("Leeds United");
    
    WebElement getStandingButton = driver.findElement(By.id("getstanding"));
    getStandingButton.click();
    
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    String script = driver.findElement(By.id("result")).getText();
    
    
    
    //close the web browser
    driver.close();
}}
