import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class WO_012_VAO_03 extends Hooks {

	@Test
	void testDeleteButtonFunctionality() throws InterruptedException {
		WebElement weborderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
		weborderButton.click();

		WebElement username = driver.findElement(By.id("login-username-input"));
		WebElement password = driver.findElement(By.id("login-password-input"));

		// Send valid information
		username.sendKeys("Inar");
		password.sendKeys("Academy");

		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		WebElement viewAllOrders = driver.findElement(By.xpath("//a[text() = 'View all orders']"));
		viewAllOrders.click();

		WebElement addMoreDataButton = driver.findElement(By.xpath("//button[text() = 'Add More Data']"));
		for (int i = 0; i < 8; i++) {
			addMoreDataButton.click();
		}

		List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".form-check-input"));
		List<WebElement> rowsToDelete = new ArrayList<>();

		for (int i = 0; i <= 4; i += 2) {
			WebElement element = checkBoxes.get(i);
			rowsToDelete.add(element);
			element.click();
		}

		WebElement deleteButton = driver.findElement(By.xpath("//button[text() = 'Delete']"));
		deleteButton.click();

		wait.until(ExpectedConditions.visibilityOf(deleteButton));

		List<WebElement> remainingBoxes = driver.findElements(By.cssSelector(".form-check-input"));
		for (WebElement webElement : rowsToDelete) {
			Assertions.assertFalse(remainingBoxes.contains(webElement),
					"After clicked delete button, deleting process failed!");
		}
	}

}
