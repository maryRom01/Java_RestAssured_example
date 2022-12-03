package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesController {

    public String getMode() {
        String pathToModeFile = "src/main/resources/mode/mode.properties";
        Properties properties = new Properties();
        properties = loadProperties(properties, pathToModeFile);
        return properties.getProperty("mode");
    }

    public String getProperty(String mode, String path) {
        String pathToEnvironmentFile = String.format("src/main/resources/environment/%s/%s.properties", mode, mode);
        Properties properties = new Properties();
        properties = loadProperties(properties, pathToEnvironmentFile);
        return properties.getProperty(path);
    }

    private Properties loadProperties(Properties properties, String path) {
        try (InputStream input = new FileInputStream(path)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
