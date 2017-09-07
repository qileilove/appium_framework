package appium.untils;

import AppiumServerBuilder.AppiumBaseClass;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


/**
 * Created by lqi on 10/08/2017.
 */
public class LocateElement extends AppiumBaseClass{

public WebElement getElement( String locator, String localpath){
    WebElement MobileElement = null;

    switch (locator){
        case "ByXpath" :
            MobileElement=driver().findElement(By.xpath(localpath));
            break;
        case "ById":
            MobileElement=driver().findElement(By.id( localpath));
            break;
        case "ByCssSelector":
            MobileElement=driver().findElement(By.cssSelector( localpath));
            break;
        case "ByName":
            MobileElement=driver().findElement(By.name( localpath));
            break;
        case "ByClassName":
            MobileElement=driver().findElement(By.className( localpath));
            break;
        case "ByLinkText":
            MobileElement=driver().findElement(By.linkText( localpath));
            break;
        case "ByPartialLinkText":
            MobileElement=driver().findElement(By.partialLinkText( localpath));
            break;
        case "ByTagName":
            MobileElement=driver().findElement(By.tagName( localpath));
            break;
        case "ByIosNsPredicateString":
            MobileElement=driver().findElement(MobileBy.iOSNsPredicateString( localpath));
            break;
        case "ByIosUIAutomation":
            MobileElement=driver().findElement(MobileBy.IosUIAutomation( localpath));
            break;
        case "ByIosClassChain":
            MobileElement=driver().findElement(MobileBy.iOSClassChain( localpath));
            break;
        case "ByAndroidUIAutomator":
            MobileElement=driver().findElement(MobileBy.AndroidUIAutomator( localpath));
            break;
        case "ByAccessibilityId":
            MobileElement=driver().findElement(MobileBy.AccessibilityId( localpath));
            break;
    }
    return MobileElement;
}
}


