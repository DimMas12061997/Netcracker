package by.training.nc.dev3.command.factory;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.resource.LocaleManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public class ActionFactory {
    public ActionCommand defineCommand(HttpServletRequest request) {
        ActionCommand current = null;
        HttpSession session = request.getSession(true);
        String action = request.getParameter("command");
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(action.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            LocaleManager.setBundle((Locale) session.getAttribute("locale"));
            try {
                session.setAttribute("wrongAction", action + new String((LocaleManager.getProperty("message.wrongaction").getBytes("ISO-8859-1")), "Cp1251"));
            } catch (UnsupportedEncodingException e1) {
                System.out.println("Encoding exception");
            }
        }
        return current;
    }
}