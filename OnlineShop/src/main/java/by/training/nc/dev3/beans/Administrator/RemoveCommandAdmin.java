package by.training.nc.dev3.beans.Administrator;

import by.training.nc.dev3.exceptions.MyException;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class RemoveCommandAdmin extends ActCommand {
    @Override
    public void execute() throws MyException {
        acts.removeGood();
    }
}
