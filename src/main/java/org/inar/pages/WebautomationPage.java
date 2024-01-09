package org.inar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WebautomationPage extends BasePage {

    @FindBy(linkText = "Draggable")
    private WebElement draggableLink;

    @FindBy(linkText = "Autocomplete")
    private WebElement autocomplateButton;




    public void clickOnDraggableButton(){
        draggableLink.click();
    }

    public void clickOnTheAutoComplateButton(){
        autocomplateButton.click();
    }

}
