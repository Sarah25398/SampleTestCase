package Utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetKeyProperties {


    private static final Properties properties = new Properties();
    static
    {
        try {
            FileInputStream fis = new FileInputStream("C:\\Users\\vela.os010\\IdeaProjects\\SampleSeleniumProject\\src\\main\\java\\Resources\\config.properties");
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
    public static String getBaseUrl(String keyEvn){

        return properties.getProperty(keyEvn);

    }
    public static String getUserName(){
        return properties.getProperty(".userName");
    }
    public static String getPassWord(){
        return properties.getProperty( ".passWord");
    }
    public static void main(String args[]){
        System.out.println(getBaseUrl(""));
        System.out.println(getUserName());
        System.out.println(getPassWord());
    }


}
