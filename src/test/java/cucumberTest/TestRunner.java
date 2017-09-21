package cucumberTest;

/**
 * Created by dwanniarachchi on 30/1/17.
 */

import AppiumServerBuilder.AppiumController;
import Utility.Log;
import appium.untils.AndroidTools;
import appium.untils.DevicesTools;
import appium.untils.IOSTools;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import java.io.IOException;
import java.net.MalformedURLException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Feature"
        ,glue = {"stepDefinition"}
        ,tags = {"@Test"}
        ,format = {"pretty","json:target/cucumber.json"}
)

public class TestRunner {
    public static String executionOS = System.getProperty("platform");
     static AndroidTools android= new AndroidTools();
    static IOSTools ios=new IOSTools ();

    @BeforeClass
    public static void launchAppiumServer() throws MalformedURLException {

        DOMConfigurator.configure ( "log4j.xml" );
        Log.info ("lanch appium");
        if(executionOS.equalsIgnoreCase ( "ANDROID" )){
            android.StartDevices ( "test" );
        }

        AppiumController.instance.startAppiumServer();
    }

    @AfterClass
    public  static void killAppiumServer() throws IOException, InterruptedException {
        Log.info ( "E-N-D" );
        if(executionOS.equalsIgnoreCase ( "ANDROID" )){
            android.stopDevices ( "emulator-5554" );
        }
        else {
            ios.stopDevices( );
        }
        AppiumController.instance.stopAppiumServer();
    }
}


