package appium.untils;

import Utility.Log;
import io.appium.java_client.*;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

/**
 * Created by lqi on 11/08/2017.
 */
public class AppiumAction extends LocateElement {
    public Log log = new Log ( this.getClass () );

    public Wait wait;
    public int TIMEOUT = 10;


    public void androidPressesKeyCode(String keyName) {
        switch (keyName) {
            case "BACK":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.BACK );
                break;
            case "FLAG_VIRTUAL_HARD_KEY":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.FLAG_VIRTUAL_HARD_KEY );
                break;
            case "ACTION_DOWN":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.ACTION_DOWN );
                break;
            case "ACTION_MULTIPLE":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.ACTION_MULTIPLE );
                break;
            case "ACTION_UP":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.ACTION_UP );
                break;
            case "BACKSPACE":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.BACKSPACE );
                break;
            case "DEL":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.DEL );
                break;
            case "FLAG_CANCELED":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.FLAG_CANCELED );
                break;
            case "FLAG_CANCELED_LONG_PRESS":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.FLAG_CANCELED_LONG_PRESS );
                break;
            case "FLAG_EDITOR_ACTION":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.FLAG_EDITOR_ACTION );
                break;
            case "FLAG_FALLBACK":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.FLAG_FALLBACK );
                break;
            case "FLAG_FROM_SYSTEM":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.FLAG_FROM_SYSTEM );
                break;
            case "FLAG_LONG_PRESS":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.FLAG_LONG_PRESS );
                break;
            case "HOME":

                ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.HOME );
                break;
        }

    }
    private void getConetextHandles(String handleName){

        Set<String> contextNames = driver().getContextHandles();
        for(String context:contextNames) {


            if (context.contains ( "WEBVIEW_" )) {
                driver ().context ( context );
            }
        }
    }


    public void excuteJs(String script) {

        ((JavascriptExecutor) driver()).executeScript ( script );
    }

    public String getText(String locatorType, String locatorName) {
        waitElementToBeVisable ( locatorType, locatorName );
        return getElement ( locatorType, locatorName ).getText ();

    }

    public void androidclickBackButton() {
        String selector = "searchString";
         driver().findElement ( MobileBy.AndroidUIAutomator ( "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(" + selector + "));" ) );

        ((AndroidDriver) driver()).pressKeyCode ( AndroidKeyCode.BACK );
    }

    public void androidScollToText(String scollToText) {

        getElement ( "ByAndroidUIAutomator", "new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(" + scollToText + "));" );

    }

    public Boolean isSelected(String locatorType, String locatorName) {
        waitElementToBeVisable ( locatorType, locatorName );
        return getElement ( locatorType, locatorName ).isSelected ();

    }


    public WebElement getElementFromList(String locatorType, String locatorName, String text) {
        waitElementToBeVisable ( locatorType, locatorName );
        List<WebElement> elementList = (List<WebElement>) getElement ( locatorType, locatorName );
        for (int i = 0; i <= elementList.size (); i++)
            if (elementList.get ( i ).getText ().contains ( text )) {
                return elementList.get ( i );
            }

        return null;
    }

    /**
     * click an element
     *
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void clickElement(String locatorType, String locatorName) {
        waitElementToBeClickAble ( locatorType, locatorName );
        getElement (   locatorType, locatorName ).click ();
    }

    /**
     * type an element
     *
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     * @param input
     */
    public void typeElement(String locatorType, String locatorName, String input) {
        waitElementToBeVisable ( locatorType, locatorName );
        getElement (   locatorType, locatorName ).sendKeys ( input );
    }

    public void clearElement(String locatorType, String locatorName) {
        waitElementToBeVisable ( locatorType, locatorName );
        getElement (   locatorType, locatorName ).clear ();
    }

    public void upLoadFile(String locatorType, String locatorName, String filePath) {

        waitElementToBeVisable ( locatorType, locatorName );

        getElement (   locatorType, locatorName ).sendKeys ( filePath );
    }

    /**
     * This Method for swipe up
     */
    public void swipeToUp() {
        int width = driver().manage ().window ().getSize ().width;
        int height = driver().manage ().window ().getSize ().height;
        TouchAction touchAction = new TouchAction ( driver() );
        touchAction.press ( width / 2, height * 3 / 4 ).moveTo ( width / 2, height / 4 ).release ().perform ();
        // wait for page loading
    }

    /**
     * This Method for swipe down
     */
    public void swipeToDown() {
        int width = driver().manage ().window ().getSize ().width;
        int height = driver().manage ().window ().getSize ().height;
        TouchAction touchAction = new TouchAction ( driver() );
        touchAction.press ( width / 2, height / 4 ).moveTo ( width / 2, height * 3 / 4 ).release ().perform ();
        // wait for page loading
    }

    /**
     * This Method for swipe Left
     */
    public void swipeToLeft() {
        int width =  driver().manage ().window ().getSize ().width;
        int height =  driver().manage ().window ().getSize ().height;
        TouchAction touchAction = new TouchAction ( driver() );
        touchAction.press ( width * 3 / 4, height / 2 ).moveTo ( width / 4, height / 2 ).release ().perform ();
        // wait for page loading
    }


    public void swipeToRight() {
        int width =  driver().manage ().window ().getSize ().width;
        int height =  driver().manage ().window ().getSize ().height;
        TouchAction touchAction = new TouchAction ( driver() );
        touchAction.press ( width / 4, height / 2 ).moveTo ( width * 3 / 4, height / 2 ).release ().perform ();

    }


    public void dragAndDrop(int startx, int starty, int endx, int endy) {

        try {
            TouchAction touchAction = new TouchAction ( driver() );
            log.info ( "设备： " +driver() + " " + " drag from ：" + startx + ":" + starty + "to" + endx + ":" + endy );

            touchAction.longPress ( startx, starty ).moveTo ( endx, endy ).release ().perform ();
        } catch (Exception e) {
            log.error ( "设备： " +driver() + " " + "drag faliue！" );
            throw e;
        }
    }

    public void longPress(String locatorType, String locatorName) {
        try {
            waitElementToBeClickAble ( locatorType, locatorName );
            TouchAction touchAction = new TouchAction ( driver() );
            log.info ( "设备： " + driver() + " " + "坐标长按：" + locatorName );

            touchAction.longPress ( getElement (   locatorType, locatorName ) ).release ().perform ();
        } catch (Exception e) {
            log.error ( "设备： " + driver() + " " + "长按控件失败！" );
            throw e;
        }
    }

    public void cancel() {

        TouchAction touchAction = new TouchAction ( driver() );
        touchAction.cancel ();
    }

    /**
     * @param locatorType : ID,XPATH,NAME,CLASSNAME,CSSSELECTOR,LINKTEXT,PARTIALLINKTEXT
     * @param locatorName : name of locator
     */
    public void waitElementToBeClickAble(final String locatorType, final String locatorName) {
        wait = new WebDriverWait ( driver(), TIMEOUT );
        wait.until ( ExpectedConditions.elementToBeClickable ( getElement (  locatorType, locatorName ) ) );
    }


    /**
     * @param locatorType
     * @param locatorName
     */
    public void waitElementToBeVisable(final String locatorType, final String locatorName) {
        wait = new WebDriverWait ( driver(), TIMEOUT );
        wait.until ( ExpectedConditions.visibilityOf ( getElement (  locatorType, locatorName ) ) );
    }


    /**
     * @param driver
     * @param locatorType
     * @param locatorName
     * @return
     */
    public String getTextString(  String locatorType, String locatorName) {
        waitElementToBeVisable ( locatorType, locatorName );
        return getElement (   locatorType, locatorName ).getText ();
    }

    /**
     * 显式等待，程序休眠暂停
     *
     * @param time 以秒为单位
     */
    public void sleep(long time) {
        try {
            Thread.sleep ( time * 1000 );
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }

    public void unlock() {
        if (((AndroidDriver) driver()).isLocked ())
            ((AndroidDriver) driver()).unlockDevice ();
    }

    public void lock() {
        if (((AndroidDriver) driver()).isLocked () == false)
            ((AndroidDriver) driver()).lockDevice ();
    }
}
