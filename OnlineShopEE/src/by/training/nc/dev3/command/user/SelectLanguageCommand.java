package by.training.nc.dev3.command.user;


import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;

public class SelectLanguageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = null;
        HttpSession session = request.getSession();
        String language = request.getParameter(Parameters.LANGUAGE);
        String nextPage = request.getParameter("page");
        Locale locale = null;
        if ("RU".equals(language))
            locale = new Locale("ru", "RU");
        else if ("EN".equals(language))
            locale = new Locale("en", "US");
        session.setAttribute("locale", locale);
        LocaleManager.setBundle((Locale) session.getAttribute("locale"));
        LocaleManager.fillSession(session);
        page = ConfigurationManager.getProperty(nextPage);
        return page;
    }
}
