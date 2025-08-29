package HarishCompany.Tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import HarishCompany.TestComponents.BaseTest;
import HarishCompany.pageobjects.CartPage;
import HarishCompany.pageobjects.CheckoutPage;
import HarishCompany.pageobjects.ConfirmationPage;
import HarishCompany.pageobjects.OrderPage;
import HarishCompany.pageobjects.ProductCatalogue;



public class SubmitOrderTest extends BaseTest {
	String productName = "ZARA COAT 3";


	@Test(dataProvider="getData", groups = {"Purchase"})
	public void submitOrder(HashMap<String, String> input) throws IOException {

		ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.selectCountry("india");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationPage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println(confirmMessage);
	}


	@Test(dependsOnMethods= {"submitOrder"})
	public void orderhistory() {

		ProductCatalogue productCatalogue = landingPage.loginApplication("dharaniodelaa@gmail.com", "DharaniOdela@3");
		OrderPage orderpage = productCatalogue.goToOrderPage();
		Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
	}
	
	

	@DataProvider
	public Object[][] getData() throws IOException 
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\HarishCompany\\data\\PurchaseOrder.json");
		return new Object [][] {{data.get(0)},{data.get(1)}};

	}
}

