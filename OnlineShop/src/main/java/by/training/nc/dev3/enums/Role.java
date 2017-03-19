package by.training.nc.dev3.enums;

import by.training.nc.dev3.beans.Administrator.Administrator;
import by.training.nc.dev3.beans.Customer.Customer;
import by.training.nc.dev3.beans.Human;
import by.training.nc.dev3.tools.Operations;

/**
 * Created by Дмитрий on 18.03.2017.
 */
public enum Role {
    ADMINISTRATOR, CUSTOMER;

    public Human getRole() {
        switch (this) {
            case ADMINISTRATOR:
                return new Administrator(Operations.inputString(), Operations.inputString(), Operations.inputString());
            case CUSTOMER:
                return new Customer(Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputString(), Operations.inputNumber());
            default:
                return null;
        }
    }
}
