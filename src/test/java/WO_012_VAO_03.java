import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class WO_012_VAO_03 extends Hooks {

	@Test
	void testDeleteButtonFunctionality() {
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

		// Add 8 more orders
		WebElement addMoreDataButton = driver.findElement(By.xpath("//button[text() = 'Add More Data']"));
		for (int i = 0; i < 8; i++) {
			addMoreDataButton.click();
		}

		// Find the all of rows
		List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".form-check-input"));

		// Collect the links of rows to delete and click to them
		List<String> rowsToDelete = new ArrayList<>();
		for (int i = 0; i <= 4; i++) {
			WebElement element = checkBoxes.get(i);
			rowsToDelete.add(element.findElement(By.xpath("//tr[2]/td[13]/a")).getAttribute("href"));
			if (i % 2 == 0) {
				element.click();
			}
		}

		// Click the delete button
		WebElement deleteButton = driver.findElement(By.xpath("//button[text() = 'Delete']"));
		deleteButton.click();

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[text() = 'Delete']"))));

		// Find if remaining rows include deleted rows' links
		List<WebElement> remainingBoxes = driver.findElements(By.cssSelector(".form-check-input"));
		for (WebElement linksOfRemainingRows : remainingBoxes) {
			Assertions.assertFalse(
					rowsToDelete
						.contains(linksOfRemainingRows.findElement(By.xpath("//tr[2]/td[13]/a")).getAttribute("href")),
					"After clicked delete button, deleting process failed!");
		}
	}

}
