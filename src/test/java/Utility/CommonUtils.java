package Utility;

import java.io.IOException;

/**
 * Created by lqi on 19/09/2017.
 */
public class CommonUtils {

    public static void executeShell(String script) throws IOException {
        if(System.getProperty("os.name").toLowerCase().startsWith("windows")) {
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("cmd /c start " + script);
        }
        else{
            Runtime.getRuntime()
                    .exec(String.format("sh -c ls %s", script));
        }
    }

    /**
     * 显式等待，程序休眠暂停
     * @param time 以秒为单位
     */
    public static void sleep(long time){
        try {
            Thread.sleep(time*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
