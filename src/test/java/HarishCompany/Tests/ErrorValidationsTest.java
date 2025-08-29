package HarishCompany.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import HarishCompany.TestComponents.BaseTest;
import HarishCompany.TestComponents.Retry;
import HarishCompany.pageobjects.CartPage;
import HarishCompany.pageobjects.ProductCatalogue;



public class ErrorValidationsTest extends BaseTest {

	@Test(groups= {"ErrorHandling"},retryAnalyzer= Retry.class)
	public void loginvalidation() throws IOException {


	
		ProductCatalogue productCatalogue = landingPage.loginApplication("dharani@gmail.com", "Odela@3");
		Assert.assertEquals("Incorrect email or password.",landingPage.getErrorMessage());
	}
	
	@Test
	public void productvalidation() throws IOException {


		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("dharaniodelaa@gmail.com", "DharaniOdela@3");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ADIDAS ORIGINAL");
	}
	
}
