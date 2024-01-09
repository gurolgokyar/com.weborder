package org.inar.pages.draggable;

import org.inar.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConstantMovementPage extends BasePage {
    @FindBy(id = "draggable5")
    WebElement draggable1;

    @FindBy(id = "draggable6")
    WebElement draggable2;

    @FindBy(id = "draggable7")
    WebElement draggable3;

    @FindBy(id = "draggable8")
    WebElement draggable4;

    @FindBy(xpath = "//*[@id='containment-wrapper']/div[2]")
    WebElement draggable5;

    @FindBy(id = "containment-wrapper")
    WebElement biggestBox;

    public WebElement getDraggable1() {
        return draggable1;
    }

    public WebElement getDraggable2() {
        return draggable2;
    }

    public WebElement getDraggable3() {
        return draggable3;
    }

    public WebElement getDraggable4() {
        return draggable4;
    }

    public WebElement getDraggable5() {
        return draggable5;
    }

    public WebElement getBiggestBox() {
        return biggestBox;
    }

    public void dragAndDrop(WebElement draggable, int XOffset, int YOffset) {
        actions.dragAndDropBy(draggable, XOffset, YOffset).perform();
    }

    public int getLocateOfDraggableX(WebElement draggable) {
        return draggable.getLocation().getX();
    }

    public int getLocateOfDraggableY(WebElement draggable) {
        return draggable.getLocation().getY();
    }

}
