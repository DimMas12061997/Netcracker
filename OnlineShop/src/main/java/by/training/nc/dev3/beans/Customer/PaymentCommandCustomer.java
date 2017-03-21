package by.training.nc.dev3.beans.Customer;

public class PaymentCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.payOrder();
    }
}
