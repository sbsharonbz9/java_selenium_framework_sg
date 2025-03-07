package galen.pages.tenant.petros.InitialAssessment;

import galen.helpers.common.GalenReport;
import galen.pages.common.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.annotation.Nullable;

public class ADBU_PeyroniesDisease extends BasePage {
    public By peyroniesHeader = By.className("adbuPeyroniesScreen");

    public ADBU_PeyroniesDisease(WebDriver driver) {
        super(driver);
        titleText="PEYRONIE'S DISEASE";
    }

    public WebElement getHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(peyroniesHeader));
    }

    public boolean verifyAtPage(@Nullable GalenReport report) {
        return basicHelpers.verifyAtPage(getHeader().isDisplayed(), "Peyronies Disease", report);
    }

}
