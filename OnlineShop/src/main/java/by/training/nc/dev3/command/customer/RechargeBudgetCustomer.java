package by.training.nc.dev3.command.customer;

/**
 * Created by Дмитрий on 01.04.2017.
 */
public class RechargeBudgetCustomer extends ActCustomer {
    @Override
    public void execute() {
        acts.rechargeBudget();
    }
}
