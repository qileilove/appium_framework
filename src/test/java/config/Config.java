package config;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by lqi on 21/08/2017.
 */
public class Config {
    private String app_path;

    @Override
    public String toString() {
        return "Config{" +
                "app_path='" + app_path + '\'' +
                ", platformName='" + platformName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", fullReset='" + fullReset + '\'' +
                ", android=" + android +
                '}';
    }

    private String platformName;
    private String deviceName;
    private String fullReset;
    private LinkedList<HashMap> android = new LinkedList<HashMap>();

    public LinkedList<HashMap> getIos() {
        return ios;
    }

    public void setIos(LinkedList<HashMap> ios) {
        this.ios = ios;
    }

    private LinkedList<HashMap> ios = new LinkedList<HashMap>();


    public String getApp_path() {
        return app_path;
    }

    public void setApp_path(String app_path) {
        this.app_path = app_path;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getFullReset() {
        return fullReset;
    }

    public void setFullReset(String fullReset) {
        this.fullReset = fullReset;
    }

    public LinkedList<HashMap> getAndroid() {
        return android;
    }

    public void setAndroid(LinkedList<HashMap> android) {
        this.android = android;
    }




}
