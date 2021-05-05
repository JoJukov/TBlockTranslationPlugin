package settings.impl;

import settings.PropertyManager;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class SettingPropertyManager implements PropertyManager {

    private Properties properties;

    public SettingPropertyManager(String propertiesPath){
        try {
            FileReader fileReader = new FileReader(propertiesPath);
            this.properties = new Properties();
            properties.load(fileReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }

    @Override
    public void setProperty(String propertyName, String propertyValue) {
        if (properties.containsKey(propertyName)) {
            properties.setProperty(propertyName, propertyValue);
        }
    }
}
