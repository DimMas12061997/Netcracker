package by.training.nc.dev3.command.admin;

import by.training.nc.dev3.exceptions.MyException;

public class RemoveGoodsAdmin extends ActAdmin {
    @Override
    public void execute() throws MyException {
        acts.removeGood();
    }
}
