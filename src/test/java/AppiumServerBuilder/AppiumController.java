package AppiumServerBuilder;

import Utility.Log;
import config.readyml;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by dwanniarachchi on 08/2/17.
 */
public class AppiumController {

    public static String executionOS = System.getProperty("platform");

    public static AppiumController instance = new AppiumController();

    readyml redy= new readyml ();

    public AppiumDriver <MobileElement> driver ;


    public void startAppiumServer() {

        CommandLine command = new CommandLine("/usr/local/bin/node");
        command.addArgument("/usr/local/bin/appium", false);
        command.addArgument("--address", false);
        command.addArgument("0.0.0.0");
        command.addArgument("--port", false);
        command.addArgument("4723");
        command.addArgument("--full-reset", false);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
        DefaultExecutor executor = new DefaultExecutor();
        executor.setExitValue(1);
        try {
            executor.execute(command, resultHandler);
            Thread.sleep(5000);
            Log.info("Appium server started successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            Log.error(e.getStackTrace().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.error(e.getStackTrace().toString());
        }
    }

    public void stopAppiumServer() {
        String[] command = { "/usr/bin/killall", "-KILL", "node" };
        try {
            Runtime.getRuntime().exec(command);
            Log.info("Appium server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
            //Utility.Log.error(e.getStackTrace().toString());
        }
    }

    public void start() throws MalformedURLException, FileNotFoundException {
        if (driver != null) {
            return;
        }
        switch(executionOS){
            case "ANDROID":
                File classpathRoot = new File(System.getProperty("user.dir"));
                File app = new File (classpathRoot, redy.getConfigeElement("app_path"));
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", redy.getConfigeElement("platformName"));
                capabilities.setCapability("deviceName", "192.168.59.101:5555");
                capabilities.setCapability("app", app.getAbsolutePath());
                capabilities.setCapability("fullReset", Boolean.valueOf(redy.getConfigeElement("fullReset")));
//                capabilities.setCapability("appPackage", "com.jayway.contacts");
//                capabilities.setCapability("appActivity", "com.jayway.contacts.MainActivity");
                driver = new AndroidDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case "IOS":
                classpathRoot = new File(System.getProperty("user.dir"));
                app = new File(classpathRoot, redy.getConfigeElement("app_path"));
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName",redy.getConfigeElement("platformName"));
                capabilities.setCapability("deviceName", redy.getConfigeElement("deviceName"));
                capabilities.setCapability("platformVersion",redy.getConfigeElement("platformVersion"));
                capabilities.setCapability("AutomationName", redy.getConfigeElement("platformVersion"));
                capabilities.setCapability("app", app.getAbsolutePath());
                driver = new IOSDriver<MobileElement> (new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
        }

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void stop() {
        if (driver != null) {
            driver.quit();
            driver = null;
            switch(executionOS) {
                case "ANDROID":

            }
            }
    }
}
