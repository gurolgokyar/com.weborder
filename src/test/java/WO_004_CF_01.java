import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WO_004_CF_01 extends Hooks {

    @Test
    public void calculateButtonTest() throws InterruptedException {
        WebElement weborderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
        weborderButton.click();

        WebElement username = driver.findElement(By.id("login-username-input"));
        WebElement password = driver.findElement(By.id("login-password-input"));

        //Send valid information
        username.sendKeys("Inar");
        password.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        //click the order button
        WebElement orderButton = driver.findElement(By.id("order-tab"));
        orderButton.click();

        WebElement productDropDown = driver.findElement(By.id("productSelect"));
        Select productSelect = new Select(productDropDown);
        productSelect.selectByVisibleText("HomeDecor");

        WebElement quantity = driver.findElement(By.id("quantityInput"));
        quantity.sendKeys("5");

        WebElement discount = driver.findElement(By.id("discountInput"));
        discount.sendKeys("15");

        WebElement calculateButton = driver.findElement(By.xpath("//button[text() = 'Calculate']"));
        calculateButton.click();

        WebElement actualCost = driver.findElement(By.id("totalInput"));
        String costAttribute = actualCost.getAttribute("value");
        String expectedResult = (150 * 5 - 5 * 150 * 0.15) + "";

        Assertions.assertEquals(expectedResult, costAttribute, "After the calculation, actual result and expected " +
                "different each other");

    }
}
