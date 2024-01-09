package org.inar.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Weborder")
    private WebElement webOrder;
    @FindBy(linkText = "Webautomation")
    private WebElement webAutomation;

    @FindBy(linkText = "Target Market")
    private WebElement targetMarket;

    @FindBy(linkText = "Booking")
    private WebElement booking;

    @FindBy(linkText = "Handling Certifications")
    private WebElement handlingCertifications;

    @FindBy(linkText = "File Uploading")
    private WebElement fileUploading;

    public void clickWeborder(){
        webAutomation.click();
    }
    public void clickWebAutomation(){
        webAutomation.click();
    }

    public void clickTargetMarket(){
        targetMarket.click();
    }
    public void clickBooking(){
        booking.click();
    }

    public void clickHandlingCertifications(){
        handlingCertifications.click();
    }

    public void clickFileUploading(){
        fileUploading.click();
    }
}
