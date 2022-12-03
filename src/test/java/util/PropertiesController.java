package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesController {
    private String pathToEnvironmentFile = "src/main/resources/environment/test.properties";

    public String getProperty(String path) {

        Properties properties = new Properties();
        try (InputStream input = new FileInputStream(pathToEnvironmentFile)) {
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return properties.getProperty(path);
    }
}
