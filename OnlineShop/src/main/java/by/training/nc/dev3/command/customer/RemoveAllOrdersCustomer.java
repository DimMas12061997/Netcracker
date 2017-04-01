package by.training.nc.dev3.command.customer;

public class RemoveAllOrdersCustomer extends ActCustomer {
    @Override
    public void execute() {
        acts.removeAllGoodsOrder();
    }
}