package Utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetKeyProperties {


    private static final Properties properties = new Properties();
    private static final String environment = getEvnProperty();
    static
    {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\vela.os010\\IdeaProjects\\SampleSeleniumProject\\src\\main\\java\\Resources\\config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getEvnProperty(){
        return properties.getProperty("env", "dev2").toLowerCase();
    }
    public static String getBaseUrl(){

        return properties.getProperty(environment + ".baseUrl");

    }
    public static String getUserName(){
        return properties.getProperty(environment+ ".userName");
    }
    public static String getPassWord(){
        return properties.getProperty(environment+ ".passWord");
    }
    public static void main(String args[]){
        System.out.println(getBaseUrl());
        System.out.println(getUserName());
        System.out.println(getPassWord());
    }


}
