package org.inar.pages.draggable;

import org.inar.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DraggablePage extends BasePage {

    @FindBy(linkText = "Default Functionality")
    private List<WebElement> defaultFunctionalityLink;

    @FindBy(xpath = "//a[text() = 'Auto Scrolling']")
    private WebElement autoScrollingLink;

    @FindBy(linkText = "Constrain Movement")
    WebElement constrainMovementLink;

    public void clickOnDefaultFunctionalityButton(){
        defaultFunctionalityLink.get(0).click();
    }

    public void clickOnAutoScrollingButton(){
        autoScrollingLink.click();
    }

    public void clickOnTheConstantButton(){
        constrainMovementLink.click();
    }

}
