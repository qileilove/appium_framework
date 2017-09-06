package appium.untils;

import AppiumServerBuilder.AppiumBaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lqi on 07/09/2017.
 */
public class GetScreenShot extends AppiumBaseClass {

    public  void getScreenShot() {
        File screenshot = driver ()
                .getScreenshotAs ( OutputType.FILE );


        new File ( "screenshots/Failures" ).mkdirs ();
        DateFormat dateFormat = new SimpleDateFormat ( "dd-MMM-yyyy__hh_mm_ssaa" );

        String destFile = dateFormat.format ( new Date () ) + ".png";


        try {
            // Store file at destination folder location
            FileUtils.copyFile ( screenshot, new File ( "screenshots/Failures" + "/" + destFile ) );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
