package by.training.nc.dev3.command.customer;

public class ViewGoodsCustomer extends ActCustomer {
    @Override
    public void execute() {
        acts.viewGoods();
    }
}