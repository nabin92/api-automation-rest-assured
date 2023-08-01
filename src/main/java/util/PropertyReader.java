package util;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    static Properties prop = new Properties();

    @SneakyThrows
    public static void loadProperties() {

        InputStream input = new FileInputStream("src/main/resources/config.properties");
        prop.load(input);
    }

    public static String getProperties(String property) {
        loadProperties();
        return prop.getProperty(property);
    }

    public static String getBaseUri()  {
        return getProperties("baseuri");
    }

    public static String getOrganization() {
        if (!System.getProperty("organization").isEmpty())
            return System.getProperty("organization");
        else
            return getProperties("organization");
    }

    public static String getPAT() {
        if (!System.getProperty("pat").isEmpty())
            return System.getProperty("pat");
        else
            return getProperties("pat");

    }
}
