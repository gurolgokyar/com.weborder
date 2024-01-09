package org.inar.utils;

import org.inar.pages.HomePage;
import org.inar.pages.WebautomationPage;
import org.inar.pages.draggable.AutoScrollingPage;
import org.inar.pages.draggable.ConstantMovementPage;
import org.inar.pages.draggable.DefaultFunctionalityPage;
import org.inar.pages.draggable.DraggablePage;

public class Pages {

    private HomePage homePage;

    private WebautomationPage webautomationPage;

    private DefaultFunctionalityPage defaultFunctionalityPage;

    private DraggablePage draggablePage;

    private AutoScrollingPage autoScrollingPage;

    private ConstantMovementPage constantMovementPage;
    public Pages(){
        homePage = new HomePage();
        webautomationPage = new WebautomationPage();
        defaultFunctionalityPage = new DefaultFunctionalityPage();
        draggablePage = new DraggablePage();
        autoScrollingPage = new AutoScrollingPage();
        constantMovementPage = new ConstantMovementPage();
    }

    public HomePage getHomePage(){
        return homePage;
    }

    public DefaultFunctionalityPage getDefaultFunctionalityPage(){
        return defaultFunctionalityPage;
    }

    public WebautomationPage getWebautomationPage(){
        return webautomationPage;
    }

    public DraggablePage getDraggablePage(){
        return draggablePage;
    }

    public AutoScrollingPage getAutoScrollingPage(){
        return autoScrollingPage;
    }

    public ConstantMovementPage getConstantMovementPage(){
        return constantMovementPage;
    }
}
