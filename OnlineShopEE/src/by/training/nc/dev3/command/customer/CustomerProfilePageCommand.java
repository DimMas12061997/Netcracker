package by.training.nc.dev3.command.customer;


import by.training.nc.dev3.command.ActionCommand;
import by.training.nc.dev3.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;

public class CustomerProfilePageCommand implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = ConfigurationManager. getProperty("path.page.customerProfile");
        return page;
    }
}
