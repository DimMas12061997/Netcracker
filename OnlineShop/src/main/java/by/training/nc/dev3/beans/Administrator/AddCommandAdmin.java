package by.training.nc.dev3.beans.Administrator;


import by.training.nc.dev3.exceptions.MyException;

public class AddCommandAdmin extends ActCommand {
    @Override
    public void execute() throws MyException {
        acts.addGood();
    }
}