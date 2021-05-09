package com.zhuvar.tblock.settings.impl;

import com.zhuvar.tblock.settings.PropertyManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

public class SettingPropertyManager implements PropertyManager {

    private Properties properties;

    public SettingPropertyManager(String propertiesPath) {
        try {
            FileReader fileReader = new FileReader(propertiesPath);
            this.properties = new Properties();
            properties.load(fileReader);

        } catch (FileNotFoundException e) {
            System.err.println("Property file not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getProperty(String propertyName) throws NoSuchElementException {
        if (properties.containsKey(propertyName)) {
            return properties.getProperty(propertyName);
        }
        throw new NoSuchElementException(String.format("property with key %s not found", propertyName));
    }

    @Override
    public void setProperty(String propertyName, String propertyValue) {
        properties.setProperty(propertyName, propertyValue);
    }
}
