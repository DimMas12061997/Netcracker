package by.training.nc.dev3.command.user;


import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LoginPageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
 /* в случае ошибки или прямого обращения к контроллеру
  * переадресация на страницу ввода логина */
        String page = ConfigurationManager. getProperty("path.page.login");
        return page;
    }
}