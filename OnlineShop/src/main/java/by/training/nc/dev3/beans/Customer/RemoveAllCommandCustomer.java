package by.training.nc.dev3.beans.Customer;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class RemoveAllCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.removeAllGoodsOrder();
    }
}