import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WO_013_VAP_01 extends Hooks{

    @Test
    void testViewAllProductButton(){
        WebElement weborderButton = driver.findElement(By.cssSelector("[href = '/weborder']"));
        weborderButton.click();

        WebElement username = driver.findElement(By.id("login-username-input"));
        WebElement password = driver.findElement(By.id("login-password-input"));

        // Send valid information
        username.sendKeys("Inar");
        password.sendKeys("Academy");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("welcome-heading"))));

        WebElement viewAllProductsButton = driver.findElement(By.cssSelector("[href = '/weborder/view-products']"));
        viewAllProductsButton.click();

        List<WebElement> namesOfProducts = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        String[] names = {"MyMoney", "FamilyAlbum", "ScreenSaver", "TechGadget", "HomeDecor", "FashionApparel",
                "Electronics", "HealthWellness", "SportsEquipment", "Books","KitchenAppliances", "ToysGames"};
        List<String> expectedProductNames = new ArrayList<>(Arrays.asList(names));

        for (int i = 0; i < namesOfProducts.size(); i ++){
            Assertions.assertEquals(expectedProductNames.get(i), namesOfProducts.get(i).getText(), "Expecting product" +
                    " names do not match in the view all product home page");
        }

    }
}
