package automation.example.framework.properties;

import java.io.IOException;
import java.util.Properties;

// this class reads property file
//DONE
public class PropertyResolver {

    public static final String BROWSER_NAME = "browser";
    public static final String BASE_URL = "application.url";

    private PropertyResolver() {
    }

    public static String getProperty(final String name) {

        try {
            final Properties props = new Properties();
            props.load(PropertyResolver.class.getResourceAsStream("/testConfig.properties"));

            final String property = props.getProperty(name);
            if (property == null) {
                throw new IllegalArgumentException("Could not read property with name: " + name);
            }
            return property;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
