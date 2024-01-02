import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WO_005_CF_02 extends Hooks {

	@Test
	void calculateButtonTestWithInvalidInput() {
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

		WebElement productDropdown = driver.findElement(By.className("form-select"));
		Select select = new Select(productDropdown);
		select.selectByVisibleText("ScreenSaver");

		WebElement discount = driver.findElement(By.id("discountInput"));
		discount.sendKeys("20");

		WebElement calculate = driver.findElement(By.cssSelector("form > button"));
		calculate.click();

		assertTrue(driver.findElement(By.id("quantityValidateError")).isDisplayed(),
				"invalid Quantity error message " + "did not displayed");
	}

}
