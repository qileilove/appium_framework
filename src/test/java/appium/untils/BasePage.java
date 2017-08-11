package appium.untils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lqi on 11/08/2017.
 */
public class BasePage   extends LocateElement{

    protected AppiumDriver driver;
    protected Wait wait;
    protected int TIMEOUT = 10;

    public BasePage(AppiumDriver driver){
        this.driver=driver;
    }


    /**
     * click an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void clickElement(String locatorType, String locatorName){
        waitElementToBeClickAble(locatorType,locatorName);
        getElement(driver,locatorType,locatorName).click();
    }

    /**
     * type an element
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     * @param input
     */
    public void typeElement(String locatorType, String locatorName, String input){
        waitElementToBeVisable(locatorType,locatorName);
        getElement(driver,locatorType,locatorName).sendKeys(input);

    }

    /**
     *
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void waitElementToBeClickAble(final String locatorType, final String locatorName) {
        wait = new WebDriverWait (driver,TIMEOUT);
        wait.until( ExpectedConditions.elementToBeClickable(getElement(driver,locatorType,locatorName)));
    }


    public void waitElementToBeVisable(final String locatorType, final String locatorName) {
        wait = new WebDriverWait(driver,TIMEOUT);
        wait.until (ExpectedConditions.visibilityOf(getElement(driver, locatorType, locatorName)));
    }


    public String getTextString(AppiumDriver driver,String locatorType, String locatorName){
        return getElement(driver,locatorType,locatorName).getText();
    }

}
