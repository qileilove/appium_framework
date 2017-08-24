package appium.untils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by lqi on 11/08/2017.
 */
public class AppiumAction extends LocateElement{

    protected AppiumDriver driver;
    protected Wait wait;
    protected int TIMEOUT = 10;

    public AppiumAction(AppiumDriver driver){
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
     * This Method for swipe up
     *
     */
    public void swipeToUp() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(width / 2, height * 3 / 4).moveTo(width / 2, height / 4).release().perform();
        // wait for page loading
    }

    /**
     * This Method for swipe down
     *

     */
    public void swipeToDown() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(width / 2, height / 4).moveTo(width / 2, height * 3 / 4).release().perform();
        // wait for page loading
    }

    /**
     * This Method for swipe Left
     *
     */
    public void swipeToLeft( ) {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(width * 3 / 4, height / 2).moveTo(width / 4, height / 2).release().perform();
        // wait for page loading
    }


    public void swipeToRight() {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(width / 4, height / 2).moveTo(width * 3 / 4, height / 2).release().perform();

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


    /**
     * @param locatorType
     * @param locatorName
     */
    public void waitElementToBeVisable(final String locatorType, final String locatorName) {
        wait = new WebDriverWait(driver,TIMEOUT);
        wait.until (ExpectedConditions.visibilityOf(getElement(driver, locatorType, locatorName)));
    }


    /**
     * @param driver
     * @param locatorType
     * @param locatorName
     * @return
     */
    public String getTextString(AppiumDriver driver,String locatorType, String locatorName){
        waitElementToBeVisable(locatorType,locatorName);
        return getElement(driver,locatorType,locatorName).getText();
    }

}
