package by.training.nc.dev3.command.user;


import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.constants.Parameters;
import by.training.nc.dev3.resource.ConfigurationManager;
import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
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
        try {
            session.setAttribute("title", new String((LocaleManager.getProperty("label.title").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("submit", new String((LocaleManager.getProperty("button.submit").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("catalog", new String((LocaleManager.getProperty("menu.catalog").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("search", new String((LocaleManager.getProperty("button.search").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("searchGood", new String((LocaleManager.getProperty("placeholder.searchGood").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("entrance", new String((LocaleManager.getProperty("menu.entrance").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("registration", new String((LocaleManager.getProperty("menu.registration").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderLogin", new String((LocaleManager.getProperty("placeholder.login").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderPassword", new String((LocaleManager.getProperty("placeholder.password").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderName", new String((LocaleManager.getProperty("placeholder.name").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderSurname", new String((LocaleManager.getProperty("placeholder.surname").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("placeholderRepeatPassword", new String((LocaleManager.getProperty("placeholder.repeatPassword").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("descriptionShop", new String((LocaleManager.getProperty("label.descriptionShop").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("basket", new String((LocaleManager.getProperty("menu.basket").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("myProfile", new String((LocaleManager.getProperty("menu.myProfile").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("logout", new String((LocaleManager.getProperty("menu.logout").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("edit", new String((LocaleManager.getProperty("menu.edit").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("users", new String((LocaleManager.getProperty("menu.users").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("managingBlackList", new String((LocaleManager.getProperty("menu.managingBlackList").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("purchaseHistory", new String((LocaleManager.getProperty("menu.purchaseHistory").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("shopManagement", new String((LocaleManager.getProperty("menu.shopManagement").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("personalData", new String((LocaleManager.getProperty("label.personalData").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("emailLabel", new String((LocaleManager.getProperty("label.email").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("addressLabel", new String((LocaleManager.getProperty("label.address").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("budgetLabel", new String((LocaleManager.getProperty("label.budget").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("creditNumberLabel", new String((LocaleManager.getProperty("label.creditNumber").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("save", new String((LocaleManager.getProperty("button.save").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("editData", new String((LocaleManager.getProperty("label.editData").getBytes("ISO-8859-1")), "Cp1251"));
            session.setAttribute("dateLabel", new String((LocaleManager.getProperty("label.date").getBytes("ISO-8859-1")), "Cp1251"));


        } catch (UnsupportedEncodingException e) {
            System.out.println("Encoding exception");
        }
        page = ConfigurationManager.getProperty(nextPage);
        return page;
    }
}
