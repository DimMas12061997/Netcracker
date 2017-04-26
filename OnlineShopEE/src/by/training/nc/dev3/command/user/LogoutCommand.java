package by.training.nc.dev3.command.user;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class LogoutCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager.getProperty("path.page.index");
        HttpSession session1 = request.getSession();
        Locale locale = (Locale) session1.getAttribute("locale");
        Locale russianLocale = null;
        if (locale == null || new Locale("ru", "RU").equals(locale)) {
            russianLocale = new Locale("ru", "RU");
        } else
            russianLocale = new Locale("en", "US");
        request.getSession().invalidate();
        HttpSession session = request.getSession();
        LocaleManager.setBundle(russianLocale);
        LocaleManager.fillSession(session);
        return page;
    }
}