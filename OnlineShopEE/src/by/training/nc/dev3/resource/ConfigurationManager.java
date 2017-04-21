package by.training.nc.dev3.resource;

import java.util.ResourceBundle;

public class ConfigurationManager {
  private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("configs");

  private ConfigurationManager() {
  }

  public static String getProperty(String key) {
    return resourceBundle.getString(key);
  }
}