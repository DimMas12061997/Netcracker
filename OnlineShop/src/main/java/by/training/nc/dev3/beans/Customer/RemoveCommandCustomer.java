package by.training.nc.dev3.beans.Customer;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public class RemoveCommandCustomer extends ActCommandCustomer {
    @Override
    public void execute() {
        acts.removeGoodOrder();
    }
}