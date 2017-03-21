package by.training.nc.dev3.beans.Customer;

import by.training.nc.dev3.interfaces.Command;

import java.io.Serializable;

public abstract class ActCommandCustomer implements Command, Serializable{
    protected CustomerActs acts = new CustomerActs();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActCommandCustomer that = (ActCommandCustomer) o;

        return acts != null ? acts.equals(that.acts) : that.acts == null;

    }

    @Override
    public int hashCode() {
        return acts != null ? acts.hashCode() : 0;
    }
}
