import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_006_OP_01 extends Hooks {

    @Test
    public void calculateButtonTest() {
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

        WebElement cartType = driver.findElement(By.id("visa"));
        cartType.click();

        WebElement cardNumber = driver.findElement(By.id("cardNumber"));
        cardNumber.sendKeys("4938281746192845");

        WebElement expireDate = driver.findElement(By.id("expiryDate"));
        expireDate.sendKeys("11/28");

        WebElement processButton = driver.findElement(By.xpath("//button[text()='Process']"));
        processButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));
        WebElement message = driver.findElement(By.xpath("//div[@role='alert']"));
        String actualMessage = message.getText();
        String expectedMessage = "New order has been successfully added.";
        assertEquals(expectedMessage, actualMessage, "After clicked Process button, Expected message did " +
                "not displayed");

        WebElement alertCloseButton = driver.findElement(By.cssSelector(".btn-close"));
        alertCloseButton.click();


        name.clear();
        name.sendKeys("Gurol Gokyar");
        processButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='alert']")));

        WebElement viewAllOrders = driver.findElement(By.id("view-orders-tab"));
        viewAllOrders.click();

        List<WebElement> namesInOrders = driver.findElements(By.xpath("//td[2]"));
        String actualName = namesInOrders.get(namesInOrders.size() - 1).getText();
        String expectedName = "Gurol Gokyar";

        assertEquals(expectedName, actualName, "Order rank is not expected");


    }
}
