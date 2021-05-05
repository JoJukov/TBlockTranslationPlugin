package settings;

public interface PropertyManager {

    String getProperty(String propertyName);

    void setProperty(String propertyName, String propertyValue);
}
