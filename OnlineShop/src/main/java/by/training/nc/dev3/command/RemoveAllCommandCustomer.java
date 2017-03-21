package by.training.nc.dev3.command;

public class RemoveAllCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.removeAllGoodsOrder();
    }
}