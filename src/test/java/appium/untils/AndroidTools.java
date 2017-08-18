package appium.untils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

/**
 * Created by lqi on 15/08/2017.
 */
public class AndroidTools implements DevicesTools{

    public static String adb = "adb";
    public static String emulator = "emulator";
    @Override
    public  void StartDevices(String device) {
        String[] startCommand = new String[] { emulator, "-avd",device };

        Process pb1 = null;
        try {
            pb1 = new ProcessBuilder(startCommand).start ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
        try {

            String[] commandBootAnim = new String[] { adb, "shell", "getprop", "init.svc.bootanim" };
            Process process = new ProcessBuilder(commandBootAnim).start();
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String text = inputStream.readLine();

            System.out.printf ( "++++++++++++++++++++++++++++++++++++++"+text );
            // wait till the property returns 'stopped'
            while (!inputStream.readLine().equals("stopped")) {
                process.waitFor(1, TimeUnit.SECONDS);
                process = new ProcessBuilder(commandBootAnim).start();
                inputStream = new BufferedReader(new InputStreamReader(process.getInputStream()));
            }

            System.out.println("Emulator is ready to use!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public  void stopDevices(String device) {
            ProcessBuilder pb1 = new ProcessBuilder(adb,"-s",device, "emu","kill");
        try {
            pb1.start();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }


}
