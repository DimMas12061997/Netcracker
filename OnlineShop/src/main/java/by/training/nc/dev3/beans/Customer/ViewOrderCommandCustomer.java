package by.training.nc.dev3.beans.Customer;

public class ViewOrderCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.viewGoodsOrder();
    }
}
