package by.training.nc.dev3.command;

public class ViewOrderCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.viewGoodsOrder();
    }
}