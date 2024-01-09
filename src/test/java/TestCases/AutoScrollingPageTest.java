package TestCases;

import org.assertj.core.api.SoftAssertions;
import org.inar.utils.Pages;
import org.junit.jupiter.api.Test;

public class AutoScrollingPageTest extends Hooks {

    Pages pages = new Pages();

    @Test
    void testAutoScrollingDraggable() {
        SoftAssertions softAssertions = new SoftAssertions();

        pages.getHomePage().clickWebAutomation();

        pages.getWebautomationPage().clickOnDraggableButton();

        pages.getDraggablePage().clickOnAutoScrollingButton();

        pages.getAutoScrollingPage().dragAndDrop(pages.getAutoScrollingPage().getFirstDraggable(), 215, 0);
        pages.getAutoScrollingPage().dragAndDrop(pages.getAutoScrollingPage().getThirdDraggable(), -215, 0);

        int finalX1 =
                pages.getAutoScrollingPage().getLocalOfDraggableX(pages.getAutoScrollingPage().getFirstDraggable());
        int finalX2 =
                pages.getAutoScrollingPage().getLocalOfDraggableX(pages.getAutoScrollingPage().getSecondDraggable());
        int finalX3 =
                pages.getAutoScrollingPage().getLocalOfDraggableX(pages.getAutoScrollingPage().getThirdDraggable());

        //You can not use SoftAssertion methods here
        softAssertions.assertThat(finalX1).isGreaterThan(finalX2);
        softAssertions.assertThat(finalX2).isGreaterThan(finalX3);

        softAssertions.assertAll();
    }
}
