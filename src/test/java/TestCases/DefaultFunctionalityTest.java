package TestCases;

import org.inar.utils.Pages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DefaultFunctionalityTest extends Hooks{

    Pages pages = new Pages();

    @Test
    void testDefaultDraggable(){
        pages.getHomePage().clickWebAutomation();

        //click on the draggable button
        pages.getWebautomationPage().clickOnDraggableButton();

        //Click on the default functionality
        pages.getDraggablePage().clickOnDefaultFunctionalityButton();

        //Get the initial value of the coordinates of the element
        int initialX = pages.getDefaultFunctionalityPage().getLocalOfDraggableX();
        int initialY = pages.getDefaultFunctionalityPage().getLocalOfDraggableY();

        //Drag the draggable element by 100 pixels to right and 100 pixels down
        pages.getDefaultFunctionalityPage().drugAndDrop(100, 100);

        //Get the final value of the coordinates of the element
        int finalX = pages.getDefaultFunctionalityPage().getLocalOfDraggableX();
        int finalY = pages.getDefaultFunctionalityPage().getLocalOfDraggableY();

        Assertions.assertTrue(finalY > initialY, "The element is not draggable after attempted to drag to down by 100" +
                " pixels");
        Assertions.assertTrue(finalX > initialX, "The element is not draggable after attempt to drag to right by 100 " +
                "pixels");

    }

}
