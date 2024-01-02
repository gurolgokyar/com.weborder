import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WO_008_OP_03 extends Hooks {

     @Test
     void orderPlacementWithInvalidZipCodeTest() throws InterruptedException {
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
          select.selectByVisibleText("MyMoney");

          WebElement quantity = driver.findElement(By.id("quantityInput"));
          quantity.sendKeys("8");

          WebElement discount = driver.findElement(By.id("discountInput"));
          discount.sendKeys("20");

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
          zipCode.sendKeys("92@#83");

          WebElement cartType = driver.findElement(By.cssSelector("[value= 'American Express']"));
          cartType.click();

          WebElement cartNumber = driver.findElement(By.id("cardNumber"));
          cartNumber.sendKeys("342738261027163");

          WebElement expireDate = driver.findElement(By.id("expiryDate"));
          expireDate.sendKeys("01/28");

          WebElement processButton = driver.findElement(By.xpath("//button[text() = 'Process']"));
          processButton.click();

          wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[5]/span/em[contains(text(), " +
                  "'Invalid Zip Code')]")));

          Assertions.assertTrue(driver.findElement(By.xpath("//div[5]/span/em[contains(text(), 'Invalid Zip Code')]")).isDisplayed()
                  , "Expected message : Invalid Zip Code. Enter again! Did not displayed");

     }
}
