package datareader.impl;

import datareader.PropertyReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ProxyPropertyReader implements PropertyReader {

    private final Properties properties;

    public ProxyPropertyReader() throws IOException {
        FileReader fileReader = new FileReader("proxy.properties");
        this.properties = new Properties();
        properties.load(fileReader);
    }

    @Override
    public String getProperty(String propertyName) {
        return properties.getProperty(propertyName);
    }
}
