package by.training.nc.dev3.beans.Customer;

public class ViewCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.viewGoods();
    }
}