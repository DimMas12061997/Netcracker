package by.training.nc.dev3.command.customer;

import by.training.nc.dev3.service.CustomerActs;
import by.training.nc.dev3.interfaces.Command;

import java.io.Serializable;

public abstract class ActCustomer implements Command, Serializable{
    protected CustomerActs acts = new CustomerActs();
}
