import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class WO_009_OP_04 extends Hooks {

	@Test
	void orderPlacementWithOutCartTypeTest() {
		WebElement weborderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
		weborderButton.click();

		WebElement username = driver.findElement(By.id("login-username-input"));
		WebElement password = driver.findElement(By.id("login-password-input"));

		// Send valid information
		username.sendKeys("Inar");
		password.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// click the order button
		WebElement orderButton = driver.findElement(By.id("order-tab"));
		orderButton.click();

		WebElement productDropDown = driver.findElement(By.id("productSelect"));
		Select productSelect = new Select(productDropDown);
		productSelect.selectByVisibleText("SportsEquipment");

		WebElement quantity = driver.findElement(By.id("quantityInput"));
		quantity.sendKeys("1");

		WebElement discount = driver.findElement(By.id("discountInput"));
		discount.sendKeys("10");

		WebElement calculateButton = driver.findElement(By.xpath("//button[text() = 'Calculate']"));
		calculateButton.click();

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

		WebElement cardNumber = driver.findElement(By.id("cardNumber"));
		cardNumber.sendKeys("4938220192845");

		WebElement expireDate = driver.findElement(By.id("expiryDate"));
		expireDate.sendKeys("09/26");

		WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
		processButton.click();

		wait.until(ExpectedConditions
			.visibilityOfElementLocated(By.xpath("//em[text() = 'Card " + "type cannot be empty']")));

		Assertions.assertEquals("Card type cannot be empty",
				driver.findElement(By.xpath("//em[text() = 'Card type cannot " + "be empty']")).getText(),
				"Expected alert message: \"Cart type can not be empty\" did not displayed");
	}

}
