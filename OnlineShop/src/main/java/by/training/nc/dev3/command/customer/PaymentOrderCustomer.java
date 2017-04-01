package by.training.nc.dev3.command.customer;

import by.training.nc.dev3.exceptions.MyException;

public class PaymentOrderCustomer extends ActCustomer {
    @Override
    public void execute() throws MyException {
        acts.payOrder();
    }
}
