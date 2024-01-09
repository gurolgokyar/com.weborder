package org.inar.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Driver {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();

    public Driver(){
        throw new UnsupportedOperationException("\"Cannot instantiate utility class\"");
    }

    public synchronized static WebDriver getDriver(){
        if (DRIVER_THREAD_LOCAL.get() == null){
            WebDriver driver;

            String browser = System.getProperty("browser","chrome");
            driver = switch (browser.toLowerCase()){
                case "edge" -> new EdgeDriver();
                case "firefox" -> new FirefoxDriver();
                default -> new ChromeDriver();
            };

            DRIVER_THREAD_LOCAL.set(driver);
            driver.manage().window().maximize();

            if (browser.equalsIgnoreCase("firefox")){
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Weborder")));
                driver.navigate().refresh();
            }
        }
        return DRIVER_THREAD_LOCAL.get();
    }

    public static void closeDriver(){
        if (getDriver() != null){
            getDriver().quit();
            DRIVER_THREAD_LOCAL.remove();
        }
    }
}
