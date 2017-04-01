package by.training.nc.dev3.command.customer;

import by.training.nc.dev3.exceptions.MyException;

public class AddOrderCustomer extends ActCustomer {
    @Override
    public void execute() throws MyException {
        acts.addGoodOrder();
    }
}