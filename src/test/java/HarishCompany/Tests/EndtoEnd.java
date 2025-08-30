package HarishCompany.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;




public class EndtoEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        String productName = "ZARA COAT 3";
        System.setProperty("webdriver.edge.driver", "C:/Users/bawan/Downloads/edgedriver_win64/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	    driver.findElement(By.id("userEmail")).sendKeys("dharaniodelaa@gmail.com");
	    driver.findElement(By.id("userPassword")).sendKeys("DharaniOdela@3");
	    driver.findElement(By.id("login")).click();
	    
	    WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait.until (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
	    
	    List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	    WebElement prod = products.stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	    prod.findElement(By.cssSelector(".w-10")).click();
	    
	    WebDriverWait wait1 =new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait1.until (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
	    wait1.until (ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	    
	    
	    List <WebElement> cartProducts = driver.findElements(By.cssSelector("div[class='cartSection'] h3"));
	    Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
	    Assert.assertTrue(match);
	    
	    driver.findElement(By.cssSelector(".totalRow button")).click();
	    Actions a = new Actions(driver);
	    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
	    
	    WebDriverWait wait3 =new WebDriverWait(driver,Duration.ofSeconds(10));
	    wait3.until (ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	    
	    driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
	    driver.findElement(By.cssSelector(".action__submit")).click();
	    String confirmMessage = driver.findElement(By.className("hero-primary")).getText();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    System.out.println(confirmMessage);
	    driver.quit();
            
	    System.out.println("I will be a Filmmaker");
            System.out.println("Debts will be cleared");
            System.out.println("I will get the Fucking job");
            System.out.println("Luffy will be King of Pirates");
	    
	    
	    System.out.println("Yes they will fucking happen. No worries"):
	}

	
	}
