package org.inar.pages.draggable;

import org.inar.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DefaultFunctionalityPage extends BasePage {

    @FindBy(id = "draggable")
    public WebElement draggable;

    public void drugAndDrop(int xOffset, int yOffset){
        actions.dragAndDropBy(draggable, xOffset, yOffset).perform();
    }

    public void drugAndDrop(){
        drugAndDrop(100, 100);
    }

    public int getLocalOfDraggableX(){
        return draggable.getLocation().getX();
    }

    public int getLocalOfDraggableY(){
        return draggable.getLocation().getY();
    }
}
