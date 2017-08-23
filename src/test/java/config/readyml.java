package config;

import org.ho.yaml.Yaml;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by lqi on 21/08/2017.
 */
public class readyml {


    public static String executionOS = System.getProperty ( "platform" );



    public String getConfigeElement(String element) throws FileNotFoundException {
        File dumpFile = new File ( System.getProperty ( "user.dir" ) + "/src/test/java/config/config.yaml" );
        Config config = Yaml.loadType ( dumpFile, Config.class );

        HashMap<String, String> getChildName = new HashMap<> ();

        String platformName=null;

        if (executionOS.equalsIgnoreCase ( "ANDROID" )) {
            getChildName.putAll ( (Map<? extends String, ? extends String>) config.getAndroid ().get ( 0 ) );
            for (String key : getChildName.keySet ()) {
                if (key.equalsIgnoreCase ( element )) {
                    platformName=getChildName.get ( key );
                    return platformName;
                }
            }
        } else {
            getChildName.putAll ( (Map<? extends String, ? extends String>) config.getIos ().get ( 0 ) );

            for (String key : getChildName.keySet ()) {
                if (key.equalsIgnoreCase ( element )) {
                    platformName=getChildName.get ( key );
                    return platformName;
                }            }
        }
        return platformName;
    }
}




//
//        for (String key : getChildName.keySet()) {
//            System.out.printf ( getChildName.get(key));
//
//            if( key.equalsIgnoreCase ( "name")) {
//                System.out.printf ( getChildName.get(key));
//            }
//            }
//
//        }}


//        for (String value : getChildName.values ()) {
//
//            System.out.println("value = " + value);
//
//        }
//        for (String value : stringBuilder.()) {
//
//            System.out.println("Value = " + value);
//
//        }




