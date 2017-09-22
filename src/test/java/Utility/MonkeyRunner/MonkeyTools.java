package Utility.MonkeyRunner;

import com.android.chimpchat.adb.AdbBackend;
import com.android.chimpchat.core.IChimpDevice;
import com.android.chimpchat.hierarchyviewer.HierarchyViewer;

/**
 * Created by lqi on 20/09/2017.
 */


public class MonkeyTools {
    public static  HierarchyViewer hierarchyViewer = null;

    public static IChimpDevice ConnentDevices() {
        IChimpDevice device = new AdbBackend().waitForConnection();
        return  device;

    }
    public void TakeSreenShot(IChimpDevice device ,String fileName){
        device.takeSnapshot().writeToFile(fileName, null);
    }

    public static void main(String[] args) {

        // sdk/platform-tools has to be in PATH env variable in order to find adb
        IChimpDevice device = new AdbBackend().waitForConnection();

        // Print Device Name
        System.out.println(device.getProperty("build.model"));

        // Take a snapshot and save to out.png
        device.takeSnapshot().writeToFile("out.png", null);
        hierarchyViewer.findViewById ( "dd" );
        device.dispose();
    }
}

