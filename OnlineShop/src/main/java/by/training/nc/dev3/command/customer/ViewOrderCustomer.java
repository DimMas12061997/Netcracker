package by.training.nc.dev3.command.customer;

public class ViewOrderCustomer extends ActCustomer {
    @Override
    public void execute() {
        acts.viewGoodsOrder();
    }
}
