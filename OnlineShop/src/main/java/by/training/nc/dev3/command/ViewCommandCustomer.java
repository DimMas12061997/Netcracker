package by.training.nc.dev3.command;

public class ViewCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.viewGoods();
    }
}