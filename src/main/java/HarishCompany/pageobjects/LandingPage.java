package HarishCompany.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HarishCompany.AbstractComponents.AbstarctComponent;

public class LandingPage extends AbstarctComponent{

	WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	//PageFactory


	@FindBy(id="userEmail")
	WebElement userEmail;

	@FindBy(id="userPassword")
	WebElement passwordEle;

	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(css=".toast-message")
	WebElement errorMessage;

	public ProductCatalogue loginApplication(String email,String password) {

		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	
	public void goTo() {

		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}

}
