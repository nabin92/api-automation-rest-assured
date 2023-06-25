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
}
