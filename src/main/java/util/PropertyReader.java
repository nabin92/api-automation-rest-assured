package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {
    static Properties prop = new Properties();

    public static void loadProperties() throws IOException {

        InputStream input = new FileInputStream("src/main/resources/config.properties");
       prop.load(input);
    }

    public static String getProperties(String property) throws IOException {
        loadProperties();
        return prop.getProperty(property);
    }

    public static String getBaseUri() throws IOException {
        return getProperties("baseuri");
    }

    public static String getOrganization() throws IOException {
        if(!System.getProperty("organization").isEmpty())
            return System.getProperty("organization");
        else
            return getProperties("organization");
    }

    public static String getPAT() throws IOException {
        if(!System.getProperty("pat").isEmpty())
            return System.getProperty("pat");
        else
            return getProperties("pat");

    }
}
