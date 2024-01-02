import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WO_010_VAO_01 extends Hooks {

    @Test
    void checkAllButtonTest() {
        WebElement weborderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
        weborderButton.click();

        WebElement username = driver.findElement(By.id("login-username-input"));
        WebElement password = driver.findElement(By.id("login-password-input"));

        //Send valid information
        username.sendKeys("Inar");
        password.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement viewAllOrders = driver.findElement(By.xpath("//a[text() = 'View all orders']"));
        viewAllOrders.click();

        WebElement addMoreDataButton = driver.findElement(By.xpath("//button[text() = 'Add More Data']"));
        for (int i = 0; i < 4; i++) {
            addMoreDataButton.click();
        }

        WebElement checkAllButton = driver.findElement(By.xpath("//button[text() = 'Check All']"));
        checkAllButton.click();

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".form-check-input"));

        for (WebElement checkBox : checkBoxes) {
            Assertions.assertTrue(checkBox.isSelected(), "To check all boxes is failed after clicked check all button");
        }
    }
}
