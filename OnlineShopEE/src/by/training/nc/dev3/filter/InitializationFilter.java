package by.training.nc.dev3.filter;

import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Locale;


@WebFilter(urlPatterns = {"/controller", "/index.jsp"}, servletNames = {"Controller"})
public class InitializationFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        ClientType type = (ClientType) session.getAttribute("userType");
        if (type == null) {
            type = ClientType.GUEST;
            session.setAttribute("userType", type);
        }
        Locale locale = (Locale) session.getAttribute("locale");
        if (locale == null || new Locale("ru", "RU").equals(locale)) {
            session.setAttribute("locale", new Locale("ru", "RU"));
            session.setAttribute("localeLang", "ru");
            Locale russianLocale = new Locale("ru", "RU");
            LocaleManager.setBundle(russianLocale);
            LocaleManager.fillSession(session);
        }
        chain.doFilter(request, response);
        return;
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
