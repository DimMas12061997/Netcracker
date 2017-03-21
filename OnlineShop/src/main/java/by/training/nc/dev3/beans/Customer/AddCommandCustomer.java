package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.exceptions.MyException;

public class AddCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() throws MyException {
        acts.addGoodOrder();
    }
}