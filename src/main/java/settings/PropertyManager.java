package settings;

import java.util.NoSuchElementException;

public interface PropertyManager {

    String getProperty(String propertyName) throws NoSuchElementException;

    void setProperty(String propertyName, String propertyValue);
}
