package by.training.nc.dev3.command.user;

import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements ActionCommand {
@Override
public String execute(HttpServletRequest request) {
 String page = ConfigurationManager. getProperty("path.page.index");
 request.getSession().invalidate();
 return page;
}
}