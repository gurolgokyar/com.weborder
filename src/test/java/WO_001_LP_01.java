import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WO_001_LP_01 extends Hooks{

    @Test
    public void loginButtonTest(){
       WebElement orderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
       orderButton.click();

       WebElement userName = driver.findElement(By.id("login-username-input"));
       userName.sendKeys("Inar");

       WebElement password = driver.findElement(By.id("login-password-input"));
       password.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("welcome-heading")));

        WebElement message = driver.findElement(By.cssSelector("[class = 'text-fifth fw-bold' ]"));
        String actualMassage = message.getText();

        Assertions.assertTrue(actualMassage.equals("Welcome, Inar!"), "The weborder page is not visible");
    }
}
