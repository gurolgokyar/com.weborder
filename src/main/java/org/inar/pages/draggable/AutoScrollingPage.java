package org.inar.pages.draggable;

import org.inar.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AutoScrollingPage extends BasePage {

    @FindBy(id = "draggable2")
    private WebElement firstDraggable;

    @FindBy(id = "draggable3")
    private WebElement secondDraggable;

    @FindBy(id = "draggable4")
    private WebElement thirdDraggable;

    public void dragAndDrop(WebElement draggableElement, int XOffset, int YOffset){
        actions.dragAndDropBy(draggableElement, XOffset, YOffset).perform();
    }

    public int getLocalOfDraggableX(WebElement draggable){
        return draggable.getLocation().getX();
    }

    public int getLocalOfDraggableY(WebElement draggable){
        return draggable.getLocation().getY();
    }

    public WebElement getFirstDraggable() {
        return firstDraggable;
    }

    public WebElement getSecondDraggable() {
        return secondDraggable;
    }

    public WebElement getThirdDraggable() {
        return thirdDraggable;
    }
}
