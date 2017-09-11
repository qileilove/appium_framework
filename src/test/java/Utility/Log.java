package Utility;

import Report.TestListener;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * Created by Don Dilanka on 23/05/2016.
 */
public class Log {

    private final Class<?> clazz;
    private  Logger logger;
    static String projectRootPath = new File(System.getProperty("user.dir")).getPath().concat("/");
    static String src="test-output/log";
    //设置日期格式
    static SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    //获取当前日期
    static String date=dateFormat.format(new Date()).toString();

    /**
     *
     * @param clazz 获取当前类
     */
    public Log(Class<?> clazz){
        this.clazz=clazz;
        //Logger.getLogger的方法是调用的是LogManager.getLogger()方法，所以这两个方法都是返回logger
        this.logger=Logger.getLogger(this.clazz);
        Log.initlog4j();
    }
    //初始化log4j，设置log4j的配置文件log4j.Properties
    private static  void initlog4j(){
        //创建Propderties对象
        Properties prop=new Properties();
		/*Log4j建议只使用四个级别，优先级从高到低分别是ERROR、WARN、INFO、DEBUG
	   这里定义能显示到的最低级别,若定义到INFO级别,则看不到DEBUG级别的信息了~!级别后面是输出端*/
        prop.setProperty("log4j.rootLogger", "INFO,CONSOLE,E,F");
        prop.setProperty("log4j.appender.CONSOLE", "org.apache.log4j.ConsoleAppender");
        prop.setProperty("log4j.appender.CONSOLE.layout", "org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.CONSOLE.layout.ConversionPattern", "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");
        File dir = new File(projectRootPath+src);
        String filepath=dir.getAbsolutePath()+"/"+"log_"+date+".log";

        prop.setProperty("log4j.appender.E","org.apache.log4j.FileAppender");
        prop.setProperty("log4j.appender.E.file",filepath);
        prop.setProperty("log4j.appender.E.layout","org.apache.log4j.PatternLayout");
        prop.setProperty("log4j.appender.E.layout.ConversionPattern", "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");

        prop.setProperty("log4j.appender.F","org.apache.log4j.FileAppender");

        String filepathHtml=dir.getAbsolutePath()+"/"+"log_"+date+".html";
        prop.setProperty("log4j.appender.F.file",filepathHtml);
        prop.setProperty("log4j.appender.F.layout","org.apache.log4j.HTMLLayout");
        //prop.setProperty("log4j.appender.F.layout.ConversionPattern", "[%d{YYYY-MM-dd HH:mm:ss,SSS}] %-5p %c %m%n");

        PropertyConfigurator.configure(prop);
    }


    // Need to create these methods, so that they can be called
    public static void info(String message) {
        Log.info(message);
    }
    public static void warn(String message) {
        Log.warn(message);
    }
    public static void error(String message) {
        Log.error(message);
    }
    public static void fatal(String message) {
        Log.fatal(message);
    }
    public static void debug(String message) {
        Log.debug(message);
    }
}
