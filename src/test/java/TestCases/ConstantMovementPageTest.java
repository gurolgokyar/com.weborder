package TestCases;

import org.assertj.core.api.SoftAssertions;
import org.inar.utils.Pages;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class ConstantMovementPageTest extends Hooks{

    Pages pages = new Pages();

    @Test
    public void testConstantMovementPage() throws InterruptedException {
        SoftAssertions softAssertions = new SoftAssertions();

        pages.getHomePage().clickWebAutomation();

        pages.getWebautomationPage().clickOnDraggableButton();

        pages.getDraggablePage().clickOnTheConstantButton();

        //Firstly find if the draggable1's x-coordinate is same after attempted to drag right
        int initialX =
                pages.getConstantMovementPage().getLocateOfDraggableX(pages.getConstantMovementPage().getDraggable1());

        pages.getConstantMovementPage().dragAndDrop(pages.getConstantMovementPage().getDraggable1(), 10, 0);

        int finalX =
                pages.getConstantMovementPage().getLocateOfDraggableX(pages.getConstantMovementPage().getDraggable1());

        softAssertions.assertThat(initialX).isEqualTo(finalX);

        //Find if draggable2's y-coordinate is same after attempted to grag down
        int initialY =
                pages.getConstantMovementPage().getLocateOfDraggableY(pages.getConstantMovementPage().getDraggable2());

        pages.getConstantMovementPage().dragAndDrop(pages.getConstantMovementPage().getDraggable1(), 0, 10);

        int finalY =
                pages.getConstantMovementPage().getLocateOfDraggableY(pages.getConstantMovementPage().getDraggable2());

        softAssertions.assertThat(finalY).isEqualTo(initialY);

        //find if draggable3 is already in the biggestBox after attempted to drag that out of bounds
        int widthOfBiggestBox = pages.getConstantMovementPage().getBiggestBox().getSize().getWidth();
        int heightOfBiggestBox = pages.getConstantMovementPage().getBiggestBox().getSize().getHeight();

        //actions.keyDown(Keys.PAGE_DOWN).release().perform();
        //Thread.sleep(5000);
        pages.getConstantMovementPage().dragAndDrop(pages.getConstantMovementPage().getDraggable3(),
                -widthOfBiggestBox, -heightOfBiggestBox);

        int XOfBiggestBox =
                pages.getConstantMovementPage().getLocateOfDraggableX(pages.getConstantMovementPage().getBiggestBox());

        int finalXOfDraggable3 =
                pages.getConstantMovementPage().getLocateOfDraggableX(pages.getConstantMovementPage().getDraggable3());

        softAssertions.assertThat(XOfBiggestBox).isLessThan(finalXOfDraggable3);

        int YOfBiggestBox =
                pages.getConstantMovementPage().getLocateOfDraggableY(pages.getConstantMovementPage().getBiggestBox());

        int finalYOfDraggable3 =
                pages.getConstantMovementPage().getLocateOfDraggableY(pages.getConstantMovementPage().getDraggable3());

        softAssertions.assertThat(YOfBiggestBox).isLessThan(finalYOfDraggable3);

        //Normally we should attempt drag the draggable3 to right and low

        //Now let's find if draggable4 is already inside the draggable5 after attempted to drag out of bounds
        int widthOfDraggable5 = pages.getConstantMovementPage().getDraggable5().getSize().getWidth();
        int heightOfDraggable5 = pages.getConstantMovementPage().getDraggable5().getSize().getHeight();
        int widthOfDraggable4 = pages.getConstantMovementPage().getDraggable4().getSize().getWidth();

        //Drag the element right and up
        Thread.sleep(2000);
        pages.getConstantMovementPage().dragAndDrop(pages.getConstantMovementPage().getDraggable4(),
                -widthOfDraggable5, -heightOfDraggable5);

        int finalXOfDraggable4 =
                pages.getConstantMovementPage().getLocateOfDraggableX(pages.getConstantMovementPage().getDraggable4()) + widthOfDraggable4;
        int XOfDraggable5 =
                pages.getConstantMovementPage().getLocateOfDraggableX(pages.getConstantMovementPage().getDraggable5()) + widthOfDraggable5;

        softAssertions.assertThat(XOfDraggable5).isLessThan(finalXOfDraggable4);

        int finalYOfDraggable4 =
                pages.getConstantMovementPage().getLocateOfDraggableY(pages.getConstantMovementPage().getDraggable4());
        int upperYOfDraggable5 =
                pages.getConstantMovementPage().getLocateOfDraggableY(pages.getConstantMovementPage().getDraggable5());

        softAssertions.assertThat(upperYOfDraggable5).isLessThan(finalYOfDraggable4);

        softAssertions.assertAll();
    }
}
