import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WO_014_TCB_01 extends Hooks {

	@Test
	void testThemeChangeButtonFunctionality() throws InterruptedException {
		String backgroundColor = driver.findElement(By.xpath("//*[@id='root']/div")).getAttribute("data-theme");

		WebElement themeChangeButton = driver.findElement(By.xpath("//*[@id='navbar']/div/div/div/div[2]"));
		themeChangeButton.click();

		String backgroundColorAfterThemeChangeButtonClicked = driver.findElement(By.xpath("//*[@id='root']/div"))
			.getAttribute("data-theme");

		Assertions.assertNotEquals(backgroundColor, backgroundColorAfterThemeChangeButtonClicked,
				"After clicked " + "theme change button, the color of page did not change");
	}

}
