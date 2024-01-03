import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WO_003_LP_03 extends Hooks {

	@Test
	public void testLogoutButton() {
		// Navigate to weborder login page
		WebElement orderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
		orderButton.click();

		// Enter username
		WebElement userName = driver.findElement(By.id("login-username-input"));
		userName.sendKeys("Inar");

		// Enter password
		WebElement password = driver.findElement(By.id("login-password-input"));
		password.sendKeys("Academy");

		// Click the login button
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();

		// wait until weborder hom page is displayed
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome-heading")));

		// Click the logout button
		WebElement logoutButton = driver.findElement(By.id("logout-button"));
		logoutButton.click();

		// Exception can be displayed before loginHeading has any value
		WebElement loginHeading = null;
		try {
			// For any unexpected web page
			loginHeading = driver.findElement(By.xpath("//h2[text()='Login']"));
			Assertions.assertTrue(loginHeading.isDisplayed(),
					"The logout " + "process failed when clicked on Logout button");
		}
		catch (NoSuchElementException ex) {
			Assertions.assertNotNull(loginHeading, "The logout " + "process failed when clicked on Logout button");
		}
	}

}
