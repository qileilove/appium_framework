package appium.untils;

import java.io.IOException;

/**
 * Created by lqi on 15/08/2017.
 */
public class AndroidTools {

    public static String adb = "adb";
    public static String emulator = "emulator";

    public static void StartDevices(String device) {
        ProcessBuilder pb1 = new ProcessBuilder(emulator,"-avd",device);
        try {
            pb1.start();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static void stopDevices(String device) {
            ProcessBuilder pb1 = new ProcessBuilder(adb,"-s",device, "emu","kill");
        try {
            pb1.start();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
