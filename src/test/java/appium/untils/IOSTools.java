package appium.untils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lqi on 16/08/2017.
 */
public class IOSTools implements DevicesTools {


    @Override
    public void StartDevices(String device) {

    }

    @Override
    public void stopDevices(String device) {

    }

    public void stopDevices() throws IOException, InterruptedException {
        String cmd = "killall iOS Simulator";
         Runtime.getRuntime().exec(cmd);
//        pr.waitFor();
//        BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));
//        String line = "";
//        while ((line=buf.readLine())!=null) {
//            System.out.println(line);
//        }

    }
}
