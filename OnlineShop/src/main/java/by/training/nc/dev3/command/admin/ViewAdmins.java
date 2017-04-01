package by.training.nc.dev3.command.admin;

import by.training.nc.dev3.exceptions.MyException;

/**
 * Created by Дмитрий on 01.04.2017.
 */
public class ViewAdmins extends ActAdmin {
    @Override
    public void execute() throws MyException {
        acts.viewAdmins();
    }
}
