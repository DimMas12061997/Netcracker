package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.exceptions.MyException;

public class RemoveCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() throws MyException {
        acts.removeGoodOrder();
    }
}