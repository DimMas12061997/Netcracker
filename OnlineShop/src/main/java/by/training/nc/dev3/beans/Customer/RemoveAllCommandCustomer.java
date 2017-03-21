package by.training.nc.dev3.beans.Customer;

public class RemoveAllCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.removeAllGoodsOrder();
    }
}