import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WO_002_LP_02 extends Hooks {
    @Test
    public void loginFailureMessageTest() {
        WebElement orderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
        orderButton.click();

        WebElement userName = driver.findElement(By.id("login-username-input"));
        userName.sendKeys("inar");

        WebElement password = driver.findElement(By.id("login-password-input"));
        password.sendKeys("academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("login-button"))));

        WebElement errorMessage = driver.findElement(By.id("username-error-alert"));
        String actualMessage = errorMessage.getText();
        Assertions.assertEquals("Invalid username", actualMessage, "The alert message did not displayed on the " +
                "screen!\n");

    }
}
