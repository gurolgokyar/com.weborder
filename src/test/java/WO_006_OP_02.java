import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WO_006_OP_02 extends Hooks {

	@Test
	void orderPlacementWithOutCalculationTest() {
		WebElement weborderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
		weborderButton.click();

		WebElement username = driver.findElement(By.id("login-username-input"));
		WebElement password = driver.findElement(By.id("login-password-input"));

		username.sendKeys("Inar");
		password.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement orderButton = driver.findElement(By.cssSelector("[href = '/weborder/order']"));
		orderButton.click();

		WebElement productDropdown = driver.findElement(By.id("productSelect"));
		Select select = new Select(productDropdown);
		select.selectByVisibleText("FamilyAlbum");

		WebElement quantity = driver.findElement(By.id("quantityInput"));
		quantity.sendKeys("3");

		WebElement discount = driver.findElement(By.id("discountInput"));
		discount.sendKeys("17");

		WebElement name = driver.findElement(By.cssSelector("[placeholder = 'Enter your name']"));
		name.sendKeys("Inar Academy");

		WebElement street = driver.findElement(By.cssSelector("[placeholder = 'Enter your street']"));
		street.sendKeys("1100 Congress Ave");

		WebElement city = driver.findElement(By.cssSelector("[placeholder = 'Enter your city']"));
		city.sendKeys("Austin");

		WebElement state = driver.findElement(By.cssSelector("[placeholder = 'Enter your state']"));
		state.sendKeys("TX");

		WebElement zipCode = driver.findElement(By.cssSelector("[placeholder = 'Enter your zip code']"));
		zipCode.sendKeys("78701");

		WebElement cartType = driver.findElement(By.cssSelector("[value= 'Mastercard']"));
		cartType.click();

		WebElement cartNumber = driver.findElement(By.id("cardNumber"));
		cartNumber.sendKeys("5162738261027163");

		WebElement expireDate = driver.findElement(By.id("expiryDate"));
		expireDate.sendKeys("11/28");

		WebElement processButton = driver.findElement(By.xpath("//button[text() = 'Process']"));
		processButton.click();

		wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//em[text() = 'Fix errors in Product " + "Information ']")));

		Assertions.assertTrue(
				driver.findElement(By.xpath("//em[text() = 'Fix errors in Product Information ']")).isDisplayed(),
				"Expected error message did not displayed!");

	}

}
