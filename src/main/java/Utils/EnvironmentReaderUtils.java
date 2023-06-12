package Utils;

import java.io.IOException;
import java.util.Properties;

public class EnvironmentReaderUtils {

    private static Properties props = new Properties();

    static {
        String envFile = System.getProperty("env");
        if(envFile == null){
            envFile = "production";
        }
        String filePath = envFile.concat(".properties");

        try {
            props.load(EnvironmentReaderUtils.class.getClassLoader().getResourceAsStream(filePath));
        } catch (IOException e) {
            System.out.println("Cant read properties file");
            throw new RuntimeException(e);
        }
    }

    public static String getProps(String key) {
        return props.getProperty(key);
    }
}
