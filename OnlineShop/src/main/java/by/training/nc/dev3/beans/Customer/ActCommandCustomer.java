package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.beans.Administrator.AdminActs;
import by.training.nc.dev3.interfaces.Command;

/**
 * Created by Дмитрий on 20.03.2017.
 */
public abstract class ActCommandCustomer implements Command {
    protected CustomerActs acts = new CustomerActs();
}
