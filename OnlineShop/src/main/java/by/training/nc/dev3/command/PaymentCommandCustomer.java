package by.training.nc.dev3.command;

import by.training.nc.dev3.exceptions.MyException;

public class PaymentCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() throws MyException {
        acts.payOrder();
    }
}
