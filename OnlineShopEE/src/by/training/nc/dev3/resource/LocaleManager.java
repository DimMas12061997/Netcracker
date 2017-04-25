package by.training.nc.dev3.resource;


import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleManager {
    private static ResourceBundle resourceBundle;

    private LocaleManager() {
    }

    public static void setBundle(Locale locale){
        resourceBundle = ResourceBundle.getBundle("pagecontent", locale);
    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
