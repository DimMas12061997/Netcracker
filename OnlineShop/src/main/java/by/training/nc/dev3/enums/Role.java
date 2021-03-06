package by.training.nc.dev3.enums;

import by.training.nc.dev3.beans.Administrator;
import by.training.nc.dev3.beans.Customer;
import by.training.nc.dev3.beans.Human;
import by.training.nc.dev3.tools.Operations;

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
